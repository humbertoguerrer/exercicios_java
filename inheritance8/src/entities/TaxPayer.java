package entities;

public abstract class TaxPayer {

	private String name;
	private Double anualIncome;

	public TaxPayer(String name, Double anualIncome) {
		this.name = name;
		this.anualIncome = anualIncome;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAnualIncome() {
		return anualIncome;
	}

	public void setAnualIncome(Double anualIncome) {
		this.anualIncome = anualIncome;
	}

	public abstract Double tax(); /*
									 * m�todo criado na classe gen�rica sem nenhuma fun��o, mas que pode ser
									 * acessado por outras subclasses e a fun��o espec�fica implementada diretamente
									 * nelas
									 */
}
