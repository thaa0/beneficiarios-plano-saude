
# Beneficiário API

Aplicação desenvolvida para **manter o cadastro de beneficiários de um plano de saúde**. Ela permite a criação, atualização, exclusão e listagem de beneficiários e seus documentos associados.

## Tecnologias Usadas

- **Java 11**: Linguagem de programação.
- **Spring Boot**: Framework para desenvolvimento de aplicações Java.
- **Spring Data JPA**: Para gerenciamento da persistência de dados.
- **H2 Database**: Banco de dados em memória para desenvolvimento e testes.
- **Maven**: Ferramenta de build e gerenciamento de dependências.

## Instruções para Rodar a Aplicação

Para rodar a aplicação na sua máquina local, siga estes passos:

1. **Clonar o Projeto**

   Primeiro, clone o repositório do Git para sua máquina local:
   ```
   git clone https://github.com/thaa0/beneficiarios-plano-saude.git
   ```
   
2. **Executar a Aplicação**

## Como Acessar os Endpoints

A aplicação estará disponível em `http://localhost:8080/gestao-beneficiario/api`. Aqui estão os endpoints principais:

### 1. **Cadastrar um Beneficiário com Documentos**

- **Método**: `POST`
- **Endpoint**: `/v1/beneficiario`
- **Descrição**: Cria um novo beneficiário e opcionalmente seus documentos associados.
- **Request Body**:
  ```
   {
      "nomeCompleto": "String",
      "dataNascimento": "yyyy-mm-dd",
      "telefone": "String",
      "documentos": [
          {
            "tipoDocumento": "String",
            "descricao": "String"
          },
          {
            "tipoDocumento": "String",
            "descricao": "String"
          },
          ...
        ]
    }
  

### 2. **Listar Todos os Beneficiários**

- **Método**: `GET`
- **Endpoint**: `/v1/beneficiario`
- **Descrição**: Obtém uma lista de todos os beneficiários cadastrados.

### 3. **Listar Documentos de um Beneficiário**

- **Método**: `GET`
- **Endpoint**: `/v1/beneficiario/{idBeneficiario}/documentos`
- **Descrição**: Obtém a lista de documentos de um beneficiário específico.

### 4. **Atualizar Dados Cadastrais de um Beneficiário**

- **Método**: `PATCH`
- **Endpoint**: `/v1/beneficiario/{idBeneficiario}`
- **Descrição**: Atualiza as informações de um beneficiário específico e seus documentos.
- **Request Body**:
  ```json
  {
    "nomeCompleto": "String",
    "dataNascimento": "yyyy-mm-dd",
    "telefone": "String",
    "documentos": [
          {
        "idDocumento": "UUID",
        "tipoDocumento": "String",
        "descricao": "String"
    },
     {
        "idDocumento": "UUID",
        "tipoDocumento": "String",
        "descricao": "String"
    },
    ...
    ]
  }

### 5. **Remover um Beneficiário**

- **Método**: `DELETE`
- **Endpoint**: `/v1/beneficiario/{idBeneficiario}`
- **Descrição**: Exclui um beneficiário específico.
