package br.com.algoritimo.exercicio2;

import java.util.Scanner;

public class Algoritimo3 {
	
	private static Lista inicio;
	private static Lista fim;

	private static class Lista {
		public int num;
		public Lista prox;
		public Lista ant;
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		inicio = null;
		fim = null;

		Lista aux;
		Lista anterior;
		
		int op, numero, achou;

		do {
			exibeMenu();

			op = entrada.nextInt();

			if (op < 1 || op > 7) {
				System.out.println("Opcao invalida!!");
			} else {
				if (op == 1)
					inserInicioLista(entrada);
				if (op == 2)
					insereFimLista(entrada);
				if (op == 3)
					consultaListaIncioFim();
				if (op == 4)
					consultaListaFimInicio();
				if (op == 5)
					removeDaLista(entrada);
				if (op == 6)
					EsvaziarLista();
			}
		} while (op != 7);
	}

	private static void EsvaziarLista() {
		if (inicio == null) {
			System.out.println("Lista vazia!!");
		} else {
			inicio = null;
			System.out.println("Lista esvaziada");
		}
	}

	private static void removeDaLista(Scanner entrada) {
		Lista aux;
		int numero;
		int achou;
		if (inicio == null) {
			System.out.println("Lista vazia!!");
		} else {
			System.out.print("\nDigite o Nome da Marca a ser removido: ");
			numero = entrada.nextInt();
			aux = inicio;
			achou = 0;
			while (aux != null) {
				if (aux.num == numero) {
					achou = achou + 1;
					if (aux == inicio) {
						inicio = aux.prox;
						if (inicio != null) {
							inicio.ant = null;
						}
						aux = inicio;
					} else if (aux == fim) {
						fim = fim.ant;
						fim.prox = null;
						aux = null;
					} else {
						aux.ant.prox = aux.prox;
						aux.prox.ant = aux.ant;
						aux = aux.prox;
					}
				} else {
					aux = aux.prox;
				}
			}
			if (achou == 0) {
				System.out.println("Nome da Marca nao encontrado");
			} else if (achou == 1) {
				System.out.println("Nome da Marca removida 1 vez");
			} else {
				System.out.println("Nome da Marca removida " + achou + " vezes");
			}
		}
	}

	private static void consultaListaFimInicio() {
		Lista aux;
		if (inicio == null) {
			System.out.println("Lista vazia!!");
		} else {
			System.out.println("\nConsultando a lista do fim ao inicio\n");

			aux = fim;
			while (aux != null) {
				System.out.print(aux.num + " ");
				aux = aux.ant;
			}
		}
	}

	private static void consultaListaIncioFim() {
		Lista aux;
		if (inicio == null) {
			System.out.println("Lista vazia!!");

		} else {
			System.out.println("\nConsultando a lista do inicio ao fim\n");

			aux = inicio;
			while (aux != null) {
				System.out.print(aux.num + " ");
				aux = aux.prox;
			}
		}
	}

	private static void insereFimLista(Scanner entrada) {
		System.out.println("Digite o Nome da Marca a ser inserido no fim da lista: ");
		Lista novo = new Lista();
		novo.num = entrada.nextInt();
		if (inicio == null) {
			inicio = novo;

			fim = novo;
			novo.prox = null;
			novo.ant = null;
		} else {
			fim.prox = novo;

			novo.ant = fim;
			novo.prox = null;
			fim = novo;
		}

		System.out.println("Nome da Marca no fim da lista!!");
	}

	private static void inserInicioLista(Scanner entrada) {
		System.out.println("Digite o Nome da Marca a ser inserido no inicio da lista");

		Lista novo = new Lista();
		novo.num = entrada.nextInt();

		if (inicio == null) {
			inicio = novo;

			fim = novo;
			novo.prox = null;
			novo.ant = null;
		} else {
			novo.prox = inicio;

			inicio.ant = novo;
			novo.ant = null;
			inicio = novo;
		}
		System.out.println("Nome da Marca inserido no inicio da lista!!");
	}

	private static void exibeMenu() {
		System.out.println("");
		System.out.println("=========================================");
		System.out.println("|             MENU DE OPCOES            |");
		System.out.println("=========================================");
		System.out.println("| Opcoes:                               |");
		System.out.println("|1 - Inserir no inicio da lista         |");
		System.out.println("|2 - Inserir no fim da lista            |");
		System.out.println("|3 - Consultar a lista do inicio ao fim |");
		System.out.println("|4 - Consultar a lista do fim ao inicio |");
		System.out.println("|5 - Remover da lista                   |");
		System.out.println("|6 - Esvaziar a lista                   |");
		System.out.println("|7 - Sair                               |");
		System.out.println("=========================================");
	}
}
