package br.dazzi.AM53.controller;

import br.dazzi.AM53.Am53Application;
import br.dazzi.AM53.controller.request.LogRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.print.attribute.standard.Media;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("Test-Logs")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Am53Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LogControllerTest {

    private final static String URI = "/logs";

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeAll
    void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    @Order(1)
    void findAllWhenItIsEmpty() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(URI+"/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(0)));

    }

    @Test
    @Order(2)
    void findNonExistentId() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(URI+"/{id}", 7))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.error_list").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.error_list[0].code").value(404));
    }

    @Test
    @Order(3)
    void addWithWrongIpFormat() throws Exception {
        LogRequest logRequest = new LogRequest()
                .status(200)
                .userAgent("Goggle Chrome 600")
                .request("Http 1.1 GET")
                .ip("155.2.2.2.2");

        this.mockMvc.perform(
                    MockMvcRequestBuilders.post(URI+"/")
                    .accept(MediaType.APPLICATION_JSON)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(asJsonString(logRequest))
                )
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.error_list").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.error_list[0].code").value(400))
                .andExpect(MockMvcResultMatchers.jsonPath("$.error_list[0].message").value("Field ip must be a Ipv4 format"));
    }

    @Test
    @Order(4)
    void addWithWrongDateFormat() throws Exception {
        LogRequest logRequest = new LogRequest()
                .date("2020-05-16 21:29:45.6666")
                .status(200)
                .userAgent("Goggle Chrome 600")
                .request("Http 1.1 GET")
                .ip("155.2.2.2");

        this.mockMvc.perform(
                MockMvcRequestBuilders.post(URI+"/")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(logRequest))
        )
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.error_list").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.error_list[0].code").value(400))
                .andExpect(MockMvcResultMatchers.jsonPath("$.error_list[0].message").value("Field date must be a date in format yyyy-MM-dd HH:mm:ss.SSS"));
    }

    @Test
    @Order(5)
    void addWithUserAgentBiggerThan255Chars() throws Exception {
        LogRequest logRequest = new LogRequest()
                .date("2020-05-16 21:29:45.666")
                .status(200)
                .userAgent("")
                .request("Http 1.1 GET")
                .ip("155.2.2.2");

        this.mockMvc.perform(
                MockMvcRequestBuilders.post(URI+"/")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(logRequest))
        )
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.error_list").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.error_list[0].code").value(400))
                .andExpect(MockMvcResultMatchers.jsonPath("$.error_list[0].message").value("Field user_agent must have between 1 and 255 characters."));

        this.mockMvc.perform(
                MockMvcRequestBuilders.post(URI+"/")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(logRequest.userAgent("B".repeat(256))))
        )
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.error_list").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.error_list[0].code").value(400))
                .andExpect(MockMvcResultMatchers.jsonPath("$.error_list[0].message").value("Field user_agent must have between 1 and 255 characters."));
    }

    @Test
    @Order(6)
    void add() throws Exception {
        LogRequest logRequest = new LogRequest()
                .date("2020-05-16 21:29:45.666")
                .status(200)
                .userAgent("Safari Edge")
                .request("Http 1.1 GET")
                .ip("155.2.2.2");

        this.mockMvc.perform(
                MockMvcRequestBuilders.post(URI+"/")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(logRequest))
        )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.ip").value(logRequest.ip()));

        this.mockMvc.perform(
                MockMvcRequestBuilders.post(URI+"/")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(logRequest))
        )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.ip").value(logRequest.ip()));
    }


    @Test
    @Order(7)
    void removeNonExistentId() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete(URI + "/{id}", 89))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    @Order(8)
    void remove() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete(URI + "/{id}", 2))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @Order(9)
    void updateNonExistentId() throws Exception {
        LogRequest logRequest = new LogRequest()
                .id((long) 89)
                .date("2020-05-16 21:29:45.666")
                .status(200)
                .userAgent("Safari Edge")
                .request("Http 1.1 GET")
                .ip("155.2.2.2");

        this.mockMvc.perform(MockMvcRequestBuilders.put(URI + "/").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(asJsonString(logRequest)))
                .andDo(print())
                .andExpect(status().isNotFound());

        this.mockMvc.perform(MockMvcRequestBuilders.get(URI+"/{id}",89))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    @Order(10)
    void update() throws Exception {
        LogRequest logRequest = new LogRequest()
                .id((long) 1)
                .date("2020-05-16 21:29:45.222")
                .status(200)
                .userAgent("Safari Edge")
                .request("Http 1.1 GET")
                .ip("155.2.2.188");

        this.mockMvc.perform(MockMvcRequestBuilders.put(URI + "/").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(asJsonString(logRequest)))
                .andDo(print())
                .andExpect(status().isOk());

        this.mockMvc.perform(MockMvcRequestBuilders.get(URI+"/{id}",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.date").value(logRequest.date()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.ip").value(logRequest.ip()));

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}