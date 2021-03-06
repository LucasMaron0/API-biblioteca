package compass.microservice.biblioteca.controller.dto;

import compass.microservice.biblioteca.modelos.Biblioteca;
import compass.microservice.biblioteca.modelos.Livro;

public class InfoLocLivroDto {
	

	private Long idLivro;
	
	private String nomeLivro;

	private String nomeBiblioteca;

	private String endBiblioteca;
	
	private String statusLivro;
	
	
	
	
	public InfoLocLivroDto(Livro l, Biblioteca bb) {
		
		this.idLivro = l.getId();
		this.nomeLivro = l.getNome();
		this.nomeBiblioteca= "(ID:"+bb.getId()+") "+bb.getNome();
		
		
		this.endBiblioteca = bb.getEndereco().getEstado().toString()
				+", "+ bb.getEndereco().getCidade()
				+", "+ bb.getEndereco().getBairro()
				+", "+ bb.getEndereco().getRua()
				+", "+ bb.getEndereco().getNumero();
		
		this.statusLivro = l.getStatusLivro().toString();
		
		
	}

	public InfoLocLivroDto(String s) {
		this.nomeLivro = s;
		this.statusLivro = "Livro não encontrado";
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public String getNomeBiblioteca() {
		return nomeBiblioteca;
	}

	public void setNomeBiblioteca(String nomeBiblioteca) {
		this.nomeBiblioteca = nomeBiblioteca;
	}

	public String getEndBiblioteca() {
		return endBiblioteca;
	}

	public void setEndBiblioteca(String endBiblioteca) {
		this.endBiblioteca = endBiblioteca;
	}

	public Long getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Long idLivro) {
		this.idLivro = idLivro;
	}

	public String getStatusLivro() {
		return statusLivro;
	}

	public void setStatusLivro(String statusLivro) {
		this.statusLivro = statusLivro;
	}
	
	

	

}
