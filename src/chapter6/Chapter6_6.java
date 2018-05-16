package chapter6;

import java.util.function.BiFunction;
import java.util.function.Function;

import chapter2.Usuario;

public class Chapter6_6 {
    public static void main(String[] args) {
	// Referenciando construtores
	Function<String, Usuario> criadorDeUsuarios = Usuario::new;
	Usuario rodrigo = criadorDeUsuarios.apply("Rodrigo");
	Usuario paulo = criadorDeUsuarios.apply("Paulo");
	
	// Referenciando construtores com mais de um atributo no construtor
	
	BiFunction<String, Integer, Usuario> criadorDeUsuariosBi = Usuario::new;
	Usuario Birodrigo = criadorDeUsuariosBi.apply("Rodrigo", 50);
	Usuario Bipaulo = criadorDeUsuariosBi.apply("Paulo", 160);
    }

}
