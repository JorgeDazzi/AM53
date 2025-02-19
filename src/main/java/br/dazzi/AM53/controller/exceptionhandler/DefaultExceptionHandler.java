package br.dazzi.AM53.controller.exceptionhandler;


import br.dazzi.AM53.controller.error.ErrorMessage;
import br.dazzi.AM53.controller.error.ErrorResponse;
import br.dazzi.AM53.domain.exception.APIException;
import br.dazzi.AM53.domain.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ControllerAdvice
public class DefaultExceptionHandler {

    Logger logger = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    //This going to handle any Exception which was not predicted
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleError(Exception exception, HttpServletRequest request) {
        logger.error("Unknown error", exception);
        return getDefaultResponseMessage(request);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(NotFoundException notFoundException, HttpServletRequest request) {
        return buildErrorResponse(notFoundException, HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleSpringValidation(MethodArgumentNotValidException methodArgumentNotValidException, HttpServletRequest request) {

        Set<ErrorMessage> msgs = methodArgumentNotValidException
                .getBindingResult()
                .getAllErrors()
                .stream()
                .map(
                        error -> new ErrorMessage(
                                HttpStatus.BAD_REQUEST.value(),
                                HttpStatus.BAD_REQUEST.name(),
                                error.getDefaultMessage()
                        )
                ).collect(Collectors.toSet());

        return new ResponseEntity<>(
                new ErrorResponse(msgs),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorResponse> handleSpringPathValidation(MissingServletRequestParameterException exception, HttpServletRequest request) {


        List<ErrorMessage> msgs = List.of(new ErrorMessage(
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.name(),
                exception.getLocalizedMessage())
        );

        return new ResponseEntity<>(
                new ErrorResponse(msgs),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleSpringKeys(DataIntegrityViolationException exception, HttpServletRequest request) {

        String[] field = exception.getMostSpecificCause().getLocalizedMessage().split("\"");
        List<ErrorMessage> msgs = List.of(new ErrorMessage(
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.name(),
                field.length > 1 ? field[1] : exception.getLocalizedMessage())
        );

        return new ResponseEntity<>(
                new ErrorResponse(msgs),
                HttpStatus.BAD_REQUEST
        );
    }

    private ResponseEntity<ErrorResponse> buildErrorResponse(APIException exception, HttpStatus httpStatus, HttpServletRequest request) {
        try {
            List<ErrorMessage> errorMessages = List.of(new ErrorMessage(exception.getCode(), exception.getDescription(), exception.getMessage()));
            return new ResponseEntity<>(new ErrorResponse(errorMessages), httpStatus);
        } catch (Exception e) {
            return getDefaultResponseMessage(request);
        }
    }

    private ResponseEntity<ErrorResponse> getDefaultResponseMessage(HttpServletRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(500, "internal_error", "Internal Error");
        return new ResponseEntity<>(new ErrorResponse(List.of(errorMessage)), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
