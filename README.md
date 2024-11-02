# Projeto Avaliação

Este projeto é uma aplicação Spring Boot que implementa autenticação JWT e operações CRUD para uma entidade "Produto", utilizando um banco de dados PostgreSQL.

## Estrutura do Projeto

### Parte 1: Autenticação
- Foi criado um novo projeto Spring Boot utilizando o Spring Initializr.
- A autenticação JWT (JSON Web Token) foi configurada para proteger a API.
- Foram implementados endpoints para registro de usuário e autenticação, utilizando bcrypt para criptografar senhas.
- Os endpoints foram testados com ferramentas como Postman ou cURL.

### Parte 2: Operações CRUD
- A entidade "Produto" foi definida com os seguintes atributos:
  - `id` (chave primária)
  - `nome`
  - `descrição`
  - `preço`
- A conexão com o banco de dados PostgreSQL foi configurada.
- Foram implementados endpoints RESTful para operações CRUD (Create, Read, Update, Delete) para a entidade "Produto".
- Os endpoints CRUD foram testados com ferramentas como Postman ou cURL.

## Critérios de Avaliação
- **Funcionalidade**: Os endpoints RESTful estão implementados corretamente e respondem de acordo com as especificações.
- **Segurança**: A autenticação JWT está corretamente configurada e protege os endpoints conforme o esperado.
- **Qualidade de Código**: O código segue as melhores práticas de desenvolvimento Spring Boot e é fácil de entender e manter.
- **Testabilidade**: Os endpoints estão devidamente testados e todas as operações CRUD funcionam conforme o esperado.
- **Desempenho**: A aplicação é eficiente e escalável, mesmo com um grande volume de requisições.

## Observações Adicionais
- Você pode usar qualquer IDE de sua preferência para desenvolver o projeto.
- Certifique-se de incluir instruções claras sobre como executar e testar a aplicação.

## Uso do Docker Compose

Este projeto utiliza o Docker Compose para gerenciar as dependências da aplicação e facilitar a execução em ambientes isolados. O Docker Compose permite que você execute múltiplos containers com um único comando.

### Cuidados para Execução
- **Instalação do Docker**: Certifique-se de ter o Docker e o Docker Compose instalados em sua máquina. Você pode seguir as instruções de instalação na [documentação oficial do Docker](https://docs.docker.com/get-docker/).
  
- **Verifique a Versão do Docker Compose**: Execute `docker-compose --version` para garantir que você está usando uma versão compatível.

- **Recursos do Sistema**: Garanta que sua máquina tenha recursos suficientes (CPU, memória) para executar os containers. O PostgreSQL e a aplicação Spring Boot podem exigir uma quantidade considerável de recursos.

- **Portas**: Verifique se a porta 9045 está livre e disponível em sua máquina para evitar conflitos. Se estiver em uso, você pode alterar a configuração da porta no arquivo `docker-compose.yml`.

## Como Rodar o Projeto

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/andrewscampos/avaliacao-1.git
   cd avaliacao-1
2. ** Execução do projeto**
	```bash
	docker-compose build --no-cache && docker-compose up
	
3. ** Importar o collection postman**
	avaliacao.postman_collection.json 	