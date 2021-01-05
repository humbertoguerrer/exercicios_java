package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Contribuinte;
import entities.pessoaFisica;
import entities.pessoaJuridica;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Contribuinte> list = new ArrayList<>();

		System.out.print("Digite a quantidade de contribuintes: ");
		int n = sc.nextInt();
		for (int j = 1; j <= n; j++) {
			System.out.println("DADOS DO CONTRIBUINTE #" + j);
			System.out.print("Pessoa Física ou pessoa jurífica (i/c): ");
			char ch = sc.next().charAt(0);
			System.out.print("Nome: ");
			String nome = sc.next();
			System.out.print("Renda anual: ");
			Double rendaAnual = sc.nextDouble();
			if (ch == 'i') {
				System.out.print("Despesas médicas: ");
				Double despesaSaude = sc.nextDouble();
				list.add(new pessoaFisica(nome, rendaAnual, despesaSaude));
			} else {
				System.out.print("Número de funcionários: ");
				Integer qtdFuncionarios = sc.nextInt();
				list.add(new pessoaJuridica(nome, rendaAnual, qtdFuncionarios));
			}
		}
		System.out.println("IMPOSTOS RECOLHIDOS");
		for (Contribuinte cont : list) {
			System.out.println(cont.getNome() + " : " + String.format("%.2f", cont.impostoDevido()));
		}
		Double soma = 0.0;
		for (Contribuinte cont : list) {
			soma += cont.impostoDevido();
		}
		System.out.printf("TOTAL DE IMPOSTO RECOLHIDO: %.2f" + soma);
		sc.close();
	}

}
