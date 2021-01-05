package entities;

public abstract class Contribuinte {

	private String nome;
	protected Double rendaAnual;

	public Contribuinte(String nome, Double rendaAnual) {
		this.nome = nome;
		this.rendaAnual = rendaAnual;
	}

	public String getNome() {
		return nome;
	}

	public abstract Double impostoDevido(); 

}
