# **Manual de Uso do Sistema de Manutenção Preventiva e Corretiva**

## **1. Introdução**

Este manual orienta o usuário no uso do **Sistema de Manutenção Preventiva e Corretiva**, projetado para gerenciar a manutenção de máquinas e equipamentos industriais. O sistema oferece funcionalidades para cadastro, gerenciamento, acompanhamento de falhas e manutenções.

## **2. Requisitos de Acesso**

- **Sistema Operacional**: Windows, Linux ou macOS.
- **Java**: Necessário ter o Java instalado para executar o sistema.
- **Banco de Dados**: O sistema utiliza o PostgreSQL gerenciado pelo pgAdmin para armazenamento de dados.

## **3. Login e Acesso**

### 3.1. Acesso ao Sistema

1. Abra o aplicativo e insira seu nome de usuário e senha na tela de login.
2. Após autenticar, você será redirecionado para o Painel Principal de acordo com seu tipo de login (supervisor ou tecnico).

## **4. Painel Principal Supervisor**

### 4.1. Menu de Navegação

O menu principal, localizado à esquerda da tela, inclui as seguintes opções:

- **Máquinas**: Cadastro e gerenciamento de máquinas.
- **Lista**: Acesso a Lista de maquinas em manutenções.

  ## **5. Painel Principal Tecnico**

### 5.1. Menu de Navegação

O menu principal, localizado à esquerda da tela, inclui as seguintes opções:

- **Lista**: Acesso a Lista de maquinas em manutenções.
- **Concluir Manutenção**: Permite que o técnico selecione uma máquina da lista e marque a manutenção como concluída.

## **6. Cadastro de Máquinas e Equipamentos**

### 6.1. Adicionar Nova Máquina

1. No menu lateral, clique em **Máquinas e Equipamentos**.
2. Clique no botão **Adicionar Máquina**.
3. Preencha as informações solicitadas, como:

   - Nome da máquina.
   - Modelo.
   - Fabricante.
   - Ano de fabricação.

4. Clique em **Cadastrar**.

### 6.2. Atualizar Máquina

1. Selecione a máquina na lista de equipamentos.
2. Edite os campos desejados e clique em **Atualizar Maquinas**.

### 6.3. Histórico de Manutenção

- Ao acessar uma máquina, você pode visualizar seu histórico de manutenções realizadas.

## **7. Gerenciamento de Manutenção**

### 7.1. Criar Ordem de Serviço

1. No menu, acesse **Ordens de Serviço**.
2. Clique em **Criar Ordem de Serviço**.
3. Selecione a máquina ou equipamento que requer manutenção.
4. Informe o tipo de manutenção (preventiva ou corretiva).
5. Defina a prioridade e o técnico responsável.
6. Clique em **Criar** para gerar a ordem.

### 7.2. Atualizar Status de Ordem

1. Na lista de ordens, clique sobre a ordem de serviço desejada.
2. Atualize o status (pendente, em execução, concluída).
3. Insira observações e detalhes sobre as peças trocadas e o tempo de manutenção.

## **8. Manutenção Preventiva**

### 8.1. Criar Plano de Manutenção

1. Vá para **Ordens de Serviço** e clique em **Criar Plano de Manutenção**.
2. Defina a periodicidade (diária, semanal, mensal) e as tarefas a serem executadas.
3. Defina os responsáveis e o cronograma.

## **9. Fluxo Básico de Uso da Aplicação**

1. **Login**: Inicie o sistema e faça login com suas credenciais.
2. **Cadastro**: Se você for um supervisor, poderá cadastrar novas máquinas.
3. **Consultas**: Todos os usuários podem consultar máquinas existentes.
4. **Manutenção**: Supervisores podem marcar máquinas para manutenção e tecnicos podem atualizar status de ordens.
5. **Geração de Relatórios**: Supervisores podem gerar relatórios sobre o estado das máquinas.
6. **Logout**: Ao final do uso, clique no botão **Sair** para finalizar a sessão.

---
