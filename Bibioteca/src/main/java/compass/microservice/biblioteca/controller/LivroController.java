package compass.microservice.biblioteca.controller;

import java.net.URI;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import compass.microservice.biblioteca.controller.dto.BibliotecaDto;
import compass.microservice.biblioteca.controller.dto.LivroDto;
import compass.microservice.biblioteca.controller.dto.erros.ErroCadastrarLivro;
import compass.microservice.biblioteca.controller.form.AtualizarLivroForm;
import compass.microservice.biblioteca.controller.form.CadastrarBibliotecaForm;
import compass.microservice.biblioteca.controller.form.CadastrarLivroForm;
import compass.microservice.biblioteca.modelos.Biblioteca;
import compass.microservice.biblioteca.modelos.Livro;
import compass.microservice.biblioteca.repository.BibliotecaRepository;
import compass.microservice.biblioteca.repository.LivrosRepository;


@RestController
@RequestMapping(value = "/livros")
public class LivroController {

	@Autowired
	private LivrosRepository lRepo;
	
	@Autowired
	private BibliotecaRepository bRepo;
	
	
	
	@GetMapping
	@Cacheable(value = "listaDeLivros")
	public Page<LivroDto> lista(@PageableDefault(sort="id", direction= Direction.ASC,page=0, size=10)Pageable paginacao) {

		Page<Livro> livros = lRepo.findAll(paginacao);

		return LivroDto.converter(livros);


	}

	@GetMapping("/{id}")
	public ResponseEntity<LivroDto> detalhar(@PathVariable Long id) {
		Optional<Livro> optional = lRepo.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(new LivroDto(optional.get()));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/livros/{id}")
	public Page<LivroDto> livrosBiblioteca(	@PathVariable Long id,
			@PageableDefault(sort="id", direction= Direction.ASC,page=0, size=10)Pageable paginacao){

		Page<Livro>  livros = lRepo.findByBiblioteca_id(id,paginacao);


		return LivroDto.converter(livros);
	}
	
	
	@PostMapping("/cadastrar")
	@Transactional
	@CacheEvict(value = "listaDeLivros", allEntries = true)
	public ResponseEntity<?> cadastrarLivro(@RequestBody CadastrarLivroForm form , UriComponentsBuilder uriBuilder){

		Optional<Biblioteca> optional = bRepo.findById(form.getIdBiblioteca());

		if (optional.isPresent()) {
			Biblioteca biblioteca = optional.get();
			Livro livro = form.converter(biblioteca);
			biblioteca.getLivros().add(livro);
			lRepo.save(livro);

			URI uri = uriBuilder.path("/liv/{id}").buildAndExpand(livro.getId()).toUri();
			return ResponseEntity.created(uri).body(new LivroDto(livro));

		}else {
			return ResponseEntity.badRequest().body(new ErroCadastrarLivro("Está biblioteca não existe"));
		}

	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<LivroDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarLivroForm form) {	
			
		Optional<Livro> opt = lRepo.findById(id);

			if (opt.isPresent()) {
				Livro l = opt.get();
				Livro livroAtualizado = form.atualizar(l, l.getBiblioteca());
				return ResponseEntity.ok(new LivroDto (livroAtualizado));
			}
		
		return ResponseEntity.notFound().build();
	}



	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeLivros", allEntries = true)
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Livro> optional = lRepo.findById(id);
		if (optional.isPresent()) {
			lRepo.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	

}