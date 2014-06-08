public class WebAdmin {
	private String nome;
	private String password;

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean autentifica() {
		throw new UnsupportedOperationException();
	}
}