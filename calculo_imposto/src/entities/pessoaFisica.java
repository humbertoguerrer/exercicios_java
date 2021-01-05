package entities;

public class pessoaFisica extends Contribuinte {

	private Double despesaSaude;

	public pessoaFisica(String nome, Double rendaAnual, Double despesaSaude) {
		super(nome, rendaAnual);
		this.despesaSaude = despesaSaude;
	}

	@Override
	public Double impostoDevido() {
		Double x = 0.0;
		if (rendaAnual <= 20000.00) {
			x = rendaAnual * 0.15;
		} else if (rendaAnual > 20000.00) {
			x = rendaAnual * 0.25;
		}
		if (despesaSaude > 0) {
			x -= despesaSaude / 2;
		}
		return x;
	}

}
