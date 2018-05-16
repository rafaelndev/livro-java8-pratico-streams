package chapter8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import chapter2.Usuario;
import util.ListaUsuarios;

public class Chapter8 {
    public static void main(String[] args) {
	List<Usuario> usuarios = ListaUsuarios.get();
	
	System.out.println("\nFiltro de usuarios com mais de 100 pontos ordenados por nome:");
	usuarios.stream()
	    .filter(u -> u.getPontos() > 100) // Lazy
	    .sorted(Comparator.comparing(Usuario::getNome)) // Lazy
	    .forEach(System.out::println); // Operação Terminal

	System.out.println("\nReceber qualquer usuário:");
	Optional<Usuario> usuarioOptional = usuarios.stream()
	    .filter(u -> u.getPontos() > 100) // Lazy
	    .findAny(); // Operação Terminal
	
	System.out.println(usuarioOptional.get());
	
	// Operadores de redução
	// average, count, min, max, sum
	
	System.out.println("\nTotal da soma de pontos: ");
	int total = usuarios.stream()
	    .mapToInt(Usuario::getPontos) // Lazy
	    .sum(); //OPERAÇÂO TERMINAL
	System.out.println(total);
	
	// Filtrar uma lista por outra
	Usuario u1 = new Usuario("Rafael Nascimento", 110);
	Usuario u2 = new Usuario("Sara Morena", 150);
	
	List<Usuario> usuariosParaFiltrar = Arrays.asList(u1, u2);
	
	List<Usuario> usuariosFiltrados = usuarios.stream()
	    .filter(u -> {
		return usuariosParaFiltrar.stream()
		    .noneMatch(uf -> uf.getNome().equals(u.getNome()));
	    })
	    .collect(Collectors.toList());
	
	usuariosFiltrados.forEach(System.out::println);
	    

    }

}
