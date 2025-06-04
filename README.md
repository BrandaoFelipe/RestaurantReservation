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
RestaurantReservation/
├── backend/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/brandao/reservation/
│   │   │   │   ├── controller/
│   │   │   │   ├── entity/
│   │   │   │   ├── repository/
│   │   │   │   ├── security/
│   │   │   │   └── service/
│   │   └── resources/
│   │       └── application.properties
├── frontend/
│   ├── src/
│   │   ├── pages/
│   │   ├── components/
│   │   ├── services/
│   │   └── App.jsx
└── README.md
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
```bash
cd frontend
npm install
npm run dev
```

> O frontend será servido em: `http://localhost:5173`
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
