package chapter3;

@FunctionalInterface
public interface Validator<T> {
    boolean valida(T t);
}
