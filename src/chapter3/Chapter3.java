package chapter3;

public class Chapter3 {
    public static void main(String[] args) {
	Validator<String> validadorCEP = valor -> {
	    return valor.matches("[0-9]{5}-[0-9]{3}");
	};
	
	System.out.println(validadorCEP.valida("42820-000"));
    };
}
