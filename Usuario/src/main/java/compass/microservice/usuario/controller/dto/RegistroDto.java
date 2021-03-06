package compass.microservice.usuario.controller.dto;

import java.time.LocalDate;
import java.util.List;

public class RegistroDto {

	private Long id;

	private Long idUsuario;
	
	private Long idBiblioteca;

	private String statusRegistro;

	private LocalDate dataLocacao;

	private LocalDate dataVencimento;
	
	private double multaGerada;
	
	private List<String> livros;

	public RegistroDto() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getStatusRegistro() {
		return statusRegistro;
	}

	public void setStatusRegistro(String statusRegistro) {
		this.statusRegistro = statusRegistro;
	}

	public LocalDate getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao(LocalDate dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public double getMultaGerada() {
		return multaGerada;
	}

	public void setMultaGerada(double multaGerada) {
		this.multaGerada = multaGerada;
	}

	public Long getIdBiblioteca() {
		return idBiblioteca;
	}

	public void setIdBiblioteca(Long idBiblioteca) {
		this.idBiblioteca = idBiblioteca;
	}

	public List<String> getLivros() {
		return livros;
	}

	public void setLivros(List<String> livros) {
		this.livros = livros;
	}
	
	
}
