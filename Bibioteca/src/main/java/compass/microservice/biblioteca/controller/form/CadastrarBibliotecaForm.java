package compass.microservice.biblioteca.controller.form;

import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import compass.microservice.biblioteca.modelos.Biblioteca;
import compass.microservice.biblioteca.modelos.Endereco;
import compass.microservice.biblioteca.modelos.Livro;


public class CadastrarBibliotecaForm {
	
	
	private String nome;
	

	private String estado;

	private String cidade;

	private String bairro;

	private String rua;

	private int numero;

	
	
	
	
	public CadastrarBibliotecaForm() {
		
	}


	public Biblioteca converter () {
		
		Biblioteca biblioteca = new Biblioteca(nome);
		Endereco end = new Endereco( biblioteca ,estado, cidade , bairro , rua , numero);
		biblioteca.setEndereco(end);
		
		return biblioteca;
		
	}
	
	public Biblioteca atualizar(Biblioteca b) {

		b.setNome(this.nome);
		Endereco end = new Endereco(
				b,
				this.estado,
				this.cidade,
				this.bairro,
				this.rua,
				this.numero);
		b.setEndereco(end);


		return b;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
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