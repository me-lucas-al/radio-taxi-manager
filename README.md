# 🚖 Mar & Sol - Sistema de Gestão de Rádio Táxi

## 📋 Sobre o Projeto
O **Mar & Sol** é uma aplicação Java de terminal projetada para gerenciar o fluxo operacional de uma cooperativa de rádio táxi. O sistema permite o cadastro completo de clientes e motoristas (incluindo dados de veículos e habilitação), a solicitação de corridas com validação de perímetro urbano e o acompanhamento de todo o ciclo de vida de uma viagem, desde a chamada inicial até o embarque do passageiro.

---

## 🏗️ Arquitetura e Padrões de Projeto

O software foi construído utilizando o padrão **BCE (Boundary-Control-Entity)**, também conhecido em algumas vertentes acadêmicas como **VCP (Visão-Controle-Processamento)**.

### 1. Padrão BCE / VCP
A separação de responsabilidades é o pilar desta arquitetura:

* **Boundary (Fronteira/Visão):** Localizada no pacote `boundary`, é a única camada que interage com o usuário via `Scanner`. Ela captura dados e exibe resultados, mas **não possui lógica de negócio**.
* **Control (Controle):** Localizada no pacote `control`, funciona como o "cérebro" do sistema. Orquestra as ações entre as fronteiras e as entidades, realizando validações e buscas.
* **Entity (Entidade):** Localizada no pacote `entity`. Representa os objetos de negócio puros (Ex: `Driver`, `Ride`). Elas detêm o estado e as regras fundamentais do domínio.

### 2. Princípios de DDD (Domain-Driven Design)
O projeto aplica conceitos de DDD para tornar o código reflexo da realidade do negócio:
* **Linguagem Ubíqua:** Termos como "VR Code", "Aguardando VR" e "Tripulado" são usados tanto no código quanto no dia a dia da rádio táxi.
* **Value Objects (Objetos de Valor):** Em vez de usar apenas `String` para tudo, criamos classes dedicadas para tipos complexos como `Cpf`, `Phone`, `Address` e `Cnh`. Isso garante que um CPF seja sempre válido e formatado antes mesmo de chegar ao controlador.
* **Entidades Ricas:** Entidades como `Ride` gerenciam suas próprias transições de estado (máquina de estados), impedindo que uma corrida seja "embarcada" sem antes ter um táxi atribuído.

---

## 🛠️ Princípios SOLID Aplicados

O código foi refatorado para respeitar os princípios SOLID, garantindo um sistema robusto:

1.  **S - Single Responsibility Principle (SRP):** Cada classe tem uma única razão para mudar. O `DriverController` cuida da lógica dos motoristas, enquanto o `DriverBoundary` cuida apenas da interação de tela para motoristas.
2.  **O - Open/Closed Principle (OCP):** O sistema de status de corrida (`RideStatus`) via Enum permite adicionar novos estados (ex: "Em Desvio") sem alterar a lógica central de outras classes.
3.  **L - Liskov Substitution Principle (LSP):** As coleções utilizam tipos base (como `List`) para garantir que qualquer implementação de lista possa ser usada sem quebrar os controladores.
4.  **D - Dependency Inversion Principle (DIP):** O `Main.java` instancia os controladores e os passa para as fronteiras, reduzindo o acoplamento direto entre as classes.

---

## 🔗 Desacoplamento e Encapsulamento

Uma das maiores forças deste projeto é o **baixo acoplamento**.
* **Independência de Interface:** Se decidirmos trocar o terminal por uma interface gráfica (Swing ou JavaFX), precisamos alterar apenas o pacote `boundary`. Toda a lógica de negócio nos `control` e `entity` permaneceria intacta.
* **Encapsulamento Estrito:** Atributos de classes como `Customer` e `Driver` são privados e protegidos por métodos de acesso. A classe `Cpf`, por exemplo, protege o dado interno permitindo apenas a visualização formatada através do método `getFormatted()`.

---

## 🚀 Como Funciona o Fluxo do Sistema

O projeto segue um ciclo de vida rigoroso para as operações:

1.  **Cadastro:** Motoristas são registrados com CNH, Veículo e Endereço completo.
2.  **Solicitação:** Uma corrida é criada. O sistema valida se a rua informada é atendida pela cooperativa (ex: Avenida Paulista).
3.  **Despacho (Dispatch):** O operador atribui um "VR Code" (identificador do rádio) à corrida.
4.  **Aviso e Embarque:** O status evolui de `AGUARDANDO_AVISO` para `AVISO_EFETUADO` e, finalmente, `TRIPULADO`.
5.  **Gestão:** Através dos menus de visão, é possível filtrar motoristas ativos/desativados e o histórico de corridas.

---

## 💻 Tecnologias Utilizadas
* **Java 21+:** Utilizando recursos modernos como `switch expressions` e classes implícitas no `Main`.
* **UUID:** Para geração de identificadores únicos e seguros para clientes.
* **Java Time API:** Gerenciamento preciso de datas de validade de CNH e horários de saída.

---
*Este projeto demonstra a transição de um código simples para uma arquitetura profissional, focada em regras de negócio claras e código limpo.*
