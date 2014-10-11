package br.com.algoritimo.exercicio2;

import java.util.Scanner;

public class Algoritimo2 {

    private static LISTA inicio;
	private static LISTA fim;

	private static class LISTA {
        public int num;
        public LISTA prox;
    }
    
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        inicio = null;
        fim = null;
        
        LISTA aux;
        LISTA anterior;

        int op, numero, achou;

        do {
    		exibeMenu();
    		
            op = entrada.nextInt();

            if (op < 1 || op > 6) {
                System.out.println("Opcao invalida!!");
            } else {
                if (op == 1)
                    insereInicioLista(entrada);
                if (op == 2)
                    insereFinalLista(entrada);
                if (op == 3)
                    consultaLista();
                if (op == 4)
                    removeDaLista(entrada);
                if (op == 5)
                    esvaziaLista();
            }
        } while (op != 6);
    }

	private static void esvaziaLista() {
		if (inicio == null) {
		    System.out.println("Lista vazia!!");
		} else {
		    inicio = null;
		    System.out.println("Lista esvaziada");
		}
	}

	private static void removeDaLista(Scanner entrada) {
		LISTA aux;
		LISTA anterior;
		int numero;
		int achou;
		if (inicio == null) {
		    System.out.println("Lista vazia!!");
		} else {
		    System.out.print("\nDigite o Nº de Matricula a ser removido: ");
		    numero = entrada.nextInt();
		    aux = inicio;
		    anterior = null;
		    achou = 0;
		    while (aux != null) {
		        if (aux.num == numero) {

		            achou = achou + 1;
		            if (aux == inicio) {
		                inicio = aux.prox;
		                aux = inicio;
		            } else if (aux == fim) {
		                anterior.prox = null;
		                fim = anterior;
		                aux = null;
		            } else {
		                anterior.prox = aux.prox;
		                aux = aux.prox;
		            }
		        } else {
		            anterior = aux;
		            aux = aux.prox;
		        }
		    }
		    if (achou == 0) {
		        System.out.println("Nº de Matricula nao encontrado");
		    } else if (achou == 1) {
		        System.out.println("Nº de Matricula removido 1 vez");
		    } else {
		        System.out.println("Nº de Matricula removido " + achou + " vezes");
		    }
		}
	}

	private static void consultaLista() {
		LISTA aux;
		if (inicio == null) {
		    System.out.println("Lista vazia!!");
		} else {
		    System.out.println("\nConsultando toda a lista\n");
		    aux = inicio;
		    while (aux != null) {
		        System.out.print(aux.num + " ");
		        aux = aux.prox;
		    }
		}
	}

	private static void insereFinalLista(Scanner entrada) {
		System.out.println("Digite o Nº de Matricula a ser inserido no fim da lista: ");
		LISTA novo = new LISTA();
		novo.num = entrada.nextInt();
		if (inicio == null) {
		    inicio = novo;
		    fim = novo;
		    novo.prox = null;
		} else {
		    fim.prox = novo;
		    fim = novo;
		    fim.prox = null;
		}
		System.out.println("Nº de Matricula inserido no fim da lista!!");
	}

	private static void insereInicioLista(Scanner entrada) {
		System.out.println("Digite o Nº de Matricula a ser inserido no inicio da lista");
		LISTA novo = new LISTA();
		novo.num = entrada.nextInt();
		if (inicio == null) {
		    inicio = novo;
		    fim = inicio;
		    novo.prox = null;
		} else {
		    novo.prox = inicio;
		    inicio = novo;
		}
		System.out.println("Nº de Matricula inserido no inicio da lista!!");
	}

	private static void exibeMenu() {
		System.out.println("");
		System.out.println("=========================================");
		System.out.println("|             MENU DE OPCOES            |");
		System.out.println("=========================================");
		System.out.println("| Opcoes:                               |");
		System.out.println("|1 - Inserir no inicio da lista         |");
		System.out.println("|2 - Inserir no fim da lista            |");
		System.out.println("|3 - Consultar toda a lista             |");
		System.out.println("|5 - Remover da lista                   |");
		System.out.println("|6 - Esvaziar a lista                   |");
		System.out.println("|7 - Sair                               |");
		System.out.println("=========================================");
	}
}
