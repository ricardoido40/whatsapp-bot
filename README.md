# WhatsApp Bot

Um bot para o WhatsApp desenvolvido em Java utilizando o ecossistema Spring Boot.

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
  - Spring Web (para construção de APIs REST)
  - Spring Data MongoDB (para persistência de dados)
  - Spring Boot Actuator (para monitoramento e métricas da aplicação)
  - Spring Boot Validation (para validação de dados)
- **MongoDB** (banco de dados NoSQL)
- **Lombok** (para redução de código boilerplate)
- **Docker & Docker Compose** (para containerização e fácil execução)
- **Maven** (para gerenciamento de dependências)

## Pré-requisitos

Antes de rodar a aplicação, você precisa ter instalado:
- [Docker](https://docs.docker.com/get-docker/)
- [Docker Compose](https://docs.docker.com/compose/install/)
- [Git](https://git-scm.com/)

## Como Executar (com Docker)

A maneira mais simples e rápida de rodar a aplicação é utilizando o Docker Compose, que subirá tanto o banco de dados (MongoDB) quanto a aplicação Spring Boot.

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/SEU_USUARIO/whatsapp-bot.git
   cd whatsapp-bot
   ```

2. **Suba os containers com Docker Compose:**
   ```bash
   docker-compose up -d --build
   ```

Isso fará o build do seu `Dockerfile` e iniciará o container do MongoDB e da sua aplicação em modo desacoplado (background).

## Como Executar (Localmente sem Docker na Aplicação)

Se você quiser rodar apenas o MongoDB no Docker e subir a aplicação na sua máquina local (IDE ou terminal):

1. **Suba apenas o MongoDB:**
   (Certifique-se de expor a porta 27017 se for usar via Docker, ou instale o MongoDB localmente).

2. **Compile e rode a aplicação via Maven:**
   ```bash
   ./mvnw clean install
   ./mvnw spring-boot:run
   ```

## Contribuindo

Fique à vontade para fazer um *fork* do repositório, criar uma *branch* com as suas alterações e submeter um *Pull Request*.

## Licença

(Especifique aqui a licença aplicável, ex: MIT)
