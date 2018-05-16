package chapter7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import chapter2.Usuario;
import util.ListaUsuarios;

public class Chapter7 {
    public static void main(String[] args) {

	List<Usuario> usuarios = ListaUsuarios.get();

	// Filtrar os 3 usuários com mais pontos e torná-los moderadores
	System.out.println("\nTornar os 3 usuários com mais pontos e torná-los moderadores:");
	List<Usuario> usuariosMaisPontos = new ArrayList<>(usuarios);
	usuariosMaisPontos.sort(Comparator.comparing(Usuario::getPontos).reversed());
	usuariosMaisPontos.subList(0, 3).forEach(Usuario::tornaModerador);

	usuariosMaisPontos.forEach(System.out::println);

	System.out.println("\nLista Usuários com mais de 100 pontos:");
	usuarios.stream()
    	    .filter(u -> u.getPontos() > 100)
    	    .forEach(System.out::println);

	System.out.println("\nLista de Usuários moderadores: ");
	usuarios.stream()
	    .filter(Usuario::isModerador)
	    .forEach(System.out::println);
	
	// Lista de usuarios com mais de 100 pontos
	List<Usuario> maisQue100 = usuarios.stream()
	    .filter(u -> u.getPontos() > 100)
	    .collect(Collectors.toList());
	
	// Lista de pontos em Integer
	List<Integer> pontos = usuarios.stream()
	    .map(Usuario::getPontos)
	    .collect(Collectors.toList());
	
	// Média de pontos dos usuários
	double pontuacaoMedia = usuarios.stream()
	    .mapToInt(Usuario::getPontos)
	    .average()
	    .orElse(0.0);
	System.out.println("\nMédia de pontos: " + pontuacaoMedia);
	
	Optional<String> maxNome = usuarios.stream()
	    .max(Comparator.comparingInt(Usuario::getPontos))
	    .map(u -> u.getNome());
	System.out.println("\nUsuário com mais pontos, usando Optional: ");
	System.out.println(maxNome.get());
	
	
    }

}
