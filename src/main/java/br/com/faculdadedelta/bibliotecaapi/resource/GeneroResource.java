package br.com.faculdadedelta.bibliotecaapi.resource;

import br.com.faculdadedelta.bibliotecaapi.model.Genero;
import br.com.faculdadedelta.bibliotecaapi.repository.GeneroRepository;
import br.com.faculdadedelta.bibliotecaapi.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/generos")
public class GeneroResource {


    @Autowired
    private GeneroService generoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ROLE_INCLUIR_GENERO')")
    public Genero inserir(@RequestBody @Valid Genero genero, HttpServletResponse response){

        Genero generoSalvo = generoService.inserir (genero);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest ()
                .path ("/{id}")
                .buildAndExpand (genero.getId ()).toUri ();

        response.setHeader (HttpHeaders.LOCATION, uri.toString ());

        return generoSalvo;

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('ROLE_LISTAR_GENERO')")
    public List<Genero> listar(){

        return generoService.listar ();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_POR_ID_GENERO')")
    public Genero pesquisarPorId(@PathVariable("id") Long id){

        return generoService.pesquisarPorId (id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('ROLE_ALTERAR_GENERO')")
    public Genero alterar(@RequestBody @Valid Genero genero, @PathVariable Long id){

        return generoService.alterar (genero, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('ROLE_EXCLUIR_GENERO')")
    public void remover(@PathVariable Long id){

        generoService.excluir (id);
    }
}
