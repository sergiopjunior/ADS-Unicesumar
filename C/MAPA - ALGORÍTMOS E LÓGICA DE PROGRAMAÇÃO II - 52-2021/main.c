// Includes
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <locale.h>

// Constants
#define max_projetos 200

// Structs
typedef struct
{
    unsigned int codigo;
    char titulo[100];
    char descricao[256];
    unsigned int data[3];
    unsigned int status;
    double orcamento;
    char gerente_resp[256];
    unsigned int num_funcionarios;
} Projeto;

typedef struct
{
    unsigned int ultimo_codigo;
    unsigned int num_projetos;
    Projeto projetos[max_projetos];
} ProjetosClass;

// Global Variables

// Functions
// Copia o conteúdo da string source para a string dest
char strcopy(char source[256], char dest[256])
{
    sprintf(dest, "%.*s", (int)strcspn(source, "\n"), source);
}

// Converte string para int
long str2int(char buffer[256], int base)
{
    // char *ptr; - Ponteiro que recebe a parte não númerica da string
    long ret = strtol(buffer, NULL, base);

    return ret;
}

// Converte string para double
double str2double(char buffer[256])
{
    double ret = strtod(buffer, NULL);

    return ret;
}

// Retorna true se buffer[256] for um número
bool is_number(char buffer[256])
{
    int op;

    return (sscanf(buffer, "%d", &op) == 1);
}

// Retorna true se date[] for uma data válida
bool is_valid_date(int date[])
{
    int meses_dias[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    if ((date[2] > 0) && (0 < date[1]) && (date[1] < 13))
    {
        if ((0 < date[0]) && (date[0] <= meses_dias[date[1] - 1]))
        {
            printf("\nMês: %d - %d dias", date[1], meses_dias[date[1] - 1]);
            return true;
        }
    }
    return false;
}

// Executa um parse na string contendo a data e
// retorna um array contendo os valores convertidos para int
int *get_date_array(char string[256])
{
    static int date[3] = {-1, -1, -1};
    char delimiter[] = "/";
    char *ptr = strtok(string, delimiter);

    int i = 0;
    while (ptr != NULL)
    {
        int num = atoi(ptr);

        if (is_number(ptr))
        {
            date[i] = num;
            //printf(" %d", date[i]);
        }

        ptr = strtok(NULL, delimiter);
        i++;
    }
    return date;
}

// Retorna false caso e imprime na tela caso buffer[256]
// contenha caracteres não numéricos
bool is_valid_option(char buffer[256])
{
    if (!is_number(buffer))
    {
        printf(" Opção inválida! Apenas números são aceitos.");
        getchar();
        return false;
    }
    return true;
}

// Imprime os dados do projeto a ser cadastrado
// e requisita uma confirmação para a conclusão da operação
int confirmar_cadastro(Projeto projeto)
{
    char buffer[256];
    int op = -1;

    printf("\n Dados do novo projeto:");
    imprimir_projeto(projeto, 0);
    while (op != 0 && op != 1)
    {
        printf("\n Confirmar cadastro (1. Sim; 0. Não): ");
        fgets(buffer, sizeof buffer, stdin);
        if (is_valid_option(buffer))
        {
            op = str2int(buffer, 10);
            if (!(0 <= op <= 1))
            {
                printf("ERRO: Opção inválida! Escolha uma das opções disponíveis,");
                getchar();
            }
        }
    }
    return op;
}

// Imprime os dados do projeto
void imprimir_projeto(Projeto projeto, int num)
{
    if (num)
        printf("\n %d.", num);
    printf("\n   Código: %d", projeto.codigo);
    printf("\n   Título: %s", projeto.titulo);
    printf("\n   Descrição: %s", projeto.descricao);
    printf("\n   Data: %d/%d/%d", projeto.data[0], projeto.data[1], projeto.data[2]);
    printf("\n   Status: %d", projeto.status);
    printf("\n   Orçamento: R$%.2f", projeto.orcamento);
    printf("\n   Gerente responsável: %s", projeto.gerente_resp);
    printf("\n   Nº de funcionários trabalhando no projeto: %d\n", projeto.num_funcionarios);
}

// Imprime os dados de todos os projetos cadastrados
int listar_projetos(ProjetosClass projetos)
{
    unsigned int c = 0;

    for (int i = 0; i < projetos.num_projetos; i++)
    {
        c += 1;
        imprimir_projeto(projetos.projetos[i], c);
    }
    return c;
}

// Recebe um parâmetro do tipo int e imprime todos os
// projetos cadastrados com status igual ao parâmetro
int listar_projetos_status(ProjetosClass projetos, unsigned int status)
{
    unsigned int c = 0;

    for (int i = 0; i < projetos.num_projetos; i++)
    {
        Projeto projeto = projetos.projetos[i];
        if (projeto.status == status)
        {
            c += 1;
            imprimir_projeto(projeto, c);
        }
    }
    return c;
}

// Recebe um parâmetro do tipo int e imprime todos os
// projetos cadastrados com ano igual ao parâmetro
int listar_projetos_ano(ProjetosClass projetos, int ano)
{
    unsigned int c = 0;

    for (int i = 0; i < projetos.num_projetos; i++)
    {
        Projeto projeto = projetos.projetos[i];
        if (projeto.data[2] == ano)
        {
            c += 1;
            imprimir_projeto(projeto, c);
        }
    }
    return c;
}

// Procedures
// Cabeçalho do programa
void cabecalho()
{
    printf("|-----------------------------------------|\n");
    printf("|                                         |\n");
    printf("|          SHM Gestão de Projetos         |\n");
    printf("|                                         |\n");
    printf("|      Sérgio H. Melges Carlos Pontes     |\n");
    printf("|                                         |\n");
    printf("|                      RA: 20128715-5     |\n");
    printf("|                                         |\n");
    printf("|-----------------------------------------|\n\n");
}

// Tela de cadastro de projetos
int cadastro_projetos(ProjetosClass *projetos)
{
    int errors = 0;
    char buffer[256];
    Projeto novo_projeto;

    while (true)
    {
        system("cls");
        printf("|-----------------------------------------|\n");
        printf("|          Cadastro de Projetos           |\n");
        printf("|.........................................|\n");

        printf(" Insira os dados do projeto.");

        printf("\n Título: ");
        fgets(buffer, sizeof buffer, stdin);
        strcopy(buffer, novo_projeto.titulo);

        printf(" Descrição: ");
        fgets(buffer, sizeof buffer, stdin);
        strcopy(buffer, novo_projeto.descricao);

        printf(" Data (Ex. 07/01/2021): ");
        fgets(buffer, sizeof buffer, stdin);
        int *date = get_date_array(buffer);

        if (!is_valid_date(date))
        {
            errors += 1;
            for (int i = 0; i < 3; i++)
                novo_projeto.data[i] = 0;
        }
        else
            for (int i = 0; i < 3; i++)
                novo_projeto.data[i] = date[i];

        printf(" Status (1. A Fazer; 2. Fazendo; 3. Concluído): ");
        fgets(buffer, sizeof buffer, stdin);

        if (!is_number(buffer) || !(0 < str2int(buffer, 10) <= 3))
            errors += 1;
        else
            novo_projeto.status = str2int(buffer, 10);

        printf(" Orçamento: ");
        fgets(buffer, sizeof buffer, stdin);

        if (!is_number(buffer) && (str2double(buffer) >= 0))
            errors += 1;
        else
            novo_projeto.orcamento = str2double(buffer);

        printf(" Gerente responsável: ");
        fgets(buffer, sizeof buffer, stdin);
        strcopy(buffer, novo_projeto.gerente_resp);

        printf(" Nº de funcionários trabalhando no projeto: ");
        fgets(buffer, sizeof buffer, stdin);

        if (!is_number(buffer) || !(0 < str2int(buffer, 10)))
            errors += 1;
        else
            novo_projeto.num_funcionarios = str2int(buffer, 10);

        novo_projeto.codigo = projetos->ultimo_codigo + 1;
        if (confirmar_cadastro(novo_projeto) == 0)
        {
            printf(" Operação cancelada.\n");
            errors = -1;
        }
        if (!errors)
        {
            if (projetos->num_projetos < max_projetos)
            {
                projetos->ultimo_codigo += 1;
                projetos->projetos[projetos->num_projetos] = novo_projeto;
                projetos->num_projetos += 1;

                printf(" Operação finalizada.\n");
            }
        }
        //getchar();
        break;
    }
    return errors;
}

// Menu de impressões
void menu_impressoes(ProjetosClass projetos)
{
    unsigned int op = 0;
    unsigned int ano;
    char buffer[256];

    do
    {
        system("cls");
        printf("|-----------------------------------------|\n");
        printf("|          Rotinas de Impressão           |\n");
        printf("|.........................................|\n");
        printf("|                                         |\n");
        printf("| Imprimir:                               |\n");
        printf("| 1. Todos os projetos                    |\n");
        printf("| 2. Projetos com o Status: A Fazer       |\n");
        printf("| 3. Projetos com o Status: Fazendo       |\n");
        printf("| 4. Projetos com o Status: Concluído     |\n");
        printf("| 5. Projeto de determinado ano           |\n");
        printf("|                                         |\n");
        printf("| 0. Voltar                               |\n");
        printf("|-----------------------------------------|\n");
        printf(" Escolha a função desejada: ");

        fgets(buffer, sizeof buffer, stdin);

        if (!is_valid_option(buffer))
            continue;

        sscanf(buffer, "%d", &op);
        switch (op)
        {
        case 0:
            printf("\n  Voltando ao menu principal.");
            continue;
            break;
        case 1:
            listar_projetos(projetos);
            break;

        case 2:
            if (!listar_projetos_status(projetos, 1))
                printf("\n Nenhum projeto encontrado.");
            break;

        case 3:
            if (!listar_projetos_status(projetos, 2))
                printf("\n Nenhum projeto encontrado.");
            break;

        case 4:
            if (!listar_projetos_status(projetos, 3))
                printf("\n Nenhum projeto encontrado.");
            break;

        case 5:
            printf("\n Digite o ano do projeto: ");
            fgets(buffer, sizeof buffer, stdin);
            if (is_valid_option(buffer))
            {
                if (str2int(buffer, 10) <= 0)
                    printf("\ ERRO: O ano deve ser maior que 0.");
                else if (!listar_projetos_ano(projetos, str2int(buffer, 10)))
                    printf("\n Nenhum projeto encontrado.");
            }
            break;

        default:
            printf(" ERRO: Opção inválida! Escolha uma das opções disponíveis,");
            break;
        }
        getchar();
    } while (op != 0);
}

// Menu principal
void menu_principal()
{
    ProjetosClass projetos;
    projetos.ultimo_codigo = 0;
    projetos.num_projetos = 0;

    int op = 0;
    char buffer[10];

    do
    {
        system("cls");
        cabecalho();

        printf("|-----------------------------------------|\n");
        printf("|             Menu Principal              |\n");
        printf("|.........................................|\n");
        printf("|                                         |\n");
        printf("| 1. Cadastrar novo projeto               |\n");
        printf("| 2. Imprimir projetos                    |\n");
        printf("|                                         |\n");
        printf("| 0. Sair                                 |\n");
        printf("|-----------------------------------------|\n");
        printf(" Escolha a opção desejada: ");

        fgets(buffer, sizeof buffer, stdin);

        if (!is_valid_option(buffer))
            continue;

        sscanf(buffer, "%d", &op);
        int result;
        switch (op)
        {
        case 0:
            printf(" Encerrando o programa.");
            break;
        case 1:
            if (projetos.num_projetos >= max_projetos)
            {
                printf("ERRO: Limite de projetos cadastrados atingido! Não foi possível finalizar a operação.");
                getchar();
                continue;
            }
            result = cadastro_projetos(&projetos);
            if (!result)
            {
                printf("\n Projeto cadastrado com sucesso.");
            }
            else if (result >= 1)
            {
                printf("\n O projeto não foi cadastrado.");
            }
            break;

        case 2:
            if (projetos.num_projetos == 0)
            {
                printf("\n Não existem projetos cadastrados!\n Cadastre um projeto para começar a utilizar o sistema.");
                getchar();
                continue;
            }
            menu_impressoes(projetos);
            continue;
            break;

        default:
            printf(" Opção inválida! Escolha uma das opções disponíveis,");
            break;
        }
        getchar();
    } while (op != 0);
}

// Função main
int main(void)
{
    setlocale(LC_ALL, "Portuguese");
    menu_principal();

    return 0;
}