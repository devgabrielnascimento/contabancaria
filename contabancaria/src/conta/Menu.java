package conta;

import java.util.Scanner;

import conta.model.Conta;



public class Menu {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Conta c1 = new Conta();

		System.out.println("Digite um saldo: ");

		c1.setSaldo(sc.nextInt());


		System.out.println(c1.getSaldo());



		sc.close();


	}

}
