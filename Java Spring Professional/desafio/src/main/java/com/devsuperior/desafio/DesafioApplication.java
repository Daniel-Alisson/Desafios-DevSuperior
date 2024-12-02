package com.devsuperior.desafio;

import com.devsuperior.models.Order;
import com.devsuperior.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Scanner;

@SpringBootApplication
@ComponentScan({"com.devsuperior"})
public class DesafioApplication implements CommandLineRunner {
	Scanner sc = new Scanner(System.in);

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Order order = new Order();

		System.out.println("\t\tDADOS DO PEDIDO");
		System.out.print("Código: ");
		order.setCode(sc.nextInt());
		sc.nextLine();
		System.out.print("Valor Básico: ");
		order.setBasic(sc.nextDouble());
		sc.nextLine();
		System.out.print("Porcentagem de desconto: ");
		order.setDiscount(sc.nextDouble());
		sc.nextLine();

		//System.out.println(order.getCode());
		//System.out.println(order.getBasic());
		//System.out.println(order.getDiscount());

		System.out.println("Pedido código: " + order.getCode());
		System.out.println("Valor total: R$ " + orderService.total(order));
		sc.close();
	}
}
