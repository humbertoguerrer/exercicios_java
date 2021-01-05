package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Product> list = new ArrayList<>(); // criou a lista

		System.out.println("Enter file path: ");
		String sourceFileStr = sc.nextLine(); // leu o path do caminho em forma de string

		File sourceFile = new File(sourceFileStr); /*
													 * instanciou uma variável file, do tipo file, como scanner e passou
													 * como argumento path do arquivo
													 */
		String sourceFolderStr = sourceFile
				.getParent(); /*
								 * através da indicação do path do arquivo na função acima, instanciou uma
								 * variável string e através dela recebeu a variável file como argumento e
								 * através dela se obtém vários métodos. O getParent busca somente o caminho
								 */

		boolean success = new File(sourceFolderStr + "\\out")
				.mkdir(); /*
							 * criou uma variável boolean e a instanciou como file, recebendo a string
							 * folder do arquivo fonte (sourve) e criando a pasta out
							 */

		String targetFileStr = sourceFolderStr
				+ "\\out\\summary.csv"; /*
										 * idem acima, iniciou uma variável string e atribuiu o valor da pasta do
										 * arquivo fonte e criou o novo arquivo .csv
										 */

		try (BufferedReader br = new BufferedReader(new FileReader(
				sourceFileStr))) { /* implementação do try with resources do file reader + buffered reader */

			String itemCsv = br.readLine(); // leu o arquivo itemcsv até o nulo
			while (itemCsv != null) {

				String[] fields = itemCsv.split(","); /*
														 * criou um array com as linhas do arquio fonte e separou cada
														 * item entre as virgulas
														 */

				String name = fields[0]; /*
											 * o array tem 3 posições, no campo de posição 0 atribuiu ao nome string ,
											 * no campo 1 converteu para double e no terceiro para integer
											 */
				double price = Double.parseDouble(fields[1]);
				int quantity = Integer.parseInt(fields[2]);

				list.add(new Product(name, price, quantity)); // adicionou os items a uma lista, já os instanciando

				itemCsv = br.readLine();
			}

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) { // instanciou o writer

				for (Product item : list) { /*
											 * percorreu a lista e para cara item escreveu e puxou como argumento do
											 * writer pelo get name e formatou o total pelo método da outra classse
											 */
					bw.write(item.getName() + "," + String.format("%.2f", item.total()));
					bw.newLine();
				}

				System.out.println(targetFileStr + " CREATED!");

			} catch (IOException e) {
				System.out.println("Error writing file: " + e.getMessage());
			}

		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}

		sc.close();
	}
}
