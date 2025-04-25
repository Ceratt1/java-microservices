# 🛠️ Product Service API

🚧 **Projeto em construção!** 🚧

---

## 🧩 Visão Geral

Esta API faz parte de um **ecossistema de microsserviços** em desenvolvimento, com o objetivo de fornecer uma infraestrutura moderna, escalável e desacoplada para gerenciar produtos em um sistema distribuído.

Ela utiliza o **RabbitMQ como broker de mensagens**, facilitando a comunicação entre serviços de forma assíncrona e resiliente.

---

## 🧪 Tecnologias Utilizadas

- 🔹 **Java 17**
- 🔹 **Spring Boot**
- 🔹 **MongoDB** (armazenamento de produtos)
- 🔹 **MySQL** (armazenamento relacional em outros serviços)
- 🔹 **RabbitMQ** (mensageria entre serviços)
- 🔹 **Spring Data** (MongoDB e JPA)
- 🔹 **Spring Validation**
- 🔹 **Springdoc OpenAPI** (documentação Swagger)
- 🔹 **ModelMapper** (para conversão entre DTOs e entidades)
- 🔹 **Lombok** (redução de boilerplate)

---

## 🔌 Inicialização

Para iniciar o projeto, é necessário criar dois bancos de dados: um no MongoDB e outro no MySQL.

### MongoDB

- Acesse o MongoDB e execute o comando `use products` ou crie um novo banco de dados com o nome `products`.
- Dentro do banco, execute o comando `db.createCollection("products")` para criar a coleção `products`.

### MySQL

- Acesse o MySQL e execute o comando `CREATE DATABASE order_db;` para criar o banco de dados `order_db`.

Depois de criar os bancos de dados, você pode executar o projeto com o comando `mvn spring-boot:run` no diretório raiz do projeto.




## 📦 Funcionalidades (parcial)

- ✅ Cadastro de produtos
- ✅ Listagem paginada
- ⏳ Integração com outros serviços via RabbitMQ
- ⏳ Notificações assíncronas
- ⏳ Persistência e leitura de dados em múltiplos bancos
- ⏳ Observabilidade (logs, tracing e métricas)

---


