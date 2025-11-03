# Sistema de Controle Financeiro em Java

Um sistema de controle financeiro desenvolvido em **Java** com **persistência em SQLite**, permitindo cadastrar receitas e despesas, calcular saldo e listar transações com armazenamento permanente.

## 🚀 Funcionalidades

* ✅ Adicionar receitas
* ✅ Adicionar despesas
* ✅ Listar transações salvas no banco
* ✅ Calcular saldo total (receitas - despesas)
* ✅ Persistência em SQLite (dados não se perdem)
* ✅ Estrutura organizada (MVC/DAO)
* ⏳ Próximas melhorias:

  * Exportar dados para CSV
  * Interface gráfica com JavaFX
  * Edição de transações
  * Filtrar por período

## 🛠 Tecnologias Utilizadas

* **Java 17+**
* **SQLite** (banco de dados local)
* **JDBC Driver SQLite**
* **IntelliJ IDEA**

## 📂 Estrutura do Projeto

```
src/
 ├─ app/
 │   ├─ Main.java
 │   ├─ DatabaseConnection.java
 │   └─ DatabaseSetup.java
 ├─ dao/
 │   └─ TransacaoDAO.java
 └─ model/
     ├─ Transacao.java
     ├─ Receita.java
     └─ Despesas.java
lib/
 └─ sqlite-jdbc-xxx.jar
```

## ▶️ Como rodar o projeto

1. Instale Java e IntelliJ
2. Clone o repositório
3. Coloque o driver SQLite em `/lib`
4. Execute o arquivo `Main.java`

O banco `financeiro.db` será criado automaticamente.

## 💡 Roadmap de evolução

* [ ] Exportação para CSV
* [ ] Dashboard com JavaFX e gráficos
* [ ] Controle de múltiplas contas
* [ ] Tela de login (modo avançado)
* [ ] Deploy como aplicativo desktop

## 🤝 Contribuições

Sugestões são bem-vindas! Sinta-se livre para abrir issues ou enviar PRs.

## 👤 Autor

Projeto criado por **Israel** durante sua jornada de aprendizado em Java e desenvolvimento de sistemas.

> "Evoluindo todos os dias na programação."

---

⭐ Se este projeto te ajudou, deixe uma estrela no repositório!
