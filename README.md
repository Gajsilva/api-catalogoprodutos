# API de Catálogo de Produtos

![Badge](https://img.shields.io/badge/java-v1.8-brightgreen.svg)
![Badge](https://img.shields.io/badge/spring--boot-v2.5.0-brightgreen.svg)
![Badge](https://img.shields.io/badge/license-MIT-blue.svg)

Descrição curta do seu projeto.

## Objetivo de Uso

Este projeto tem como objetivo fornecer uma API de Catálogo de Produtos eficiente e fácil de usar para aplicações que necessitam gerenciar informações sobre produtos. As principais finalidades de uso incluem:

- **Consulta de Produtos:** Os usuários podem facilmente buscar e visualizar informações sobre produtos disponíveis no catálogo.
  
- **Avaliações e Classificações:** Permite aos usuários avaliarem produtos e visualizarem as classificações médias.

- **Controle de Estoque:** Fornece informações atualizadas sobre a quantidade disponível de cada produto em estoque.

- **Integração Simples:** Projetado para ser facilmente integrado a aplicações frontend, sistemas de e-commerce, ou qualquer outra plataforma que necessite acesso a um catálogo de produtos.

Sinta-se à vontade para explorar a documentação e contribuir para o desenvolvimento contínuo deste projeto.



## Índice

- [Funcionalidades](#funcionalidades)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Configuração do Ambiente de Desenvolvimento](#configuração-do-ambiente-de-desenvolvimento)
- [Como Usar](#como-usar)
- [Exemplos de Requisições](#exemplos-de-requisições)
- [Contribuição](#contribuição)
- [Licença](#licença)

## Funcionalidades

- Lista de funcionalidades principais da sua API.

## Tecnologias Utilizadas

- Java 8
- Spring Boot
- Spring Data JPA
- H2 Database (para ambiente de desenvolvimento)
- (Adicione outras tecnologias utilizadas)

## Configuração do Ambiente de Desenvolvimento

1. Clone o repositório.
2. Configure as propriedades do banco de dados no arquivo `application.properties`.
3. Execute a aplicação localmente.

## Como Usar

Siga estas instruções para configurar e executar localmente a API de Catálogo de Produtos.

### Banco de Dados H2 (Ambiente de Desenvolvimento)

O projeto utiliza o banco de dados H2 para simplificar o ambiente de desenvolvimento. O H2 é um banco de dados leve que pode ser incorporado à aplicação e oferece uma interface web conveniente.

- **Console H2:** [http://localhost:8080/catalogo/h2-console](http://localhost:8080/catalogo/h2-console)
  - **JDBC URL:** `jdbc:h2:file:./h2-dadosLocal`
  - **Username:** `sa`
  - **Password:** sa

**Atenção:** O console H2 está disponível apenas em ambiente de desenvolvimento e não deve ser utilizado em ambientes de produção.

### Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas em sua máquina:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) - versão 8 ou superior.
- [Maven](https://maven.apache.org/download.cgi) - para gerenciamento de dependências e construção do projeto.

### Instalação

## Exemplos de Requisições
### Recuperar um Produto por ID

#### GET /api/v1/produtos/{id}
## Documentação da API e Segurança

A API de Catálogo de Produtos está documentada e utiliza o Spring Security com JWT para garantir a autenticação e autorização adequadas.

### Documentação da API

A documentação da API pode ser acessada localmente ou em um ambiente de produção. Utilizamos o Swagger, uma ferramenta popular para documentação de API.

- **Documentação Local:**
  Acesse [http://localhost:8080/swagger-ui.html](http://localhost:8080/catalogo/swagger-ui.html) para visualizar a documentação localmente.


### Spring Security com JWT

A segurança da API é gerenciada pelo Spring Security, e as requisições são autenticadas usando JSON Web Tokens (JWT). Isso garante um fluxo seguro de autenticação e autorização.

- **Autenticação:**
  As requisições de autenticação devem incluir um token JWT válido no cabeçalho.

- **Autorização:**
  Os endpoints da API estão protegidos e só podem ser acessados por usuários autenticados e autorizados.

### Exemplo de Autenticação

Para obter um token JWT, você deve primeiro autenticar-se com as credenciais adequadas.

## Contribuição

Siga as diretrizes de contribuição se quiser contribuir para este projeto.

1. Faça o fork do projeto.
2. Crie uma nova branch com suas alterações: `git checkout -b feature/nova-feature`.
3. Faça commit das suas alterações: `git commit -m 'Adiciona nova feature'`.
4. Faça o push para a sua branch: `git push origin feature/nova-feature`.
5. Abra um Pull Request.

## Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE.md](LICENSE.md) para detalhes.

