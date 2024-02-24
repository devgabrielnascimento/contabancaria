package conta;

import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;

public class Menu {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ContaController contas = new ContaController();
		
		int opcao;
		int numero;
		int agencia;
		int tipo = 2;
		String titular = "";
		float saldo = 0;
		int limite = 0;
		int resposta = 1 ;
		String menu = "********************************************************************************"
				+ "\n         SEJA BEM-VINDO, BEM-VINDA OU BEM-VINDE AO BANCO GENERATION!		"
					+"\n                                MENU:				    			   "
			        + "\n            		O que você deseja?                             "
			        + "\nDIGITE ALGUMA DAS OPÇÕES ABAIXO PARA PROSSEGUIR:       					   "
			        + "\n(1) Cadastrar \n(2) Atualizar Conta \n(3) Deletar Conta \n(4) Visualizar informações  "                                                       
			        + "\n********************************************************************************";
		
		
		do {
			System.out.println(menu);
			
			opcao = sc.nextInt();
			
			switch (opcao) {
			
			case 1 : 
				
				System.out.println("Digite o nome do titular: ");
				
				sc.next();
				titular = sc.nextLine();
				
				System.out.println("Digite o número da agência: ");
				
				agencia = sc.nextInt();
				
				
				contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				
				System.out.println("Deseja continuar?\nDigite 1 para continuar ou qualquer tecla para sair");
				resposta = sc.nextInt();
				
				break;
				
			
			
			
			case 2 : 
				
				System.out.println("Qual é o número da conta que você deseja excluir?");
				
				numero = sc.nextInt();
				
				contas.deletar(numero);
				
				System.out.println("Deseja continuar?\nDigite 1 para continuar ou qualquer tecla para sair");
				resposta = sc.nextInt();
				
				break;
				
				
			
			
			case 3: 
				
				sc.next();
				
				System.out.println("Vamos atualizar a sua conta! ");
				
				System.out.println("Qual o número da sua conta");
				
				numero = sc.nextInt();
				
				System.out.println("Digite o nome do titular: ");
				
				titular = sc.nextLine();
				
				System.out.println("Digite o número da agência: ");
				
				agencia = sc.nextInt();
				
				contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
				
				System.out.println("Deseja continuar?\nDigite 1 para continuar ou qualquer tecla para sair");
				resposta = sc.nextInt();
				
				break;
				
				
			case 4 : 
				System.out.println("Digite o número da sua conta para visualizar informações");
				numero = sc.nextInt();
				contas.procurarPorNumero(numero);
				contas.listarTodas();
				
				System.out.println("Deseja continuar?\nDigite 1 para continuar ou qualquer tecla para sair");
				resposta = sc.nextInt();
				
				break;
			
			
			
			default:
				System.out.println("Ludiaaaa");
				break;
			}
			
			
			
			
		} while (resposta == 1);
		
		System.out.println("Programa finalizado.");
		
			
		
		
		sc.close();
		
	}
}
