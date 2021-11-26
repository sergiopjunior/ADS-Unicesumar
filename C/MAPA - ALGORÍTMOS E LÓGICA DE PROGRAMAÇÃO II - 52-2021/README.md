# MAPA - ALGORÍTMOS E LÓGICA DE PROGRAMAÇÃO II

### QUESTÃO 1

Olá Caro aluno, nossa atividade mapa, será a construção de um algoritmo utilizando a linguagem C, mas antes, vamos a analisar o artigo a seguir:
 
**O que é um projeto?**
 
Um projeto é um esforço único, temporário e progressivo empreendido para criar um produto, serviço ou resultado exclusivo.
 
Isso significa que um projeto é uma ação especial que tem início e fim determinados (é, portanto, temporária), e um objetivo claro a ser atingido dentro dos recursos que são destinados a ele (humanos, financeiros e materiais). Geralmente, os projetos são divididos em etapas, as quais vão sendo executadas para gerar entregas.
 
Logo, os projetos não devem ter uma duração indefinida e nem recursos ilimitados — ambos devem ser planejados previamente para estabelecer uma linha de base a ser seguida.
 
Segundo o Guia PMBOK®, o sucesso de um projeto é medido pela qualidade do produto e do projeto, pela pontualidade, pelo cumprimento do orçamento e pelo grau de satisfação do cliente.
 
A seguir, vamos te explicar detalhadamente as principais características de um projeto:

**É único:** isso significa que um projeto não pode ser repetido continuamente, ele é um evento único e planejado. Por exemplo: se um engenheiro receber demandas de dois clientes diferentes para desenvolver empreendimentos com as mesmas características, não poderá oferecer o mesmo projeto para os dois. Isso porque cada projeto terá membros, especificidades técnicas, locais de aplicação, disponibilidade de recursos e provavelmente datas de início e término diferentes.

**Tem início e fim definidos:** quando dizemos que um projeto é temporário, isso não quer dizer que ele terá curto prazo, mas que há um início e um fim definidos, um prazo a ser respeitado.

**É progressivo:** considerando o prazo de conclusão que tem que ser atingido, o projeto deve ser dividido em etapas e não entregue de uma vez só. Geralmente, as entregas são compostas por tarefas que interagem entre si e dependem umas das outras. Por exemplo, para construir uma casa, é preciso construir as fundações antes de levantar as paredes. São tarefas ou atividades progressivas que vão dando forma à entrega final.

**Tem delimitação de recursos:** os insumos para executar um projeto são limitados conforme o que consta no escopo do projeto. Para definir as linhas de base dos recursos (sejam eles humanos, financeiros ou materiais), é comum que se faça um levantamento de custos antes da execução, para garantir que a falta de algum recurso inviabilize a entrega do projeto.

**Tem objetivo claro e viável:** mais uma característica dos projetos é que eles são feitos com um objetivo claro e viável, isto é, possível de ser alcançado. É necessário esclarecer, porém que um projeto não é uma meta, um desejo ou mesmo a visão de futuro de uma empresa: ele pode ser um caminho para alcançá-los.

Confira alguns exemplos para entender melhor o que é um projeto:
\- Desenvolver um novo produto, serviço ou resultado;
\- Efetuar uma mudança na estrutura, envolvendo pessoas e/ou processos;
\- Adquirir, modificar ou desenvolver um sistema;
\- Realizar uma pesquisa cujo resultado será divulgado;
\- Construir um prédio, planta industrial ou infraestrutura.

De acordo com Artia (2020), para montar um projeto existem diversas ferramentas que auxiliam o projetista tanto na construção quanto na administração. Contudo, nesta **atividade MAPA, iremos criar a nossa própria ferramenta para armazenar os projetos.** Para construir esta ferramenta iremos utilizar a Linguagem C, e o armazenamento dos dados, ficará em memória**.**

**O que iremos armazenar?**
1 – Iremos armazenar os campos básicos de um projeto, tais como: Código, Titulo, Descrição, Ano, Status e o Gerente de Projetos responsável.

**Regras:**
1 - O código do projeto é sequencial (1, 2, 3, ...), ou seja, ao cadastrar um novo projeto o sistema incrementa o código de forma automática.
2 – Não permitir que ultrapasse o número máximo de 200 projetos e que existam projetos com o mesmo código.
3 – Ao cadastrar um projeto, no campo status deve ser armazenado 1, 2 ou 3, sendo que 1 representa “A fazer”, 2 “Fazendo” e 3 “Concluído".
4 – Não iremos armazenar os dados em arquivo, os mesmos ficarão em memória, ou seja, encerrando a execução do programa, os dados serão apagados.

**O que deve conter no meu código?**

**1 – Uma função para Cadastrar Projetos:**
1.1 – Armazenar os campos básicos descritos anteriormente e incluir mais 3 campos que julgar necessário.
1.2 – Utilizar as regras estabelecidas anteriormente.

**2 – Rotinas de Impressão, sendo:**
2.1 – Todos os projetos.
2.2 – Todos os projetos com o Status: A Fazer.
2.2 – Todos os projetos com o Status: Fazendo.
2.2 – Todos os projetos com o Status: Concluído.
2.4 – Gerar uma nova rotina de impressão de projetos diferente das solicitadas anteriormente.

**3 – Menu**
3.1 – Criar um menu que possibilite ao usuário escolher as opções para **cadastro** e **impressões de todos os itens anteriomente descritos.**