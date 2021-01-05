package entities;

public class Company extends TaxPayer {

	private Integer numberOfEmployees;

	public Company(String name, Double anualIncome, Integer numberOfEmployees) {
		super(name, anualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}

	public Integer getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(Integer numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public Double tax() { // método sobrescrito da superclasse com implementação de função específica
		if (numberOfEmployees > 10) {
			return getAnualIncome() * 0.14;
		} else {
			return getAnualIncome() * 0.16;
		}
	}
}
