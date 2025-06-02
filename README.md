# API de Tickets
Esta é uma API para gerenciamento de tickets, desenvolvida com o framework Spring Boot 3.5 e Java 21. 
A aplicação utiliza um banco de dados H2 e está configurada para rodar no perfil de desenvolvimento (`dev`).

## Tecnologias Utilizadas
- **Java 21**: Versão moderna da linguagem Java que oferece novos recursos e melhorias.
- **Spring Boot 3.5**: Framework que facilita o desenvolvimento de aplicações Java, mantendo a produtividade e facilidade de configuração.
- **Banco de dados H2**: Banco de dados em memória usado para desenvolvimento e testes.
- **Maven**: Gerenciamento de dependências e construção do projeto.

## Configurações de Ambiente
### Banco de Dados

- **H2 Database**:
    - URL de conexão: `jdbc:h2:mem:teste`
    - Usuário: `sa`
    - Senha: 
    - Endereço do console: [H2](http://localhost:8080/oraculo/h2)

**Obs: A aplicação excuta as instruções DDL automáticamente conforme configurado no arquivo [application-dev.properties](src/main/resources/application-dev.properties), logo a cada restar da aplicação o banco será recriado assim como os seus dados**
### Perfil de Desenvolvimento

A aplicação está configurada para rodar com o perfil `dev`, que utiliza o banco de dados H2 em memória para facilitar o desenvolvimento e testes locais.


## Executando a Aplicação
Para executar a aplicação localmente, siga os passos abaixo:
### Clone o repositório
Na pasta onde deseja salvar o projeto execute o comando abaixo.
**Obs: caso não tenha o GIT instalado na sua máquina siga as instruções do link abaixo**
https://git-scm.com/book/pt-pt/v2/Come%C3%A7ando-Instalar-o-Git
```sh 
git clone https://github.com/AuRocKbra/oraculo.git
```
### Executar projeto
Execute o comando abaixo para executar o projeto.
**Obs: caso não tenha o MAVEN instalado na sua máquina siga as intruções do link abaixo**
https://maven-apache-org.translate.goog/install.html?_x_tr_sl=en&_x_tr_tl=pt&_x_tr_hl=pt&_x_tr_pto=tc
```sh
   mvn spring-boot:run
```
**Obs: O projeto é compátivel com a maioria das IDEs de mercado bastando importar o projeto como um projeto Spring Boot.**

## Dados de teste
### Classe de configuração inicial
Foi criada uma classe de configuração inicial que é executada no momento da execução do projeto. 
Lembrando que o projeto está configurado para executar o perfil de DEV. A class em questão é a CriaBancoDevService presente no pacote package com.br.oraculo.service;

### Dados de teste categoria
Foram criadas 5 categorias de teste com os seguintes dados

| Número | Categoria         | Descrição            |
|--------|-------------------|----------------------|
| 1      | CAT.1             | Dúvida               |
| 2      | CAT.2             | Atualização          |
| 3      | CAT.3             | Correção de bug      |
| 4      | CAT.4             | Nova função          |
| 5      | CAT.5             | Configuração DevOps  |

### Dados de ticket
Foram criados 5 tickets de exemplo

| Categoria | Status | ticket | Descrição                                                                                                      | Título                                 |
|-----------|--------|--------|----------------------------------------------------------------------------------------------------------------|----------------------------------------|
| 3         | 1      | 1      | Hoje pela manhã não consegui logar na aplicação XPTO. Sempre que digitava o usuário e senha a mensagem de usuário e senha inválidos está apresentada, porém ambos os dados estão corretos | Erro na autenticação                   |
| 4         | 1      | 2      | Gostaria de saber qual é o procedimento adotado para realização de cadastro de um novo sistema e os dados necessários para realização do cadastro. | Dúvidas sobre cadastro de novo sistema |
| 5         | 1      | 3      | Solicito a criação de pipeline de homologação para o sistema XPTO.                                             | Criação de pipeline DevOps             |
| 2         | 1      | 4      | Atualização a aplicação XYZ para disponibilização de uma nova função.                                          | Atualização da aplicação XYZ           |
| 1         | 1      | 5      | Gostaria de saber se existe alguma documentação sobre os serviços da API de documentos.                       | Documentação da API de documentos      |

### Exemplo de consumo de endpoint
No projeto foi disponibilizaco uma collection com as chamadas para realização de teste de consumo dos endpoints da aplicação. O arquivo tem o nome de [Oraculo.postman_collection.json](Oraculo.postman_collection.json) devendo ser importado no [Postman](https://www.postman.com/) ou [Insomnia](https://insomnia.rest/download)
