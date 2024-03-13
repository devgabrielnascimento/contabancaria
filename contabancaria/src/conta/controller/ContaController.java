package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository{
		
	
		private ArrayList<Conta> listaContas = new ArrayList<Conta>();
		int numero = 0;
	
	
		
		 @Override
		    public void procurarPorNumero(int numero) {
		        Conta conta = buscarNaCollection(numero);
				
				if (conta != null)
					conta.visualizar();
				else
					System.out.println("\nA Conta número: " + numero + " não foi encontrada!");
		    }
		
		@Override
		public void listarTodas() {
			for (Conta conta : listaContas) {
				conta.visualizar();
			}
		};
		
		@Override
		public void cadastrar(Conta conta) {
			
			listaContas.add(conta);
			System.out.println("\n A Conta número " + conta.getNumero() + " foi criada com sucesso!");
			
		};
		
		@Override
		public void atualizar(Conta conta) {
			Conta buscarConta = buscarNaCollection(numero);
			
			if (buscarConta != null) {
				listaContas.set(listaContas.indexOf(conta), conta);
				System.out.println("\nA conta número: " + conta.getNumero() + " foi atualizada com sucesso");
		
			} else
				System.out.println("\n A conta número: " + conta.getNumero() + " não foi encontrada!");
	
		};
		
		@Override
		public void deletar(int numero) {
			Conta conta = buscarNaCollection(numero);
			
			if (conta != null) {
				if (listaContas.remove(conta) == true)
					System.out.println("\nA conta número " + numero + " foi deletada com sucesso!");
			} else
				
				System.out.println("\n A conta número " + numero + " não foi encontrada!");
			
		};
		
		
		
		
		// Métodos Bancários
		
		@Override
		public void sacar(int numero, float valor) {
			
			Conta conta = buscarNaCollection(numero);
			
			if (conta != null) {
				
				if(conta.sacar(valor) == true) 
					
					System.out.println("\nO Saque na Conta numero " + numero + " foi efetuado com suceso!");
			}
			
		};
		
		@Override
		public void depositar(int numero, float valor) {
			
			Conta conta = buscarNaCollection(numero);
			
			if (conta != null) {
				conta.depositar(valor);
				System.out.println("\nO Depósito na Conta número: " + numero + " foi efetuado com sucesso!");
			} else
				System.out.println("\nA Conta número: " + numero + " não foi encontrada ou a Conta destino não é uma Conta Corrente");
			
			
			
		};
		
		@Override
		public void transferir(int numeroOrigem, int numeroDestino, float valor) {
			
			var contaOrigem = buscarNaCollection(numeroOrigem);
			var contaDestino = buscarNaCollection(numeroDestino);
			
			if (contaOrigem != null && contaDestino != null)  {
				
				if (contaOrigem.sacar(valor) == true) {
					contaDestino.depositar(valor);
					System.out.println("\nA transferência foi efetuada com sucesso!");
					System.out.println("\nVocê realizou uma transferência no valor de" 
					+ valor 
					+ " para " + buscarNaCollection(numeroDestino).getTitular()
					+ "\n"
					+ "\nSeu saldo atual é de: " 
					+ buscarNaCollection(numeroOrigem).getSaldo());
				}
				
				else 
					System.out.println("\nA conta de origem e/ou destino não foram encontradas!");
			}
			
		};
		
		public int gerarNumero() {
			return ++ numero;
		}
		
		
		
		public Conta buscarNaCollection(int numero) {
			for (Conta conta : listaContas) {
				if (conta.getNumero() == numero) {
					return conta;
				}
			}
			
			return null;
		}

	}
