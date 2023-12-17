# Mini-Projeto-Spring

## 📋 Introdução

Projeto pequeno de api em Java Spring Boot.

## 💻 Pré-requisitos

Antes de começar, verifique se você atendeu aos seguintes requisitos:
* Ter instalada a versão do Java JDK 17 ou superior;
* Ter instalado o Apache Maven 3.x.x;
* Utilizar uma IDE para Java - Eclipse, IntelliJ ou Visual Studio Code;

## 🚀 Realizando o Setup

1. Clone o repositório;

2. Execute o comando:
```bash
mvn clean && mvn spring-boot:run
```
3. O serviço roda na porta: 8089.

## ⚙️ Das APIs:

GET - http://localhost:8089/ - Lista todos os clientes

POST - http://localhost:8089/ - Inclui um cliente
*Request Body:*
```json
{
    "nome": string,
    "numeroDocumento": long,
    "observacao": string,
    "ativo": boolean
}
```
DELETE - http://localhost:8089/{id} - Exclui um cliente passando um Id
