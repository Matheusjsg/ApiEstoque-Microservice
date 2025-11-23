# 🏷️ Microserviço — API de Estoque

Este microserviço é responsável pelo controle de estoque dos produtos utilizados no sistema.  
A API permite gerenciar quantidade, entradas e saídas, garantindo integridade dos dados de inventário.

Utiliza **Spring Boot**, **Spring Data JPA** para persistência e **Flyway** para versionamento do banco de dados.

---

## 🛠 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Flyway
- MySQL/PostgreSQL
- Maven

---

## 📌 Funcionalidades

✔ Controle de quantidade de itens  
✔ Registro de movimentações (entrada/saída)  
✔ Listagem e consulta de produtos  
✔ Integração com o microserviço de pedidos (opcional)  

---

## 🔗 Endpoints

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/estoque` | Cadastrar item no estoque |
| GET | `/estoque` | Listar todos os itens |
| GET | `/estoque/{id}` | Buscar por ID |
| PUT | `/estoque/{id}` | Atualizar informações |
| DELETE | `/estoque/{id}` | Remover item |

> Operações de movimentação podem ser adicionadas com rotas como:  
> `POST /estoque/{id}/entrada` e `POST /estoque/{id}/saida`

