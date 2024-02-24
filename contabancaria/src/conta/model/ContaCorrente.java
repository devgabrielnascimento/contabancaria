package conta.model;

public class ContaCorrente extends Conta{
	
	private float limite;

	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;
	}
	
	

	public void visualizar() {
		super.visualizar();
		System.out.println("Limite de Crédito: " + this.limite);
	}
}
