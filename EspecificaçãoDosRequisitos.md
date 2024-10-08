

# Especificação de Requisitos do Sistema de Gerenciamento de Máquinas

## 1. Introdução

Este documento contém a especificação de requisitos do Sistema de Gerenciamento de Máquinas, que tem como objetivo permitir o gerenciamento eficiente de máquinas e a manutenção preventiva e corretiva em uma empresa.

## 2. Escopo do Sistema

O sistema será responsável por:

- Gerenciar o cadastro de máquinas.
- Permitir a atualização e remoção de máquinas.
- Registrar manutenções preventivas e corretivas.
- Fornecer relatórios sobre a situação das máquinas e manutenções.
- Garantir que apenas usuários autorizados (supervisores e técnicos) possam acessar as funcionalidades do sistema.

### 2.1. Usuários

Os usuários do sistema são:

- **Supervisor:** Pode cadastrar, editar e remover máquinas.
- **Técnico:** Pode concluir manutenções e visualizar máquinas em manutenção.

## 3. Funcionalidades do Sistema

### 3.1. Módulo de Login

- **Requisito 3.1.1:** O sistema deve permitir que usuários façam login com Nome e senha.
- **Requisito 3.1.2:** O sistema deve verificar as credenciais do usuário e redirecioná-lo para a interface correspondente (Supervisor ou Técnico).

### 3.2. Gerenciamento de Máquinas

- **Requisito 3.2.1:** O supervisor deve poder adicionar novas máquinas ao sistema.
- **Requisito 3.2.2:** O supervisor deve poder editar os detalhes de máquinas existentes.
- **Requisito 3.2.3:** O supervisor deve poder remover máquinas do sistema. 


### 3.3. Marcação de Manutenção

- **Requisito 3.3.1:** O técnico deve poder concluir a manutenção de uma máquina.
- **Requisito 3.3.2:** O técnico deve poder visualizar a lista de máquinas em manutenção. 
- **Requisito 3.3.3:** O supervisor deve poder marcar máquinas para manutenções.


### 3.4. Relatórios

- **Requisito 3.4.1:** O supervisor deve poder gerar relatórios sobre o estado das máquinas e histórico de manutenções.

## 4. Requisitos Funcionais

Os requisitos funcionais do sistema incluem:

- O sistema deve ser capaz de se conectar a um banco de dados para armazenar informações sobre máquinas e usuários.
- O sistema deve permitir autenticação de usuários.
- O sistema deve ter uma interface gráfica amigável e responsiva para todos os usuários.
- O sistema deve apresentar mensagens de erro e sucesso apropriadas ao usuário.

## 5. Requisitos Não Funcionais

- **Requisito 5.1:** O sistema deve ser seguro e proteger os dados dos usuários.
- **Requisito 5.2:** O sistema deve ter um tempo de resposta de no máximo 2 segundos para as operações mais comuns.
- **Requisito 5.3:** O sistema deve ser compatível com as versões mais recentes de navegadores populares.

## 6. Validação dos Requisitos

Para validar os requisitos do sistema, será realizado um conjunto de testes, incluindo:

- Testes funcionais para verificar se cada funcionalidade foi implementada conforme especificado.
- Testes de usabilidade para garantir que a interface do usuário seja intuitiva.
- Testes de segurança para garantir que os dados dos usuários estejam protegidos.

---

