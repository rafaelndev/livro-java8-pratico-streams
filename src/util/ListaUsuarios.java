package util;

import java.util.Arrays;
import java.util.List;

import chapter2.Usuario;

public class ListaUsuarios {
    public static List<Usuario> get() {
	
	Usuario user1 = new Usuario("Paulo Silveira", 150, true);
	Usuario user2 = new Usuario("Rodrigo Turini", 120);
	Usuario user3 = new Usuario("Guilherme Silveira", 190, true);
	Usuario user4 = new Usuario("Rafael Nascimento", 290, true);
	Usuario user5 = new Usuario("João Pereira", 50);
	Usuario user6 = new Usuario("Sara Morena", 175);

	return Arrays.asList(user1, user2, user3, user4, user5, user6);
    }
}
