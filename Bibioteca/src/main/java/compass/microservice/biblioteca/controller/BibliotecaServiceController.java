package compass.microservice.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import compass.microservice.biblioteca.controller.dto.RequestPedirLivroDto;
import compass.microservice.biblioteca.controller.dto.RequestTesteDTO;
import compass.microservice.biblioteca.controller.form.RequestPedirLivros;
import compass.microservice.biblioteca.controller.form.RequestTesteForm;
import compass.microservice.biblioteca.service.BibliotecaService;

@RestController
@RequestMapping("/service")
public class BibliotecaServiceController {
	//responde requisiçoes de serviço  do usuario
	
	@Autowired
	private BibliotecaService bService;
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/teste")	
	public ResponseEntity<RequestTesteDTO> teste(@RequestBody RequestTesteForm form) {		
		return bService.teste(form);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/pedido")	
	public ResponseEntity<RequestPedirLivroDto> pedirLivros(@RequestBody RequestPedirLivros form) {				
		return bService.pedirLivros(form);
	}

}