# OrganizeMe
"OrganizeMe é uma API de gerenciamento de tarefas desenvolvida com Spring Boot, projetada para ajudar você a organizar, priorizar e acompanhar suas atividades diárias. Ela permite que os usuários criem, atualizem, listem e excluam tarefas (To-dos).

## Funcionalidades

- Criar uma nova tarefa
- Listar todas as tarefas
- Atualizar uma tarefa existente
- Excluir uma tarefa

## Tecnologias Utilizadas

- Java
- Spring Boot
- Maven
- MySQL

## Começando

### Pré-requisitos

- Java 17 ou superior
- Maven 3.6.0 ou superior
- MySQL

### Instalação

1. Clone o repositório:
    ```sh
    git clone https://github.com/larissa-oliv/organize-me.git
    cd organize-me
    ```

2. Configure o banco de dados:
    - Crie um banco de dados MySQL chamado `OrganizeMe`.
    - Atualize a configuração do banco de dados em `src/main/resources/application.properties`:
        ```ini
        spring.datasource.url=jdbc:mysql://localhost:3306/OrganizeMe
        spring.datasource.username=root
        spring.datasource.password=root
        spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

        spring.jpa.hibernate.ddl-auto=update
        ```

3. Construa o projeto:
    ```sh
    mvn clean install
    ```

4. Execute a aplicação:
    ```sh
    mvn spring-boot:run
    ```

## Endpoints da API

### Criar uma nova tarefa

- **URL:** `/todos`
- **Método:** `POST`
- **Corpo da Requisição:**
    ```json
    {
      "nome": "Estudar Spring Boot",
      "descricao": "Estudar o framework Spring Boot",
      "realizado": false,
      "prioridade": 1
    }
    ```
- **Resposta:** Lista de todas as tarefas

### Listar todas as tarefas

- **URL:** `/todos`
- **Método:** `GET`
- **Resposta:** Lista de todas as tarefas

### Atualizar uma tarefa existente

- **URL:** `/todos`
- **Método:** `PUT`
- **Corpo da Requisição:**
    ```json
    {
      "id": 1,
      "nome": "Estudar Spring Boot",
      "descricao": "Estudar o framework Spring Boot em detalhes",
      "realizado": true,
      "prioridade": 2
    }
    ```
- **Resposta:** Lista de todas as tarefas

### Excluir uma tarefa

- **URL:** `/todos/{id}`
- **Método:** `DELETE`
- **Resposta:** Lista de todas as tarefas

## Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
