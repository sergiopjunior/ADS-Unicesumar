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
    printf("|      Sérgio H. Melges Carlos Pontes     |\n");
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
    printf("| 1. Calcular reajuste de salários        |\n");
    printf("| 0. Sair                                 |\n");
    printf("|-----------------------------------------|\n");
    printf(" Escolha a função desejada: ");
}

// Functions
void calc_reajuste(float sal_liq)
{
    float novo_sal;

    novo_sal = sal_liq + (sal_liq * reajuste);
    if (sal_liq <= 1700)
    {
        printf("\nSalário com reajuste: R$%.2f\nAbono: R$%u", novo_sal, abono);
        novo_sal += abono;
        printf("\nNovo salário: R$%.2f\n\n", novo_sal);
    }
    else
    {
        printf("\nSalário com reajuste: R$%.2f\n\n", novo_sal);
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
        printf("\nCalcular reajuste do %uº salário.\n", salarios);
        printf("Insira o salário líquido do colaborador: R$");
        scanf("%f", &sal_liq);

        calc_reajuste(sal_liq);

        printf("Continuar calculando? 1. Sim  0. Não ");
        scanf("%u", &op);
        printf("\n");
    }

    system("pause");
    return 0;
}