package chapter11;

import java.math.BigDecimal;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		Customer paulo = new Customer("Paulo Silveira");
		Customer rodrigo = new Customer("Rodrigo Turini");
		Customer guilherme = new Customer("Guilherme Silveira");
		Customer adriano = new Customer("Adriano Almeida");

		Product bach = new Product("Bach Completo", Paths.get("/music/bach.mp3"), new BigDecimal(100));
		Product poderosas = new Product("Poderosas Anita", Paths.get("/music/poderosas.mp3"), new BigDecimal(90));
		Product bandeira = new Product("Bandeira Brasil", Paths.get("/images/brasil.jpg"), new BigDecimal(50));
		Product beauty = new Product("Beleza Americana", Paths.get("beauty.mov"), new BigDecimal(150));
		Product vingadores = new Product("Os Vingadores", Paths.get("/movies/vingadores.mov"), new BigDecimal(200));
		Product amelie = new Product("Amelie Poulain", Paths.get("/movies/amelie.mov"), new BigDecimal(100));

		LocalDateTime today = LocalDateTime.now();
		LocalDateTime yesterday = today.minusDays(1);
		LocalDateTime lastMonth = today.minusMonths(1);

		Payment payment1 = new Payment(Arrays.asList(bach, poderosas), today, paulo);
		Payment payment2 = new Payment(Arrays.asList(bach, bandeira, amelie), yesterday, rodrigo);
		Payment payment3 = new Payment(Arrays.asList(beauty, vingadores, bach), today, adriano);
		Payment payment4 = new Payment(Arrays.asList(bach, poderosas, amelie), lastMonth, guilherme);
		Payment payment5 = new Payment(Arrays.asList(beauty, amelie), yesterday, paulo);
		List<Payment> payments = Arrays.asList(payment1, payment2, payment3, payment4, payment5);
		
		System.out.println("Imprimir os pagamentos ordenados por data:");
		payments.stream()
			.sorted(Comparator.comparing(Payment::getDate))
			.forEach(System.out::println);
		
		System.out.println("\nImprimir o total de um pagamento (payment1):");
		payment1.getProducts().stream()
			.map(Product::getPrice)
			.reduce(BigDecimal::add)
			.ifPresent(System.out::println);
		
		System.out.println("\nImprimir o preço total de todos pagamentos:");
		BigDecimal totalFlat = payments.stream()
			.flatMap(p -> p.getProducts().stream().map(Product::getPrice))
			.reduce(BigDecimal.ZERO, BigDecimal::add);
		System.out.println(totalFlat);
		
		System.out.println("\nProdutos mais vendidos:");
		Map<Product, Long> topProducts = payments.stream()
			.flatMap(p -> p.getProducts().stream())
			.collect(Collectors.groupingBy(
					Function.identity(), Collectors.counting()
			));
		
		topProducts.entrySet().stream().forEach(System.out::println);
		
		System.out.println("\nProduto mais vendido:");
		topProducts.entrySet().stream()
			.max(Comparator.comparing(Map.Entry::getValue))
			.ifPresent(System.out::println);
		
		System.out.println("\nValores gerados por Produto:");
		Map<Product, BigDecimal> totalValuePerProduct = payments.stream()
			.flatMap(p -> p.getProducts().stream())
			.collect(Collectors.groupingBy(Function.identity(),
					Collectors.reducing(BigDecimal.ZERO, Product::getPrice, BigDecimal::add)
			));
		
		totalValuePerProduct.entrySet().stream()
		    .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
		    .forEach(System.out::println);
		
		System.out.println("\nProdutos de cada cliente:");
		Map<Customer, List<List<Product>>> customerToProductsList = 
			payments.stream()
			.collect(Collectors.groupingBy(Payment::getCustomer,
					Collectors.mapping(Payment::getProducts, Collectors.toList())
			));

		Map<Customer, List<Product>> customerToProducts2steps = 
			customerToProductsList.entrySet().stream()
			.collect(Collectors.toMap(Map.Entry::getKey,
				e -> e.getValue().stream()
					.flatMap(List::stream)
					.collect(Collectors.toList())
			));
		
		customerToProducts2steps.entrySet().stream()
			.sorted(Comparator.comparing(e -> e.getKey().getName()))
			.forEach(System.out::println);
		
		System.out.println("\nCliente mais especial:");
		Function<Payment, BigDecimal> paymentToTotal = p-> p.getProducts().stream()
			.map(Product::getPrice)
			.reduce(BigDecimal.ZERO, BigDecimal::add);

		Map<Customer, BigDecimal> totalValuePerCustomer = payments.stream()
			.collect(Collectors.groupingBy(Payment::getCustomer,
				Collectors.reducing(BigDecimal.ZERO,
					paymentToTotal,
				BigDecimal::add)
			));
		
		totalValuePerCustomer.entrySet().stream()
			.sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
			.forEach(System.out::println);
		
		System.out.println("\nAgrupar por datas, ano e mês:");
		Map<YearMonth, List<Payment>> paymentsPerMonth = payments.stream()
			.collect(Collectors.groupingBy(p -> YearMonth.from(p.getDate())));
		
		paymentsPerMonth.entrySet().stream()
			.forEach(System.out::println);
		
		System.out.println("\nAgrupar pagamentos por Mês com seu valor:");
		Map<YearMonth, BigDecimal> paymentsValuePerMonth = payments.stream()
			.collect(Collectors.groupingBy(p -> YearMonth.from(p.getDate()),
				Collectors.reducing(BigDecimal.ZERO,
					p -> p.getProducts().stream()
						.map(Product::getPrice)
						.reduce(BigDecimal.ZERO,
							BigDecimal::add),
					BigDecimal::add)));

		paymentsValuePerMonth.entrySet().stream()
			.forEach(System.out::println);
	}
}
