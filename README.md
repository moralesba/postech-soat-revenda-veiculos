# Pós-Tech SOAT - Projeto da Fase 2: API de Revenda de Veículos

## 1. Descrição do Projeto

Esta é a API RESTful para a plataforma de uma revenda de veículos automotores, desenvolvida como parte do Tech Challenge da Fase 2 do curso de Arquitetura de Software da Pós-Tech SOAT. A API gerencia o ciclo de vida completo dos veículos, desde o cadastro para venda até a efetivação da compra e integração com um sistema de pagamento via webhook.

## 2. Tecnologias e Arquitetura

Para a implementação do projeto, foram utilizadas as seguintes tecnologias e conceitos:
- **Linguagem:** Kotlin
- **Build Tool:** Maven
- **Framework:** Spring Boot
- **Banco de Dados:** PostgreSQL
- **Containerização:** Docker e Docker Compose
- **Orquestração:** Kubernetes
- **Arquitetura:** O projeto foi implementado seguindo os princípios SOLID e o padrão de arquitetura limpa (Clean Architecture), com uma separação clara entre as camadas de Domínio, Aplicação e Infraestrutura.
- **Documentação da API:** OpenAPI/Swagger

## 3. Como Usar Localmente

Para executar o projeto em seu ambiente local, siga os passos abaixo.

### Pré-requisitos
- Git
- Maven
- Java 17+
- Docker e Docker Compose (ou Rancher Desktop)


### Passos para Execução
1. Clone o repositório:
   ```bash
   git clone https://github.com/moralesba/postech-soat-revenda-veiculos.git
   cd postech-soat-revenda-veiculos
   ```

2. Suba a aplicação completa (API + Banco de Dados) com Docker Compose:
   ```bash
   docker compose up --build
   ```
   A aplicação estará disponível em `http://localhost:8080`.

## 4. Como Testar (Endpoints da API)

A documentação completa e interativa dos endpoints está disponível via Swagger UI.

- **URL da Documentação Swagger:** `http://localhost:8080/swagger-ui.html`

A partir da interface do Swagger, é possível testar todos os endpoints da aplicação. Alternativamente, você pode usar uma ferramenta como Postman ou `curl`.

**Exemplo: Cadastrar um novo veículo**
```bash
curl -X POST "http://localhost:8080/veiculos" \
-H "Content-Type: application/json" \
-d '{
  "marca": "Fiat",
  "modelo": "Mobi",
  "ano": 2024,
  "cor": "Vermelho",
  "preco": 72000.00
}'
```