package entities;

public class pessoaJuridica extends Contribuinte {

	private Integer qtdFuncionarios;

	public pessoaJuridica(String nome, Double rendaAnual, Integer qtdFuncionarios) {
		super(nome, rendaAnual);
		this.qtdFuncionarios = qtdFuncionarios;
	}

	@Override
	public Double impostoDevido() {
		Double x = 0.0;
		if (qtdFuncionarios > 10) {
			x = rendaAnual * 0.14;
		} else {
			x = rendaAnual * 0.16;
		}
		return x;
	}

}
