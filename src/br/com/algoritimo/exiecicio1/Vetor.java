package br.com.algoritimo.exiecicio1;

import java.util.Scanner;

public class Vetor {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String dadosPessoais[][] = new String[2][2];

		int op = 0;

		do {
			exibeMenu();
			op = entrada.nextInt();

			if (op < 1 || op > 2) {
				System.out.println("Opcao Invalida");
			} else if (op == 1) {
				cadastraAluno(dadosPessoais, entrada);
			} else if (op == 2) {
				listaAlunos(dadosPessoais);
			}
		} while (op != 3);

	}

	private static void exibeMenu() {
		System.out.println("============================");
		System.out.println("|      MENU DE OPCOES      |");
		System.out.println("============================");
		System.out.println("| Opcoes:                  |");
		System.out.println("|        1. Inserir Alunos |");
		System.out.println("|        2. Listar Alunos  |");
		System.out.println("|        3. Sair           |");
		System.out.println("============================");
	}

	private static void listaAlunos(String[][] dadosPessoais) {
		linha:
		for (int linha = 0; linha < 2; linha++) {
			for (int coluna = 0; coluna < 2; coluna++) {
				if(dadosPessoais[linha][coluna] != null){
					System.out.println("Contatos \n");
					if (coluna == 0) {
						System.out.println("Nome: " + dadosPessoais[linha][coluna]+ " ");
					} else {
						System.out.println("Numero da Matricula: "+ dadosPessoais[linha][coluna]);
					}
				}else{
					System.out.println("Nao existem Alunos cadastrados no momento! \n");
					break linha;
				}
			}
			System.out.println(" ");
		}
	}

	private static void cadastraAluno(String[][] dadosPessoais, Scanner entrada) {
		for (int linha = 0; linha < 2; linha++) {
			for (int coluna = 0; coluna < 2; coluna++) {
				if (coluna == 0) {
					System.out.println("Informa o nome: ");
				} else {
					System.out.println("Informe o numero da matricula");
				}
				dadosPessoais[linha][coluna] = entrada.next();
			}
		}
	}
}
