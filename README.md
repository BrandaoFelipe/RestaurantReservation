EN
# 🍽️ Restaurant Reservation System

A full-featured system for managing restaurant reservations, including authentication, user access control, and table management. Developed as a full stack project using **Spring Boot** for the backend and **React** for the frontend.

---

## 🚀 Technologies Used

### Backend
- Java 17  
- Spring Boot  
- Spring Security (form-based login)  
- Spring Data JPA + Hibernate  
- Relational Database (e.g., PostgreSQL or H2)  
- Maven

### Frontend
- React  
- Vite  
- React Router  
- Axios  
- TailwindCSS

---

## 🔐 Features Implemented

### Backend
- User registration and login  
- Role-based access control (user/admin)  
- Many-to-Many relationship between users and roles  
- Session management with Spring Security  
- RESTful API for reservation operations (in progress)

### Frontend
- Login interface  
- Protected routes based on authentication  
- Backend integration via Axios  
- Responsive, modern layout with TailwindCSS  
- Dashboard page (in development)

---

## 📌 Project Structure

## 📁 Project Structure

```bash
RestaurantReservation/
├── src/
│   ├── main/
│   │   ├── java/com/brandao/reserve/
│   │   │   ├── config/
│   │   │   ├── controllers/
│   │   │   ├── dtos/
│   │   │   │   ├── requestsDTO/
│   │   │   │   └── responseDTOs/
│   │   │   ├── validators/
│   │   │   ├── entities/
│   │   │   ├── mappers/
│   │   │   ├── repositories/
│   │   │   ├── services/
│   │   │   ├── exceptions/
│   │   │   └── ReserveApplication.java
│   │   └── resources/
│   │       ├── META-INF/
│   │       ├── application.properties
│   │       ├── application-dev.properties
│   │       ├── application-prod.properties
│   │       ├── application-test.properties
│   │       └── import.SQL
│   └── test/java/com/brandao/reserve/
├── system.properties
```

---

## 🧪 Running the Project Locally

### Prerequisites

- Java 17  
- Node.js (v18+)  
- Maven  
- PostgreSQL or H2 (depending on selected profile)

### Steps

#### 1. Backend
```bash
cd backend
./mvnw spring-boot:run
```

> Server will start at: `http://localhost:8080`

#### 2. Frontend
> Frontend will be served at: `http://localhost:5173`  
> Frontend repository: [`reservation_restaurant_front`](https://github.com/BrandaoFelipe/reservation_restaurant_front)

---

## ✅ Project Status

- [x] Authentication with Spring Security  
- [x] Role-based access control  
- [x] Protected frontend navigation  
- [x] CRUD operations for tables and reservations  
- [x] Schedule and availability management  
- [x] Admin dashboard  
- [ ] Backend/frontend integration (in progress)

---

## 🧠 Project Motivation

This project is part of a personal career transition plan into the tech industry, aiming for full mastery of **Full Stack Java + React** development. The main goals include consolidating knowledge in:

- RESTful architecture best practices  
- Web application security and authentication  
- Seamless integration between frontend and backend using modern tools

---

## 🤝 Contributions

This is a personal project, but feedback is always welcome. Suggestions, issues, and pull requests will be reviewed thoughtfully.

---

## 📫 Contact

Built with dedication by [Felipe Brandão](https://github.com/BrandaoFelipe).  
Let’s connect on [LinkedIn](https://www.linkedin.com/in/felipe-brandao-08595722a).


PT
# 🍽️ Restaurant Reservation System

Sistema completo de gerenciamento de reservas para restaurantes, com autenticação, controle de usuários e gerenciamento de mesas. Desenvolvido como projeto full stack utilizando **Spring Boot** no backend e **React** no frontend.

---

## 🚀 Tecnologias Utilizadas

### Backend
- Java 17
- Spring Boot
- Spring Security (autenticação via formulário)
- Spring Data JPA + Hibernate
- Banco de dados relacional (ex: PostgreSQL ou H2)
- Maven

### Frontend
- React
- Vite
- React Router
- Axios
- TailwindCSS

---

## 🔐 Funcionalidades Implementadas

### Backend
- Cadastro e autenticação de usuários
- Controle de permissões com sistema de roles (usuário/admin)
- Relacionamento ManyToMany entre usuários e roles
- Gestão de sessões autenticadas
- API RESTful para operações de reserva (em construção)

### Frontend
- Interface de login
- Navegação protegida por autenticação
- Integração com backend via Axios
- Layout responsivo e moderno com TailwindCSS
- Tela de dashboard (em construção)

---

## 📌 Estrutura do Projeto

```bash
```bash
RestaurantReservation/
├── src/
│   ├── main/
│   │   ├── java/com/brandao/reserve/
│   │   │   ├── config/
│   │   │   ├── controllers/
│   │   │   ├── dtos/
│   │   │   │   ├── requestsDTO/
│   │   │   │   └── responseDTOs/
│   │   │   ├── validators/
│   │   │   ├── entities/
│   │   │   ├── mappers/
│   │   │   ├── repositories/
│   │   │   ├── services/
│   │   │   ├── exceptions/
│   │   │   └── ReserveApplication.java
│   │   └── resources/
│   │       ├── META-INF/
│   │       ├── application.properties
│   │       ├── application-dev.properties
│   │       ├── application-prod.properties
│   │       ├── application-test.properties
│   │       └── import.SQL
│   └── test/java/com/brandao/reserve/
├── system.properties
```

---

## 🧪 Como Rodar o Projeto Localmente

### Pré-requisitos

- Java 17
- Node.js (v18+)
- Maven
- PostgreSQL ou H2 (dependendo do perfil configurado)

### Passos

#### 1. Backend
```bash
cd backend
./mvnw spring-boot:run
```

> O servidor será iniciado em: `http://localhost:8080`

#### 2. Frontend
> Frontend será servido em: `http://localhost:5173`  
>Link do projeto frontend: `https://github.com/BrandaoFelipe/reservation_restaurant_front`

---

## ✅ Status do Projeto

- [x] Autenticação com Spring Security
- [x] Sistema de roles e permissões
- [x] Frontend com login e navegação protegida
- [x] CRUD de mesas e reservas
- [x] Gerenciamento de horários e disponibilidade
- [x] Painel administrativo
- [ ] Integração do backend com frontend


---

## 🧠 Motivação do Projeto

Esse projeto está sendo desenvolvido como parte do plano pessoal de transição de carreira para a área de tecnologia, com foco no domínio completo do desenvolvimento **Full Stack Java + React**. Além disso, busca-se consolidar o entendimento de:

- Padrões de arquitetura REST
- Autenticação e segurança em aplicações web
- Integração entre frontend e backend com práticas modernas

---

## 🤝 Contribuição

Este repositório é de caráter pessoal, mas feedbacks são bem-vindos. Sugestões, issues e pull requests serão analisados com atenção.


---

## 📫 Contato

Feito com dedicação por [Felipe Brandão](https://github.com/BrandaoFelipe).  
Entre em contato pelo [LinkedIn](www.linkedin.com/in/felipe-brandao-08595722a).
