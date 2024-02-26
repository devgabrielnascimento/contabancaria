package conta;

import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ContaController contas = new ContaController();

		int opcao, numero, agencia, tipo = 2, aniversario, numeroOrigem, numeroDestino;
		String titular, resposta = "1";
		float saldo, limite, valor;
		String menu = "********************************************************************************"
				+ "\n         SEJA BEM-VINDO, BEM-VINDA OU BEM-VINDE AO BANCO GENERATION!		"
				+ "\n                                MENU:				    			   "
				+ "\n            		O que você deseja?                             "
				+ "\nDIGITE ALGUMA DAS OPÇÕES ABAIXO PARA PROSSEGUIR:       					   "
				+ "\n(1) Cadastrar \n(2) Deletar Conta  \n(3) Atualizar Conta \n(4) Visualizar informações \n(5) Sacar \n(6) Depositar  \n(7) Transferir ou \n(8) Para sair "
				+ "\n********************************************************************************";

		while (resposta.equals("1")) {
			System.out.println(Cores.TEXT_YELLOW_BRIGHT + menu);

			opcao = sc.nextInt();

			switch (opcao) {

			case 1:

				System.out.println("Digite o nome do titular: ");
				sc.nextLine();
				titular = sc.nextLine();

				System.out.println("Digite o número da agência: ");

				agencia = sc.nextInt();

				do {
					System.out.println("Digite o Tipo da Conta (1) Conta Corrente ou (2) Conta Poupança): ");
					tipo = sc.nextInt();
				} while (tipo < 1 && tipo > 2);

				System.out.println("Digite o saldo: ");
				saldo = sc.nextFloat();

				if (tipo == 1) {
					System.out.println("Digite o limite: ");
					limite = sc.nextFloat();
					sc.nextLine();

					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				} else if (tipo == 2) {
					System.out.println("Digite o dia do aniversário da conta: ");
					aniversario = sc.nextInt();
					sc.nextLine();

					contas.cadastrar(
							new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				} else
					System.out.println("Conta invalida!");

				System.out.println("Deseja continuar?\nDigite 1 para continuar ou qualquer tecla para sair");
				resposta = sc.nextLine();
				break;

			case 2:

				System.out.println("Qual é o número da conta que você deseja excluir?");

				numero = sc.nextInt();
				sc.nextLine();
				contas.deletar(numero);

				System.out.println("Deseja continuar?\nDigite 1 para continuar ou qualquer tecla para sair");
				resposta = sc.nextLine();
				break;

			case 3:

				System.out.println("Qual o número da sua conta");
				numero = sc.nextInt();

				var buscaConta = contas.buscarNaCollection(numero);

				if (buscaConta != null) {

					System.out.println("Digite o nome do titular: ");

					sc.nextLine();
					titular = sc.nextLine();

					System.out.println("Digite o número da agência: ");

					agencia = sc.nextInt();

					System.out.println("Digite o saldo: ");

					saldo = sc.nextFloat();

					tipo = buscaConta.getTipo();

					if (tipo == 1) {
						System.out.println("Digite o limite: ");
						limite = sc.nextFloat();
						sc.nextLine();

						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
					} else if (tipo == 2) {
						System.out.println("Digite o dia do aniversário da conta: ");
						aniversario = sc.nextInt();
						sc.nextLine();

						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
					}

					else
						System.out.println("Conta invalida!");

				}

				System.out.println("Deseja continuar?\nDigite 1 para continuar ou qualquer tecla para sair");
				resposta = sc.nextLine();
				break;

			case 4:
				System.out.println("Digite o número da sua conta para visualizar informações");
				numero = sc.nextInt();
				sc.nextLine();

				contas.procurarPorNumero(numero);

				System.out.println("Deseja continuar?\nDigite 1 para continuar ou qualquer tecla para sair");
				resposta = sc.nextLine();
				break;

			case 5:
				System.out.println("Saque: ");

				System.out.println("Digite o Numero da conta: ");
				numero = sc.nextInt();

				do {
					System.out.println("Digite o Valor do Saque (R$): ");
					valor = sc.nextFloat();
				} while (valor <= 0);

				contas.sacar(numero, valor);

				break;
			case 6:
				System.out.println("Depósito: ");

				System.out.println("Digite o Numero da conta: ");
				numero = sc.nextInt();

				do {
					System.out.println("Digite o Valor do Depósito (R$): ");
					valor = sc.nextFloat();
				} while (valor <= 0);

				contas.depositar(numero, valor);

				break;
			case 7:
				System.out.println("Transferência entre Contas: ");

				System.out.println("Digite o Numero da Conta de Origem: ");
				
				numeroOrigem = sc.nextInt();
				
				System.out.println("Digite o Numero da Conta de Destino: ");
				
				numeroDestino = sc.nextInt();

				do {
					System.out.println("Digite o Valor da Transferência: ");
					valor = sc.nextFloat();
				} while (valor <= 0);

				contas.transferir(numeroOrigem, numeroDestino, valor);
				break;

			case 8:
				
				System.out.println("Todas as contas criadas nesse sistema: ");
				contas.listarTodas();
				System.out.println("Programa finalizado! ");
				System.exit(0);
				sc.close();

				break;

			}

		}

		

	}

}
