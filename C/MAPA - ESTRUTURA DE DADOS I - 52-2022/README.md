# MAPA - ESTRUTURA DE DADOS I

### QUESTÃO 1

Tanto a fila como a pilha são conjuntos ordenados de itens, porém ambas se diferenciam pelas regras de inserção e remoção de elementos. Na pilha, a entrada e a saída de dados se dão pela mesma extremidade, chamada de topo da pilha. Na fila, a entrada e a saída ocorrem em lugares opostos: a entrada acontece no final da fila e a saída no seu início.
OLIVEIRA, Pietro Martins de; LEON, Rogério de. Estrutura de Dados I. Maringá-PR, Unicesumar, 2019.

Uma pilha não passa de uma estrutura de dados linear que segue a regra LIFO (Last In First Out). Em uma pilha, tanto a inserção quanto a exclusão ocorrem a partir de apenas uma extremidade, ou seja, a partir do topo.

**Considere o seguinte cenário:**
Imagine que você tem 5 pratos de cores distintas: (1) Vermelho, (2) Verde, (3) Azul, (4) Branco e (5) Laranja e precisa mantê-los um em cima do outro. Você começa colocando o prato de cor vermelha sobre a mesa. Este é o primeiro elemento da pilha. Em seguida, você coloca o verde em cima do vermelho. Este é o segundo elemento da pilha. Da mesma forma, você coloca o prato azul seguido do branco e, finalmente, o laranja.
Note que o primeiro prato que você inseriu na pilha foi o vermelho, e agora você quer ordena-los  de forma inversa: 5, 4, 3, 2 e 1.
A partir dessas informações você deverá desenvolver um programa em Linguagem C que execute os seguintes passos:
1 - Preencher uma pilha com os cinco pratos citados acima;
2 - Imprimir a pilha na ordem em que os elementos foram inseridos (iniciando pela base, e finalizando pelo topo);
3 – Desempilhar todos os elementos, inserindo-os em uma segunda estrutura de dados do tipo pilha;
4 - Imprimir a nova pilha na ordem em que os elementos foram inseridos (iniciando pela base, e finalizando pelo topo).

**DICA:**
A primeira impressão dos dados que seu programa deve fazer está relacionada ao conteúdo da primeira pilha (itens 1 e 2 do passo a passo apresentado acima). Já a segunda impressão dos dados que seu programa fará, está relacionada aos dados que foram inseridos na segunda pilha.
**Método de entrega:** enviar o código fonte (arquivo.c) nomeando o arquivo com seu nome completo. Exemplo: Pietro_Martins_de_Oliveira.c