# MAPA - ADS - PROGRAMAÇÃO I

### QUESTÃO 1

Mapa 1 – Controle de Estoque
 
Para a atividade mapa da disciplina, analise o estudo de caso de um controle de estoque e desenvolva o programa para solucionar o problema.

O **DONO DE UMA EMPRESA DE IMPORTAÇÃO** necessita de um sistema para efetuar o controle da entrada e saída de mercadorias no estoque de sua empresa.
Para isso, ele informa que as operações diárias se resume em quatro funções que o sistema precisa contemplar, que são:
Cadastro de Produtos: consiste nas operações de inclusão, alteração, consulta e exclusão de um produto.
Movimentação: consiste nas operações de entrada e saída de produtos no estoque.
Reajuste de Preços: consiste em aumentar o preço unitário por percentual de um ou mais produtos do estoque.
Relatório: lista de Produtos.


O **DONO DE UMA EMPRESA DE IMPORTAÇÃO** informa que é necessário um controle eficiente do estoque, que permita a sua empresa ter um planejamento melhor de suas compras, na medida em que tem condições de saber quando e quanto deverá comprar para repor suas necessidades e atender bem a demanda de seus clientes.
O controle do estoque é feito pela atualização das quantidades disponíveis de cada um dos itens do estoque. Isso é feito por meio de um levantamento de todos os produtos com os quais a empresa trabalha. Após o levantamento, todos os produtos deverão ser mantidos no sistema (operações de inclusão, alteração, consulta e exclusão de produtos), para que a partir desse momento, o sistema reflita exatamente o que existe no estoque da empresa.
A cada nova entrada ou saída de produtos do estoque (movimentação), o saldo atual do produto é atualizado.


Para o **DONO DE UMA EMPRESA DE IMPORTAÇÃO**, existem um relatório importante:
Lista de Preços: uma relação de todos os produtos do estoque, constando o preço de cada um deles, unidade medida e quantidade.
As informações de um produto são:
Nome;
Preço Unitário;
Unidade;
Quantidade em Estoque.

Crie um programa que utilize a orientação objeto em Java.
O sistema deverá oferecer uma interface com o usuário simples, com diálogos explicativos.
O programa deverá ser desenvolvido dentro de boas técnicas de programação e utilizar a orientação a objetos (JAVABEAN).
Os relatórios deverão ser feitos para serem exibidos no vídeo.
Os dados deverão ser armazenados em memória.
Alguns layouts de telas são representados, a seguir, como sugestão, podendo ser alterados esteticamente, desde que apresentem as informações e funcionalidades especificadas.



| EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA. SISTEMA DE CONTROLE DE ESTOQUE MENU PRINCIPAL 1 - CADASTRO DE PRODUTOS 2 - MOVIMENTAÇÃO 3 - REAJUSTE DE PREÇOS 4 - RELATÓRIOS 0 - FINALIZAR OPÇÃO: _ | TELA 1.0 Selecionando-se a opção 0 (Finalizar), o programa de ser concluído. |
| :----------------------------------------------------------- | ------------------------------------------------------------ |
| EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA. SISTEMA DE CONTROLE DE ESTOQUE CADASTRO DE PRODUTOS 1 - INCLUSÃO 2 - ALTERAÇÃO 3 - CONSULTA 4 - EXCLUSÃO 0 - RETORNAR OPÇÃO: _ | TELA 1.1 Selecionando-se a opção 1 na tela 1.0 passa-se para a tela 1.1 Selecionando-se a opção 0 (retornar), na tela 1.1 deve-se retornar para a tela 1.0 |
| EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA. SISTEMA DE CONTROLE DE ESTOQUE INCLUSÃO DE PRODUTO NOME: PREÇO: UNIDADE: QUANTIDADE: CONFIRMA INCLUSÃO (S/N)? _ REPETIR OPERAÇÃO (S/N)? _ | TELA 1.1.1 Deve-se validar o nome do produto, não podem existir produtos de mesmo nome. O preço deve ser maior que zero. A quantidade deve ser maior ou igual a zero. Caso algum dos critérios de validação anterior não seja atendido, deve-se exibir uma mensagem de erro e solicitar a redigitação da informação errada. Deve-se pedir a confirmação da inclusão antes de efetuá-la, caso não seja confirmada, deve-se ignorar o cadastro. Ao final da operação deve-se retornar à tela 1.1. |
| EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA. SISTEMA DE CONTROLE DE ESTOQUE ALTERAÇÃO DE PRODUTO NOME: PREÇO: UNIDADE: QUANTIDADE: CONFIRMA ALTERAÇÃO (S/N)? _ REPETIR OPERAÇÃO (S/N)? _ | TELA 1.1.2 Deve-se ler o nome do produto e verificar se ele já está cadastrado. Se estiver, então deve-se exibir os seus dados e ler as alterações. Não pode ser alterado o nome do produto, para tal deve-se excluí-lo e recadastrá-lo; Caso algum dos critérios de validação não seja atendido, deve-se exibir mensagens de erro e solicitar a redigitação da informação errada. Deve-se pedir a confirmação da alteração antes de efetuá-la Ao final da operação deve-se retornar à tela 1.1. |
| EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA. SISTEMA DE CONTROLE DE ESTOQUE CONSULTA DE PRODUTO NOME: PREÇO: UNIDADE: QUANTIDADE: REPETIR OPERAÇÃO (S/N)? _ | TELA 1.1.3 Deve-se ler o nome do produto e verificar se ele já está cadastrado. Se estiver então deve-se exibir os seus dados. Ao final da operação deve-se retornar à tela 1.1. |
| EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA. SISTEMA DE CONTROLE DE ESTOQUE EXCLUSÃO DE PRODUTO NOME: PREÇO: UNIDADE: QUANTIDADE: CONFIRMA EXCLUSÃO (S/N)? _ REPETIR OPERAÇÃO (S/N)? _ | TELA 1.1.4 Deve-se ler o nome do produto e verificar se ele já está cadastrado. Se estiver, então deve-se exibir os seus dados. Deve-se pedir a confirmação da exclusão antes de efetuá-la. Ao final da operação deve-se retornar à tela 1.1. |
| EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA. SISTEMA DE CONTROLE DE ESTOQUE MOVIMENTAÇÃO 1 - ENTRADA 2 - SAÍDA 0 - RETORNAR OPÇÃO: _ | TELA 1.2 Selecionando-se a opção 2 na tela 1.0 passa-se para a tela 1.2 Selecionando-se a opção 0 (retornar), na tela 1.2 deve-se retornar para a tela 1.0 |
| EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA. SISTEMA DE CONTROLE DE ESTOQUE MOVIMENTAÇÃO - ENTRADA DE PRODUTO PRODUTO: QTDE ATUAL: QTDE ENTRADA: QTDE FINAL: CONFIRMA ENTRADA (S/N)? _ REPETIR OPERAÇÃO (S/N)? _ | TELA 1.2.1 Selecionando-se a opção 2 na tela 1.2 passa-se para a tela 1.2.1 Deve-se ler o nome do produto e verificar se ele já está cadastrado. Se estiver, então deve-se exibir os seus dados e ler a quantidade da entrada. Caso algum dos critérios de validação não seja atendido, deve-se exibir mensagens de erro e solicitar a redigitação da informação errada. Deve-se pedir a confirmação da operação antes de efetuá-la. Ao final da operação deve-se retornar à tela 1.2 |