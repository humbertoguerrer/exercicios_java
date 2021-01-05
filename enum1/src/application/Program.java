package application;

import java.util.Date;

import entities.Order;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {

		Order order = new Order(1080, new Date(), OrderStatus.PENDING_PAYMENT);

		System.out.println(order);

		OrderStatus os1 = OrderStatus.DELIVERED;

		OrderStatus os2 = OrderStatus
				.valueOf("DELIVERED"); /*
										 * o 'valueOf(argumento)' faz reconhece o que foi inserido como string e
										 * converte para enum, sendo que na hora de printar sai como enum
										 */

		System.out.println(os1);
		System.out.println(os2);
	}
}
