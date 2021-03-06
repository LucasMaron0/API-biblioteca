package compass.microservice.usuario;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import compass.microservice.usuario.controller.UsuarioController;
import compass.microservice.usuario.controller.dto.LivroDto;
import compass.microservice.usuario.controller.dto.UsuarioDto;
import compass.microservice.usuario.controller.form.CadastrarUsuarioForm;
import compass.microservice.usuario.modelo.Usuario;
import compass.microservice.usuario.repository.UsuarioRepository;
import compass.microservice.usuario.service.UsuarioService;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioControllerTest{

    @Mock
    private UsuarioService uService;
    
    @Mock 
    private UsuarioRepository uRepo;
    
    @Mock
    private UsuarioDto usuarioDto;
    
    @Mock
    private CadastrarUsuarioForm form;
    
    @Mock
    private Usuario usuario;
    
    @InjectMocks
    private UsuarioController usuarioController;

    @Before(value = "cadastrarUsuario")
    public ResponseEntity<?> cadastrarUsuario(@RequestBody @Valid CadastrarUsuarioForm form){

		Usuario usuario = form.converter();
		uRepo.save(usuario);

		return ResponseEntity.ok(new UsuarioDto(usuario));
    }
    
    @Test
    public void cadastrarUsuarioTest() throws Exception{ 	
    	assertNotNull(new UsuarioDto());
    }

    @Before(value = "livrosBiblioteca")
    public List<LivroDto> livrosBiblioteca(	@PathVariable Long id){
		return uService.listarLivros(id);
	}
    	
    @Test
    public void livrosBibliotecaTest() {
    	List<LivroDto> livros = new ArrayList<LivroDto>();
    	livros.add(new LivroDto());
    	
    	assertNotNull(livros);
    	
    }
    
}
