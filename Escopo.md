Sistema de Manutenção Preventiva e Corretiva

## Escopo
O **Sistema de Manutenção Preventiva e Corretiva** visa aufacilitar gerenciamento das manutenções de máquinas e equipamentos industriais, aumentando a eficiência e reduzindo os tempos de inatividade. Ele permitirá o controle de manutenções preventivas, o registro de falhas e a alocação de técnicos para manutenções corretivas, além da geração de relatórios desimples

## Análise de Risco
- **Atrasos no cronograma**: Mitigar com reuniões semanais de acompanhamento e planejamento realista de tarefas.
- **Problemas de integração de sistemas existentes**: Realizar análise prévia e garantir que o sistema seja modular para facilitar a integração.
- **Capacidade de resposta dos técnicos**: Treinar a equipe técnica no uso do sistema, garantindo rápida adaptação e uso adequado.
- **Falhas de segurança**: Implementar autenticação robusta e controle de acesso para proteger os dados do sistema.
 
- ** 
## Recursos

##
### Ferramentas
- **Java**: Backend.
- **JavaFXSwing e Netbeans: Frontend.
- **pgAdmin**: Banco de dados para armazenar os registros de manutenção.
- **GitHub**: Controle de versão.
- **Pusher**: Notificações em tempo real.

##
## Cadastro de Máquinas, Equipamentos e Histórico de Manutenção

### Máquinas e Equipamentos:
Registro completo de cada máquina ou equipamento presente no parque industrial, incluindo:
- Identificação (código, nome da máquina, modelo, fabricante).
- Data de aquisição e
- Localização dentro da planta industrial (setor, linha de produção, etc.).
 (em analise)
- Especificações técnicas e manual de operação.
- Histórico completo de intervenções (manutenções preventivas e corretivas).

### Histórico de Manutenção:
Registro detalhado de todas as atividades de manutenção já realizadas:
- Data da manutenção.
- Tipo de intervenção (preventiva ou corretiva).
- Peças trocadas ou reparadas.
- Tempo de parada.
- Técnico responsável pela intervenção.
- Observações sobre o estado do equipamento antes e depois da intervenção.

## Registro de Ocorrências de Falhas e Manutenção Corretiva

### Ocorrências de Falhas:
O sistema deve permitir o registro de falhas e problemas inesperados com máquinas e equipamentos. Cada falha registrada deve incluir:
- Data e hora da ocorrência.
- Máquina ou equipamento envolvido.
- Descrição do problema identificado.
- Nível de criticidade (impacto na produção).
- Operador que detectou a falha.

### Manutenção Corretiva:
A partir do registro de falhas, o sistema deve permitir a criação de ordens de serviço para manutenções corretivas:
- Prioridade da manutenção com base na criticidade da falha.
- Alocação automática ou manual de técnicos disponíveis para resolver o problema.
- Registro de tempo de resposta e tempo total da intervenção.
- Cálculo de tempo de máquina parada.

### Acompanhamento em Tempo Real:
Visualização em tempo real das manutenções corretivas em andamento, com informações sobre:
- Fase de execução.
- Técnico alocado.
- Tempo restante previsto.

## Manutenção Preventiva Programada

### Criação de Planos de Manutenção Preventiva:
O sistema deve permitir a criação de planos de manutenção preventiva com base em cronogramas pré-definidos ou medições de uso (como horas de operação ou ciclos de produção):
- Definição de frequência (diária, semanal, mensal, trimestral, etc.).
- Tarefas a serem realizadas em cada inspeção ou intervenção.
- Alocação de técnicos responsáveis.
- Notificações automáticas para o agendamento de manutenções preventivas futuras.

### Automatização de Alertas e Ordens de Serviço:
O sistema deve enviar notificações automáticas aos responsáveis quando uma manutenção preventiva estiver se aproximando, gerando ordens de serviço automaticamente:
- Notificações para técnicos e supervisores.
- Registro de status de cada ordem de serviço (pendente, em andamento, concluída).
- Relatório de conformidade com o cronograma de manutenção preventiva.

## Geração de Relatórios de Histórico de Manutenção

### Relatórios de Manutenção Corretiva e Preventiva:
O sistema deve ser capaz de gerar relatórios dee todas as manutenções realizadas:
- Frequência de manutenções preventivas versus corretivas.
- Comparação entre o tempo planejado e o tempo real das manutenções.
- Custo de manutenção (peças e mão de obra).
- Análise de falhas recorrentes em máquinas específicas.

### Relatórios de Técnicos:
Avacompanhamentoe cada técnico ou equipe de manutenção:
- Tempo de resposta para manutenções corretivas.
- Qualidade do serviço (com base no número de reincidências de falhas).
- Carga de trabalho e número de intervenções realizadas.

## Interface Gráfica para Acompanhamento do Status de Manutenção e Alocação de Técnicos

### Painel de Controle em Tempo Real:
A interface gráfica deve permitir o acompanhamento eo status de todas as manutenções (preventivas e corretivas) e do desempenho das máquinas. Funcionalidades incluem:
- Visualização de quais máquinas estão em operação, em manutenção ou paradas.
- Status das ordens de serviço (pendentes, em execução, concluídas).
- 
### Alocação de Técnicos e Recursos:
A interface também deve permitir a alocação me técnicos para as intervenções, com base em:
- Agenda de cada técnico.
- Especialização do técnico para cada tipo de máquina ou problema.
