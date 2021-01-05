package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); /* definiu como será feita a formatação de datas */

		List<Product> list = new ArrayList<>(); /*
												 * criou uma lista de tipo 'ArrayList' de nome 'list' contendo objetos
												 * do tipo 'Product'
												 */

		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char type = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			if (type == 'c') {
				list.add(new Product(name, price));
			} else if (type == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date date = sdf.parse(sc.next()); /*
													 * foi criada uma variável date do tipo Date, que foi lida pelo que
													 * o usuário digitou, o formato foi convertido para date através do
													 * parse e o formato da conversão se deu através do sdf
													 */
				list.add(new UsedProduct(name, price,
						date)); /* intanciou uma variável já a adicionando na lista criada */
			} else {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			}
		}

		System.out.println();
		System.out.println("PRICE TAGS:");
		for (Product prod : list) { // percorreu lista de nome 'list' contendo objetos 'prod' do tipo 'Product'
			System.out.println(prod.priceTag());
		}

		sc.close();
	}
}
