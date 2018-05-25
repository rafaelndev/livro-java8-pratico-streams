package chapter10;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Chapter10 {
	public static void main(String[] args) {
		
		// Trabalhando com a nova API de Datas java.time
		
		System.out.println("\nReceber a data do mês que vem:");
		LocalDate mesQueVem = LocalDate.now().plusMonths(1);
		System.out.println(mesQueVem);

		System.out.println("\nReceber o horario de Hoje ao meio dia:");
		LocalDateTime hojeMeioDia = LocalDate.now().atTime(12,0);
		System.out.println(hojeMeioDia);

		System.out.println("\nModificar o ano de um LocalDate");
		LocalDate dataDoPassado = LocalDate.now().withYear(1988);
		System.out.println(dataDoPassado);
		
		// Comparação de Datas
		
		LocalDate hoje = LocalDate.now();
		LocalDate amanha = LocalDate.now().plusDays(1);

		System.out.println(hoje.isBefore(amanha)); //True
		System.out.println(hoje.isAfter(amanha)); //False
		System.out.println(hoje.isEqual(amanha)); //False
		
		// Formatação de Datas

		System.out.println("\nFormatar data:");
		LocalDateTime agora = LocalDateTime.now();
		String resultado = agora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println(resultado);
		
		System.out.println("\nPeriodo entre datas:");
		LocalDate dateAgora = LocalDate.now();
		LocalDate outraData = LocalDate.of(1989,  Month.JANUARY, 25);
		Period periodo = Period.between(outraData, dateAgora);
		System.out.printf("%s dias, %s meses e %s anos", periodo.getDays(), periodo.getMonths(), periodo.getYears());

	}
}
