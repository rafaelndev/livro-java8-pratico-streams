package chapter5;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import chapter2.Usuario;

public class Chapter5 {
    public static void main(String[] args) {
	Usuario user1 = new Usuario("Paulo Silveira", 150);
	Usuario user2 = new Usuario("Rodrigo Turini", 120);
	Usuario user3 = new Usuario("Guilherme Silveira", 190);

	List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

	usuarios.sort(Comparator.comparing(u -> u.getNome()));
	
	List<String> palavras = Arrays.asList("Cada do Código", "Alura", "Caelum");
	
	palavras.sort(Comparator.naturalOrder());
	
	// Ordenar por pontos
	usuarios.sort(Comparator.comparingInt(u -> u.getPontos()));
    }

}
