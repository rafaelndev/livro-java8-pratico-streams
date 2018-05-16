package chapter6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import chapter2.Usuario;

public class Chapter6 {
    public static void main(String[] args) {
	Usuario user1 = new Usuario("Paulo Silveira", 150);
	Usuario user2 = new Usuario("Rodrigo Turini", 120);
	Usuario user3 = new Usuario("Guilherme Silveira", 190);

	List<Usuario> usuarios = Arrays.asList(user1, user2, user3);
	
	// Method reference
	// Transformando todos usuarios em moderadores
	
	usuarios.forEach(Usuario::tornaModerador);
	
	// Ordenando por nome usando method reference
	System.out.println("Ordenados por nome:");
	usuarios.sort(Comparator.comparing(Usuario::getNome));
	usuarios.forEach(System.out::println);

	System.out.println("\nOrdenados por pontos:");
	usuarios.sort(Comparator.comparingInt(Usuario::getPontos));
	usuarios.forEach(System.out::println);

	System.out.println("\nOrdenados por pontos e desempate por nomes:");
	usuarios.sort(Comparator.comparingInt(Usuario::getPontos)
		.thenComparing(Usuario::getNome)
	);
	usuarios.forEach(System.out::println);

	System.out.println("\nOrdenados por pontos ordem decrescente:");
	usuarios.sort(Comparator.comparingInt(Usuario::getPontos).reversed());
	usuarios.forEach(System.out::println);
    }
}
