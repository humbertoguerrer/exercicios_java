package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.WithdrawException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			Integer number = sc.nextInt();
			System.out.print("Holder: ");
			String holder = sc.next();
			System.out.print("Initial balance: ");
			Double amount = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			Double withDrawLimit = sc.nextDouble();
			Account acc = new Account(number, holder, amount, withDrawLimit);

			System.out.print("Enter amount for withdraw: ");
			amount = sc.nextDouble();
			acc.withDraw(amount);
			System.out.printf("New balance: %.2f", acc.getBalance());

		} catch (WithdrawException e) {
			System.out.println("Withdraw error: " + e.getMessage());

		}

		sc.close();
	}

}
