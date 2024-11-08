### Sistema de Gerenciamento de Restaurante

Este sistema foi desenvolvido para gerenciar reservas, clientes e mesas em um restaurante. Ele é composto por uma aplicação web que permite aos usuários realizar operações de inserção, edição, exclusão e listagem de clientes, reservas e mesas. A aplicação utiliza Java com servlets para o controle de fluxo e um banco de dados para armazenar as informações. A seguir, está a documentação detalhada das principais funcionalidades e estrutura do sistema.

#### Estrutura do Projeto

**Diretórios:**
- **webapp**: Contém as páginas JSP para interação com o usuário.
  - `client-form.jsp`: Formulário para inserir ou editar informações do cliente.
  - `client-list.jsp`: Exibe a lista de clientes cadastrados.
  - `reservation-form.jsp`: Formulário para inserir ou editar informações de reservas.
  - `reservation-list.jsp`: Exibe a lista de reservas.
  - `table-form.jsp`: Formulário para inserir ou editar informações das mesas.
  - `table-list.jsp`: Exibe a lista de mesas disponíveis no restaurante.

- **java/org/example**: Contém os pacotes de Java responsáveis pela lógica de controle, interação com o banco de dados e definição de modelos.
  - **controller**: Contém as classes de servlet que controlam as ações do usuário.
    - `ClientServlet.java`: Controla as ações relacionadas aos clientes.
    - `ReservationServlet.java`: Controla as ações relacionadas às reservas.
    - `TableServlet.java`: Controla as ações relacionadas às mesas.
  - **dao**: Contém as classes de acesso ao banco de dados.
    - `ClientDAO.java`: Contém os métodos para manipular dados de clientes no banco.
    - `DatabaseConnection.java`: Estabelece a conexão com o banco de dados.
    - `ReservationDAO.java`: Contém os métodos para manipular dados de reservas.
    - `TableDAO.java`: Contém os métodos para manipular dados das mesas.
  - **model**: Contém as classes de modelo que representam as entidades do sistema.
    - `Client.java`: Representa um cliente do restaurante.
    - `Reservation.java`: Representa uma reserva feita por um cliente.
    - `Table.java`: Representa uma mesa disponível no restaurante.

### Funcionalidade Detalhada

#### 1. **Gerenciamento de Clientes**
   - **Cadastro de Cliente**: O `ClientServlet` permite cadastrar novos clientes através do formulário `client-form.jsp`. As informações inseridas são salvas no banco de dados utilizando a classe `ClientDAO`.
   - **Listagem de Clientes**: A lista de clientes pode ser visualizada na página `client-list.jsp`. A classe `ClientDAO` é responsável por recuperar todos os clientes cadastrados no banco.
   - **Edição de Cliente**: O cliente pode ser editado usando o mesmo formulário de cadastro (`client-form.jsp`), e as mudanças são salvas no banco através de um `update` executado pela classe `ClientDAO`.
   - **Exclusão de Cliente**: Clientes podem ser excluídos diretamente da listagem de clientes.

#### 2. **Gerenciamento de Mesas**
   - **Cadastro de Mesa**: O `TableServlet` permite cadastrar novas mesas através do formulário `table-form.jsp`. As informações inseridas são armazenadas no banco de dados por meio da classe `TableDAO`.
   - **Listagem de Mesas**: A página `table-list.jsp` exibe todas as mesas cadastradas no banco de dados.
   - **Edição de Mesa**: Mesas podem ser editadas utilizando o formulário `table-form.jsp`.
   - **Exclusão de Mesa**: Mesas podem ser excluídas diretamente da listagem de mesas.

#### 3. **Gerenciamento de Reservas**
   - **Cadastro de Reserva**: As reservas são realizadas através do formulário `reservation-form.jsp`, onde o cliente seleciona a mesa, define o horário e o status da reserva. Os dados são processados pela classe `ReservationDAO` e armazenados no banco.
   - **Listagem de Reservas**: A página `reservation-list.jsp` exibe todas as reservas feitas. A classe `ReservationDAO` recupera as reservas do banco de dados.
   - **Edição de Reserva**: Reservas podem ser editadas através do mesmo formulário de cadastro de reserva, `reservation-form.jsp`. O `ReservationServlet` processa a atualização.
   - **Exclusão de Reserva**: Reservas podem ser removidas da listagem com a ação de exclusão.

#### 4. **Fluxo do Sistema**
   - A aplicação segue um modelo MVC (Model-View-Controller), onde as **Views** são representadas pelas páginas JSP, os **Controllers** são representados pelos servlets que processam as requisições, e os **Models** são as classes que representam os dados manipulados.
   - **Exemplo de Fluxo de Reserva**:
     1. O usuário acessa a página `reservation-form.jsp` para criar ou editar uma reserva.
     2. O formulário é submetido para o `ReservationServlet`, que processa os dados e chama o método `insertReservation` ou `updateReservation` na classe `ReservationDAO`.
     3. O banco de dados é atualizado e o usuário é redirecionado para a lista de reservas (`reservation-list.jsp`).

#### 5. **Conexão com o Banco de Dados**
A classe `DatabaseConnection` gerencia a conexão com o banco de dados, garantindo que todas as operações de leitura e escrita no banco de dados sejam realizadas de maneira eficiente e segura.

---

### Conclusão

Este sistema de gerenciamento de restaurante oferece uma solução prática e eficiente para o controle de clientes, reservas e mesas. Utilizando Java, Servlets, JSP e JDBC, ele garante uma boa separação de responsabilidades entre as camadas de apresentação, controle e persistência de dados. O modelo de banco de dados é simples e eficaz para as necessidades do sistema.
