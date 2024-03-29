package conta;

import java.util.Scanner;

import conta.model.Conta;



public class Menu {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Conta c1 = new Conta();
		
		System.out.println("Digite o número da conta: ");
		int numConta = sc.nextInt();
		c1.setNumero(numConta);
		System.out.println("Digite a agência: ");
		int numAgencia = sc.nextInt();
		c1.setAgencia(numAgencia);
		System.out.println("Digite o tipo: ");
		int tipoConta = sc.nextInt();
		c1.setTipo(tipoConta);
		System.out.println("Digite o titular: ");
		String nomeTitular = sc.next();
		c1.setTitular(nomeTitular);
		
		int digito = 3;
		
		String menu = "Olá, " + nomeTitular + "\nDigite a opção que você deseja:"
				+ "\n 1 - Para Sacar"
				+ "\n 2 - Para Depositar"
				+ "\n 0 - Para Sair";
		

		while(digito != 0) {
			System.out.println(menu);
			
			digito = sc.nextInt();
			
			switch (digito) {
			case 1: {
				
				int valorSaque;
				System.out.println("Qual valor você deseja sacar? ");
				valorSaque = sc.nextInt();
				if(c1.sacar(valorSaque)) {
					System.out.println("Saque efetuado com sucesso. Novo saldo é de: " + c1.getSaldo());
				}
				else { 
					System.out.println("O Saldo é insuficiente");
				}
				
				System.out.println("Digite 0 se quiser sair, ou qualquer número para continuar");
				digito = sc.nextInt();
				break;
			}

			case 2: {
				
				int valorDeposito;
				System.out.println("Qual valor você deseja depositar? ");
				valorDeposito = sc.nextInt();
				
				c1.depositar(valorDeposito);
				
				System.out.println("Valor depositado com sucesso!");
				
				System.out.println("Digite 0 se quiser sair, ou qualquer número para continuar");
				digito = sc.nextInt();
				
				break;

			}
			
			default: {
				System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
				break;
			}

			}

			
		}
		c1.visualizar();
		System.out.println("Programa finalizado.");
		sc.close();
	}
}
