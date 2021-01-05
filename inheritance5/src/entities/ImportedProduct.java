package entities;

public class ImportedProduct extends Product { // essa classe extende a superclasse 'Product'

	private Double customsFee;

	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price); // indica que esses atributos estão definidos na superclasse
		this.customsFee = customsFee;
	}

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}

	public Double totalPrice() {
		return getPrice() + customsFee;
	}

	@Override // indica que o método pertence à superclasse e esta classe esta sobrescrevendo
	public String priceTag() {
		return getName() + " $ " + String.format("%.2f", totalPrice()) + " (Customs fee: $ "
				+ String.format("%.2f", customsFee) + ")";
	}
}
