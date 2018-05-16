package chapter2;

public class Usuario {
    private String nome;
    private int pontos;
    private boolean moderador;
    
    public Usuario(String nome) {
	this.nome = nome;
    }
    
    public Usuario(String nome, int pontos) {
	this.pontos = pontos;
	this.nome = nome;
	this.moderador = false;
    }
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }
    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * @return the pontos
     */
    public int getPontos() {
        return pontos;
    }
    /**
     * @param pontos the pontos to set
     */
    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
    /**
     * @return the moderador
     */
    public boolean isModerador() {
        return moderador;
    }
    /**
     * @param moderador the moderador to set
     */
    public void setModerador(boolean moderador) {
        this.moderador = moderador;
    }
    
    public void tornaModerador() {
	this.moderador = true;
    }
    
    @Override
    public String toString() {
        return "Usuario: " + nome + " - Pontos: " + pontos + " - Moderador: " + moderador;
    }

}
