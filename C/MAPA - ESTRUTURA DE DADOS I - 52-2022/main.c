#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

#define ARRAY_SIZE 5
#define WORD_SIZE 255

struct Pilha {
	int tamanho;
    int max_pratos;
	char *pratos[ARRAY_SIZE];
};

bool PilhaVazia(struct Pilha *p) {
    if (p->tamanho > 0)
        return false;
    printf("A pilha está vazia!\n");
    return true;
}

bool PilhaCheia(struct Pilha *p) {
    if (p->tamanho >= p->max_pratos) {
        printf("A pilha está cheia!\n");
        return true;
    }
    return false;
}

struct Pilha CriarPilha(){
   struct Pilha p;
   p.tamanho = 0;
   p.max_pratos = ARRAY_SIZE;
   return p;
}

char* EmpilharPrato(struct Pilha *p, char *prato){
    if (!PilhaCheia(p))
    {
        // printf("Prato empilhado: %d - %s\n", p->tamanho + 1, prato);
        p->pratos[p->tamanho] = prato;
        p->tamanho = p->tamanho + 1;
        return prato;
    }
    return "";
}

char* DesempilharPrato ( struct Pilha *p ){
    if (!PilhaVazia(p)) {
        // printf("Prato desempilhado: %d - %s\n", p->tamanho, p->pratos[p->tamanho-1]);
        char* temp = p->pratos[p->tamanho-1];
        p->pratos[p->tamanho-1] = "";
        p->tamanho = p->tamanho - 1;
        return temp;
    }
    return "";
}

void ImprimirPilha(struct Pilha *p) {
    if (!PilhaVazia(p)){
        printf("Pilha de pratos:\n");
        for (int i = 0; i < p->tamanho; i++)
            printf("%d - %s\n", i+1, p->pratos[i]);
    }
}

void ZerarPilha(struct Pilha *p) { 
    int temp = p->tamanho;
    for (int j = 0; j < temp; j++)
        DesempilharPrato(p);
}

struct Pilha InverterPilha(struct Pilha *p) {
    struct Pilha pilha_invertida = CriarPilha();
    int temp = p->tamanho - 1;

    for (int i = temp; i >= 0; --i)
        EmpilharPrato(&pilha_invertida, DesempilharPrato(p));
    
    return pilha_invertida;
}

int main(void){
    struct Pilha p = CriarPilha();
    // (1) Vermelho, (2) Verde, (3) Azul, (4) Branco e (5) Laranja
    // Passo 1 - Preencher uma pilha com os cinco pratos citados acima;
    EmpilharPrato(&p, "Vermelho");
    EmpilharPrato(&p, "Verde");
    EmpilharPrato(&p, "Azul");
    EmpilharPrato(&p, "Branco");
    EmpilharPrato(&p, "Laranja");

    // Passo 2 - Imprimir a pilha na ordem em que os elementos foram inseridos (iniciando pela base, e finalizando pelo topo);
    printf("Pilha 1: (1) Vermelho, (2) Verde, (3) Azul, (4) Branco e (5) Laranja\n");
    ImprimirPilha(&p);

    // Passo 3 – Desempilhar todos os elementos, inserindo-os em uma segunda estrutura de dados do tipo pilha;
    //ZerarPilha(&p);
    /*DesempilharPrato(&p);
    DesempilharPrato(&p);
    DesempilharPrato(&p);
    DesempilharPrato(&p);
    DesempilharPrato(&p);*/
    struct Pilha p2 = InverterPilha(&p);

    // Passo 4 - Imprimir a nova pilha na ordem em que os elementos foram inseridos (iniciando pela base, e finalizando pelo topo).
    printf("\nPilha 2: (1) Laranja, (2) Branco, (3) Azul, (4) Verde e (5) Vermelho\n");
    ImprimirPilha(&p2);

    return 0;

}