# MAPA - BANCO DE DADOS

### QUESTÃO 1

Um cliente solicitou sua empresa a criação de um banco de dados para armazenar os pedidos de uma lanchonete. A solicitação engloba o cadastro produtos, seus respectivos preços e tipos, além do cadastro dos clientes e a forma de pagamento de cada pedido. Após a reunião da equipe de analistas o seguinte DER (diagrama de entidade e relacionamento) foi elaborado como representação dos requisitos obtidos com o cliente:


![img](https://sistemasead.unicesumar.edu.br/flex/amfphp/services/Portal/ImagemQuestionario2/QUE_107784_327329_1.png)
As tabelas a seguir contêm os dados dos pedidos:
![img](http://sistemasead.unicesumar.edu.br/flex/amfphp/services/Portal/ImagemQuestionario2/QUE_107784_327329_2.png)
 

**Chaves e Referências:**

 

**Tabela TIPO_PRODUTO:
-** ID é chave primária.
 

**Tabela TIPO_PAGTO:
-** ID é chave primária.
 

**Tabela PRODUTOS:**
\- ID é chave primária.
\- ID_TIPO_PRODUTO é chave estrangeira e referencia ID da tabela TIPO_PRODUTO.

**Tabela PEDIDOS:
-** ID é chave primária.
\- ID_TIPO_PAGTO é chave estrangeira e referencia ID da tabela TIPO_PAGTO.
 

**Tabela PEDIDOS_PRODUTOS:**
\- ID é chave primária.
\- ID_PEDIDO é chave estrangeira e referencia ID da tabela PEDIDOS.
\- ID_PRODUTO é chave estrangeira e referencia ID da tabela PRODUTOS.

Com base nas informações descritas no DER e tabelas apresentadas, realize as seguintes atividades:

1) Crie um script contendo os comandos de criação das tabelas (CREATE TABLE), lembrando que os tipos dos campos poderá ser ao seu critério, porém, não fugindo da necessidade do campo.

2) Crie um script contendo os comandos de inserção de dados (INSERT), onde seja feita a inserção dos dados descritos nas tabelas acima.

3) Crie os comandos para apagar o conteúdos das tabelas (DELETE).

Para esta atividade, você deve utilizar um software editor de texto no qual fará o desenvolvimento do seu trabalho. Esse arquivo deverá ser anexado no momento do envio. Muita atenção para enviar o arquivo correto, visto que o envio poderá ser feito uma única vez! Envie no formato doc ou pdf.