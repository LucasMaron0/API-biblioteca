package compass.microservice.usuario.controller.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import compass.microservice.usuario.modelo.Endereco;
import compass.microservice.usuario.modelo.Estado;
import compass.microservice.usuario.modelo.Usuario;

public class CadastrarUsuarioForm {

	@NotBlank(message = "Insira o seu Nome")
	@Pattern(regexp = "^[A-Za-z ]*$", message = "Digite um nome válido (apenas letras)")
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

	public CadastrarUsuarioForm() {

	}

	public Usuario converter() {

		Usuario usuario = new Usuario(nome);
		Endereco end = new Endereco(usuario, estado, cidade, bairro, rua, numero);
		usuario.setEndereco(end);

		return usuario;
	}

	public Usuario atualizar(Usuario u) {

		u.setNome(this.nome);
		Endereco end = new Endereco(u, this.estado, this.cidade, this.bairro, this.rua, this.numero);
		u.setEndereco(end);

		return u;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
