package br.com.alura.reflection;

public class Usuario {
	private String login;
	private String senha;
	private String email;
	private String papel;
	private boolean ativo;
	
	public Usuario(String login, String senha, String email, String papel, boolean ativo) {
		this.login = login;
		this.senha = senha;
		this.email = email;
		this.papel = papel;
		this.ativo = ativo;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPapel() {
		return papel;
	}
	public void setPapel(String papel) {
		this.papel = papel;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public boolean validarEmail(){
		return email.contains("@");
	}
	
	public boolean validarSenha(){
		return senha.length() > 8;
	}
}
