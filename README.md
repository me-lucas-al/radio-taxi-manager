
🚖 **Mar & Sol - Sistema de Gestão de Rádio Táxi**

📋 **Sobre o Projeto**
O Mar & Sol é uma aplicação Java em terminal desenvolvida para gerenciar o fluxo operacional de uma cooperativa de rádio táxi. O sistema permite o cadastro completo de clientes e motoristas (incluindo dados de veículos e habilitação), além da solicitação de corridas com validação de perímetro urbano. Também acompanha todo o ciclo de vida da viagem, desde a chamada inicial até o embarque do passageiro.

🏗️ **Arquitetura e Padrões de Projeto**
O sistema foi estruturado com base no padrão BCE (Boundary-Control-Entity), também conhecido como VCP (Visão-Controle-Processamento), garantindo uma clara separação de responsabilidades.

**BCE / VCP na prática:**

* **Boundary (Fronteira):** Responsável pela interação com o usuário via terminal (`Scanner`). Apenas coleta e exibe dados, sem conter regras de negócio.
* **Control (Controle):** Atua como o núcleo do sistema, coordenando o fluxo entre as camadas, realizando validações e regras operacionais.
* **Entity (Entidade):** Representa os objetos de domínio (como `Driver` e `Ride`), concentrando estado e regras essenciais do negócio.

🧠 **Aplicação de DDD (Domain-Driven Design)**
O projeto utiliza conceitos de DDD para refletir fielmente o domínio da aplicação:

* **Linguagem Ubíqua:** Termos como “VR Code”, “Aguardando VR” e “Tripulado” são utilizados tanto no código quanto no contexto do negócio.
* **Value Objects:** Tipos como `Cpf`, `Phone`, `Address` e `Cnh` substituem strings genéricas, garantindo validação e consistência dos dados.
* **Entidades Ricas:** Classes como `Ride` controlam seu próprio estado, evitando transições inválidas no fluxo da corrida.

🛠️ **Princípios SOLID**
A estrutura do código segue os princípios SOLID, promovendo organização e manutenibilidade:

* **SRP (Responsabilidade Única):** Cada classe possui uma única responsabilidade bem definida.
* **OCP (Aberto/Fechado):** Novos estados de corrida podem ser adicionados sem alterar a lógica existente.
* **LSP (Substituição de Liskov):** Uso de abstrações como `List` garante flexibilidade nas implementações.
* **DIP (Inversão de Dependência):** As dependências são injetadas via `Main`, reduzindo acoplamento entre camadas.

🔗 **Desacoplamento e Encapsulamento**
O sistema foi projetado com foco em baixo acoplamento e alta coesão:

* **Independência de Interface:** A camada de apresentação pode ser substituída (ex: Swing ou JavaFX) sem impactar regras de negócio.
* **Encapsulamento:** Atributos são protegidos e acessados de forma controlada. Objetos como `Cpf` garantem integridade e formatação dos dados.

🚀 **Fluxo do Sistema**
O funcionamento segue um ciclo bem definido:

1. **Cadastro:** Registro completo de motoristas com CNH, veículo e endereço.
2. **Solicitação:** Criação da corrida com validação de área atendida.
3. **Despacho:** Associação de um “VR Code” à corrida.
4. **Execução:** Evolução de status: *AGUARDANDO_AVISO → AVISO_EFETUADO → TRIPULADO*.
5. **Gestão:** Consulta e filtragem de motoristas e histórico de corridas.

💻 **Tecnologias Utilizadas**

* **Java 21+** — Recursos modernos da linguagem
* **UUID** — Identificadores únicos e seguros
* **Java Time API** — Manipulação robusta de datas e horários
