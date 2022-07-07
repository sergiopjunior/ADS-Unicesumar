#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

#define RA "201287155"
#define RA_EXAMPLE "61207895"

struct No {
    int elemento;
    struct No *no_esquerdo;
    struct No *no_direito;
};
typedef struct No No;

struct Arvore {
    No *no_raiz;
};
typedef struct Arvore Arvore;

struct Arvore CriarArvore() {
    struct Arvore a;
    a.no_raiz = NULL;

    return a;
};

void ImprimirEmOrdem(No *no){
    if(no){
        ImprimirEmOrdem(no->no_esquerdo);
        printf("%d ", no->elemento);
        ImprimirEmOrdem(no->no_direito);
    }
}

void ImprimirArvoreEmOrdem(Arvore *a){
    ImprimirEmOrdem(a->no_raiz);
    printf("\n");
}

void ImprimirPreOrdem(No *no) {
    if (no) {
        printf("%d ", no->elemento);
        ImprimirPreOrdem(no->no_esquerdo);
        ImprimirPreOrdem(no->no_direito);
    }
}

void ImprimirArvorePreOrdem(Arvore *a) {
    ImprimirPreOrdem(a->no_raiz);
    printf("\n");
};

void ImprimirPosOrdem(No *no) {
    if (no) {
        ImprimirPosOrdem(no->no_esquerdo);
        ImprimirPosOrdem(no->no_direito);
        printf("%d ", no->elemento);
    }
}

void ImprimirArvorePosOrdem(Arvore *a){
    ImprimirPosOrdem(a->no_raiz);
    printf("\n");
}

void Inserir(No **raiz, int elemento) {
    if (!*raiz) {
       *raiz=(No *)malloc(sizeof (No));
	    (*raiz)->no_esquerdo= NULL;
	    (*raiz)->no_direito= NULL;
	    (*raiz)->elemento= elemento;
    }
    else {
        if (elemento < (*raiz)->elemento) {
            Inserir(&((*raiz)->no_esquerdo), elemento);
        }
        else {
            Inserir(&((*raiz)->no_direito), elemento);
        }
    }
}

void InserirElemento(Arvore *a, int elemento) {
    Inserir(&a->no_raiz, elemento);
}

int main(void) {
    struct Arvore a = CriarArvore();
    
    // 2 0 1 2 8 7 1 5 5
    for (int i = 0; i < strlen(RA); i++) {
        InserirElemento(&a, RA[i] - '0');
    }

    // 2 0 1 2 8 7 1 5 5
    /*InserirElemento(&a, 6);
    InserirElemento(&a, 1);
    InserirElemento(&a, 2);
    InserirElemento(&a, 0);
    InserirElemento(&a, 7);
    InserirElemento(&a, 8);
    InserirElemento(&a, 9);
    InserirElemento(&a, 5);*/

    // 0 1 1 2 2 5 5 7 8
    // ImprimirArvoreEmOrdem(&a);

    // 2 0 1 1 2 8 7 5 5
    ImprimirArvorePreOrdem(&a);

    // 1 1 0 5 5 7 8 2 2
    // ImprimirArvorePosOrdem(&a);
    return 0;
}