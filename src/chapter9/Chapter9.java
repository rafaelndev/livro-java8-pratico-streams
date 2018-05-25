package chapter9;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import chapter2.Usuario;
import util.ListaUsuarios;

public class Chapter9 {
	public static void main(String[] args) {
		List<Usuario> usuarios = ListaUsuarios.get();
		
		System.out.println("\nAgrupar usuarios por pontos:");
		Map<Integer, List<Usuario>> pontuacao = usuarios
				.stream()
				.collect(Collectors.groupingBy(Usuario::getPontos));
		System.out.println(pontuacao);

		System.out.println("\nAgrupar usuarios por moderador:");
		Map<Boolean, List<Usuario>> moderadores = usuarios
				.stream()
				.collect(Collectors.partitioningBy(Usuario::isModerador));
		System.out.println(moderadores);

		System.out.println("\nAgrupar usuarios por moderador somente mostrando nome:");
		Map<Boolean, List<String>> moderadoresNome = usuarios
				.stream()
				.collect(Collectors.partitioningBy(
					Usuario::isModerador,
					Collectors.mapping(Usuario::getNome, Collectors.toList())
				));
		System.out.println(moderadoresNome);

		System.out.println("\nSome dos pontos dos usuarios agrupados por moderação");
		Map<Boolean, Integer> moderadoresPontuacao = usuarios
				.stream()
				.collect(Collectors.partitioningBy(
					Usuario::isModerador,
					Collectors.summingInt(Usuario::getPontos)
				));
		System.out.println(moderadoresPontuacao);
	}
}
