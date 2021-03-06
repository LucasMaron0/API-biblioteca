package compass.microservice.usuario.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import compass.microservice.usuario.client.BibliotecaClient;
import compass.microservice.usuario.controller.dto.EncerrarPedidoDto;
import compass.microservice.usuario.controller.dto.EndBibliotecaDto;
import compass.microservice.usuario.controller.dto.InfoLocLivroDto;
import compass.microservice.usuario.controller.dto.LivroDto;
import compass.microservice.usuario.controller.dto.RegistroDto;
import compass.microservice.usuario.controller.dto.RetornoPedidoDto;
import compass.microservice.usuario.controller.dto.RetornoRequestTesteDto;
import compass.microservice.usuario.controller.form.BuscarLivroProximoForm;
import compass.microservice.usuario.controller.form.MandarEnderecoUsuario;
import compass.microservice.usuario.controller.form.PedirLivroForm;
import compass.microservice.usuario.controller.form.TesteForm;
import compass.microservice.usuario.modelo.Usuario;
import compass.microservice.usuario.repository.UsuarioRepository;

@Service
public class UsuarioService {

	//recebe e manda requests para a biblioteca

	@Autowired
	private BibliotecaClient bClient;

	@Autowired
	private UsuarioRepository uRepo;

	//Manda



	public RetornoPedidoDto pedirLivros(@Valid PedirLivroForm form, String token) {

		RetornoPedidoDto retorno = bClient.pedirLivros(form, token);

		return retorno;
	}

	public List<LivroDto> listarLivros(Long id) {

		List<LivroDto>listarLivros = bClient.listarLivros(id);

		return listarLivros;
	}


	public EndBibliotecaDto buscarBibliMaisProxima(MandarEnderecoUsuario end) {

		return bClient.buscarBiblioMaisProxima(end);
	}



	public List<RegistroDto> listarRegistrosPorUsuario(Long idUsuario, String token){

		List<RegistroDto> listarRegistrosPorUsuario = bClient.listarRegistrosPorUsuario(idUsuario, token);

		return listarRegistrosPorUsuario;
	}
	public List<InfoLocLivroDto> buscarLivroProximo(BuscarLivroProximoForm form) {

		return bClient.buscarLivroProximo(form);
	}

	public HashMap<String, List<Object>> pedidoAvancado(BuscarLivroProximoForm form, String token) {
		return bClient.pedidoAvancado(form, token);
	}
	//Recebe


}
