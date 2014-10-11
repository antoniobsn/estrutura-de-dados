package br.com.algoritimo.exiecicio1;

import java.util.Scanner;

public class ListaCircular {

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
			exibirMenu();			
			op = entrada.nextInt();

			if (op < 1 || op > 6) {
				System.out.println("Opcao invalida!!");
			} else {
				if (op == 1)
					inseriInicioLista(entrada);
				if (op == 2)
					inserFinalLista(entrada);
				if (op == 3)
					consultaTodaLista();
				if (op == 4)
					removerDaLista(entrada);
				if (op == 5)
					esvaziarLista();
			}
		} while (op != 6);
	}

	private static void esvaziarLista() {
		if (inicio == null) {
			System.out.println("Lista vazia!!");
		} else {
			inicio = null;
			System.out.println("Lista esvaziada");
		}
	}

	private static void removerDaLista(Scanner entrada) {
		LISTA aux;
		LISTA anterior;
		int numero;
		int achou;
		if (inicio == null) {
			System.out.println("Lista vazia!!");
		} else {
			System.out.print("\nDigite a Idade do Aluno a ser removido: ");
			numero = entrada.nextInt();
			anterior = null;
			achou = 0;
			int quantidade = 0;
			aux = inicio;
			do {
				quantidade = quantidade + 1;
				aux = aux.prox;
			} while (aux != inicio);
			int elemento = 1;
			do {
				if (inicio == fim && inicio.num == numero) {
					inicio = null;
					achou = achou + 1;
				} else {
					if (aux.num == numero) {
						achou = achou + 1;
						if (aux == inicio) {
							inicio = aux.prox;
							fim.prox = inicio;
							aux = inicio;
						} else if (aux == fim) {
							fim = anterior;
							fim.prox = inicio;
							aux = aux.prox;
						} else {
							anterior.prox = aux.prox;
							aux = aux.prox;
						}
					} else {
						anterior = aux;
						aux = aux.prox;
					}
					elemento = elemento + 1;
				}
			} while (elemento <= quantidade);
			if (achou == 0) {
				System.out.println("Idade do Aluno nao encontrado");
			} else if (achou == 1) {
				System.out.println("Idade do Aluno removido 1 vez");
			} else {
				System.out.println("Idade do Aluno removido " + achou+ " vezes");
			}
		}
	}

	private static void consultaTodaLista() {
		LISTA aux;
		if (inicio == null) {
			System.out.println("Lista vazia!!");
		} else {
			System.out.println("\nConsultando toda a lista\n");
			aux = inicio;
			do {
				System.out.print(aux.num + " ");
				aux = aux.prox;
			} while (aux != inicio);
		}
	}

	private static void inserFinalLista(Scanner entrada) {
		System.out.println("Digite a Idade do Aluno a ser inserida no fim da lista: ");
		LISTA novo = new LISTA();
		novo.num = entrada.nextInt();
		if (inicio == null) {
			inicio = novo;
			fim = novo;
			fim.prox = inicio;
		} else {
			fim.prox = novo;
			fim = novo;
			fim.prox = inicio;
		}
		System.out.println("Idade do Aluno inserida no fim da lista!!");
	}

	private static void inseriInicioLista(Scanner entrada) {
		System.out.println("Digite a Idade do Aluno a ser inserido no inicio da lista");
		LISTA novo = new LISTA();
		novo.num = entrada.nextInt();
		if (inicio == null) {
			inicio = novo;
			fim = inicio;
			fim.prox = inicio;
		} else {
			novo.prox = inicio;
			inicio = novo;
			fim.prox = inicio;
		}
		System.out.println("Idade do Aluno inserido no inicio da lista!!");
	}

	private static void exibirMenu() {
		System.out.println("");
		System.out.println("=========================================");
		System.out.println("|             MENU DE OPCOES            |");
		System.out.println("=========================================");
		System.out.println("| Opcoes:                               |");
		System.out.println("|1 - Inserir no inicio da lista         |");
		System.out.println("|2 - Inserir no fim da lista            |");
		System.out.println("|3 - Remover da lista                   |");
		System.out.println("|5 - Esvaziar a lista                   |");
		System.out.println("|6 - Sair                               |");
		System.out.println("=========================================");
	}
}
