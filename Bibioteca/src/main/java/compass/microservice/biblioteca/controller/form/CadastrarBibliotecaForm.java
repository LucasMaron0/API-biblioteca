package compass.microservice.biblioteca.controller.form;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import compass.microservice.biblioteca.modelos.Biblioteca;
import compass.microservice.biblioteca.modelos.Endereco;
import compass.microservice.biblioteca.modelos.Estado;

public class CadastrarBibliotecaForm {

	@NotBlank(message = "Inserir o nome da Biblioteca")
	private String nome;

	@NotNull(message = "Escolher um Estado válido")
	private Estado estado;

	@NotBlank(message = "Inserir o nome da Cidade")
	private String cidade;

	@NotBlank(message = "Inserir o nome do Bairro")
	private String bairro;

	@NotBlank(message = "Inserir o nome da Rua")
	private String rua;

	@Min(0)
	@NotNull(message = "Inserir o número")
	private int numero;

	public CadastrarBibliotecaForm() {

	}

	public Biblioteca converter() {

		Biblioteca biblioteca = new Biblioteca(nome);
		Endereco end = new Endereco(biblioteca, rua, numero, bairro, cidade, estado);
		biblioteca.setEndereco(end);

		return biblioteca;
	}

	public Biblioteca atualizar(Biblioteca b) {

		b.setNome(this.nome);
		Endereco end = new Endereco(b, this.rua, this.numero, this.bairro, this.cidade, this.estado);
		b.setEndereco(end);

		return b;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
