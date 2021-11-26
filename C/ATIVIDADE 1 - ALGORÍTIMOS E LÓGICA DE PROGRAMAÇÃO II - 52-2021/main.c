// Includes
#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

// Constants
#define reajuste 0.075
#define abono 150

// Procedures
void cabecalho()
{
    printf("|-----------------------------------------|\n");
    printf("|                                         |\n");
    printf("|            SHM Contabilidade            |\n");
    printf("|                                         |\n");
    printf("|      S�rgio H. Melges Carlos Pontes     |\n");
    printf("|                                         |\n");
    printf("|                      RA: 20128715-5     |\n");
    printf("|                                         |\n");
    printf("|-----------------------------------------|\n\n");
}

void menu()
{
    printf("|-----------------------------------------|\n");
    printf("|             Menu Principal              |\n");
    printf("|.........................................|\n");
    printf("|                                         |\n");
    printf("| 1. Calcular reajuste de sal�rios        |\n");
    printf("| 0. Sair                                 |\n");
    printf("|-----------------------------------------|\n");
    printf(" Escolha a fun��o desejada: ");
}

// Functions
void calc_reajuste(float sal_liq)
{
    float novo_sal;

    novo_sal = sal_liq + (sal_liq * reajuste);
    if (sal_liq <= 1700)
    {
        printf("\nSal�rio com reajuste: R$%.2f\nAbono: R$%u", novo_sal, abono);
        novo_sal += abono;
        printf("\nNovo sal�rio: R$%.2f\n\n", novo_sal);
    }
    else
    {
        printf("\nSal�rio com reajuste: R$%.2f\n\n", novo_sal);
    }
}

// Main Program
int main(void)
{
    setlocale(LC_ALL, "Portuguese");
    // Variables
    float sal_liq;
    unsigned int salarios = 0;
    unsigned int op = 0;

    cabecalho();
    menu();

    scanf("%u", &op);

    while (op != 0)
    {
        printf("\nCalcular reajuste do %u� sal�rio.\n", salarios);
        printf("Insira o sal�rio l�quido do colaborador: R$");
        scanf("%f", &sal_liq);

        calc_reajuste(sal_liq);

        printf("Continuar calculando? 1. Sim  0. N�o ");
        scanf("%u", &op);
        printf("\n");
    }

    system("pause");
    return 0;
}