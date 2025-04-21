# 🔔 Gerenciador de Assinaturas (Em construção)🔔

### 🎯 Visão Geral

Este projeto consiste em uma API focada na **notificação de cotistas** sobre a necessidade de pagamento de assinaturas específicas. A API permitirá o cadastro e gerenciamento de informações essenciais das assinaturas para fins de notificação, garantindo que os cotistas sejam lembrados de realizar os pagamentos dentro do prazo.

### ✨ Funcionalidades Principais

* **⚙️ Gerenciamento de Assinaturas (para Notificação):**
    * ➕ Cadastrar informações básicas de uma assinatura (nome do serviço, valor a ser pago, periodicidade, dia de vencimento).
    * ✏️ Atualizar detalhes de uma assinatura existente.
    * 🗑️ Excluir o registro de uma assinatura.
    * 📄 Listar as assinaturas cadastradas para notificação.
* **👤 Gerenciamento de Cotistas:**
    * ➕ Cadastrar informações de contato dos cotistas (nome, e-mail, outros meios de comunicação).
    * 🔗 Associar cotistas a assinaturas específicas.
* **✉️ Notificações de Pagamento:**
    * 🗓️ Agendar notificações para cotistas com base na periodicidade e dia de vencimento de cada assinatura.
    * 📧 Enviar lembretes de pagamento por e-mail (ou outros meios configuráveis).
    * ✍️ Personalizar o conteúdo das mensagens de lembrete.
 
### 📚 Aprendizados Até Aqui

* **`@Transactional` (Spring Framework):** Esta anotação do Spring Framework é utilizada para definir o escopo de uma transação de banco de dados. Ao aplicá-la em um método, todas as operações de banco de dados dentro desse método serão executadas dentro de uma única transação. Se ocorrer alguma exceção durante a execução, todas as alterações feitas no banco de dados serão revertidas (rollback), garantindo a consistência dos dados. No contexto deste projeto, `@Transactional` foi usado ao adicionar uma assinatura a um cotista e vice-versa, assegurando que ambas as operações fossem bem-sucedidas para manter a integridade do relacionamento.

* **`@Scheduled` (Spring Framework):** Esta anotação do Spring Framework, parte do módulo de agendamento de tarefas (Spring Scheduler), permite agendar a execução de métodos Java em intervalos de tempo específicos ou em horários definidos através de expressões cron. Foi utilizada neste projeto para automatizar o processo de envio de lembretes de pagamento para assinaturas com periodicidade mensal, garantindo que as notificações sejam disparadas no momento correto.

* **`@JsonIgnore` (Jackson):** Esta anotação da biblioteca Jackson, utilizada para serialização e desserialização de objetos Java para JSON, é aplicada a um campo para indicar que ele deve ser ignorado durante o processo de conversão. No contexto deste projeto, `@JsonIgnore` foi utilizado para evitar referências cíclicas infinitas entre as entidades `Assinatura` e `Cotista`. Em um relacionamento bidirecional (onde uma assinatura conhece seus cotistas e um cotista conhece suas assinaturas), a serialização de um lado poderia levar à serialização do outro, e assim por diante, causando um loop infinito. `@JsonIgnore` em um dos lados da relação impede essa recursão.

* **`@JoinColumn` (JPA - Java Persistence API):** Esta anotação da JPA é utilizada para especificar a coluna de chave estrangeira em uma tabela que estabelece um relacionamento com outra tabela. Ela é geralmente usada no lado "filho" de um relacionamento (por exemplo, em um relacionamento um-para-muitos ou muitos-para-um). A anotação define o nome da coluna na tabela atual que contém a chave estrangeira referenciando a chave primária da tabela relacionada. No contexto deste projeto, considerando que um pagamento pode ter muitas assinaturas, mas uma assinatura só pode ter um pagamento, `@JoinColumn` seria usado na entidade `Assinatura` para referenciar a entidade `Pagamento`.

* **`@ManyToOne` (JPA - Java Persistence API):** Esta anotação da JPA define um relacionamento muitos-para-um entre duas entidades. No contexto deste projeto, dado que um pagamento pode estar associado a muitas assinaturas, e cada assinatura está associada a um único pagamento, a anotação `@ManyToOne` seria utilizada na entidade `Assinatura` para mapear o relacionamento com a entidade `Pagamento`. Isso indica que muitas instâncias de `Assinatura` podem se referir a uma única instância de `Pagamento`.


### ⏳ Backlog

* 🗓️ Implementar agendamento de notificações personalizadas (anual e semestral).
* 📄 Criar DTOs para preservar as entidades
* ⚙️ Definir a configuração de envio de notificações de cobrança.
* 📝 Implementar a criação de registros de cobrança com informações essenciais (nome do serviço, valor a ser pago, dia de pagamento).

### 🚀 Próximos Passos

* ☁️ **Implantação:** Preparar e realizar a implantação da API em um ambiente de nuvem (AWS).
* ⏰ **Notificações:** Implementar o envio de lembretes de pagamento com antecedência (ex: 7 dias).
* 🧠 **Inteligência:** Integrar recursos de inteligência artificial para fornecer informações relevantes (ex: próximos pagamentos).
  
