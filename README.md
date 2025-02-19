AM53
======

Back-End
-------

- [x] Definir o modelo de dados no PostgreSQL;
- [x] Definir serviços para a inserção em batch (usando o arquivo de logs fornecido, usando JPA);
- [x] Definir serviços para a inserção de logs manuais (CRUD);
- [x] Implementar filtros ou pesquisas de logs;
- [x] (BÔNUS) Testes automatizados;


PosgresSQL Schema
-------

![Postgres SQL Schema](https://i.ibb.co/0tY2080/Screenshot-2020-05-19-at-19-47-46.png)


```postgres-sql
CREATE TABLE IF NOT EXISTS logs(
  id bigserial PRIMARY KEY,
  date TIMESTAMP NULL,
  ip VARCHAR(16) NULL,
  request VARCHAR(55) NULL,
  status INT NULL,
  user_agent VARCHAR(255) NULL
);
```
Executando o projeto
-------
Para executar o projeto, __clone o repositório__ e execute __docker-compose up__

Pré-requisitos
-------
- Docker instalado

Documentação e exemplos
-------
A documentação da API está em OpenApi(Swagger), no endereço http://localhost:8080/api-doc.html

Front-End
-------
A documentação do Front-End pode ser acessado pelo endereço https://github.com/JorgeDazzi/AM53_Front-End
