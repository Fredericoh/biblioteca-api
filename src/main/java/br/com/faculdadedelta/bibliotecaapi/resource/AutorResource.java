package br.com.faculdadedelta.bibliotecaapi.resource;

import br.com.faculdadedelta.bibliotecaapi.model.Autor;
import br.com.faculdadedelta.bibliotecaapi.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorResource {

    @Autowired
    private AutorService autorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ROLE_INCLUIR_AUTOR')")
    public Autor inserir(@RequestBody @Valid Autor autor, HttpServletResponse response){

        Autor autorSalvo = autorService.inserir (autor);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest ()
                .path ("/{id}")
                .buildAndExpand (autor.getId ()).toUri ();

        response.setHeader (HttpHeaders.LOCATION, uri.toString ());

        return autorSalvo;

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('ROLE_LISTAR_AUTOR')")
    public List<Autor> listar(@RequestParam(required = false, defaultValue = "0", name = "_start") int start,
                                @RequestParam(required = false, defaultValue = "10", name = "_end") int end,
                                @RequestParam(required = false, name = "_order") String order,
                                @RequestParam(required = false, name = "_sort") String sort,
                                @RequestParam(required = false, name = "name") String name, HttpServletResponse response) {

        int size = end - start;

        int page = size == 0 ? 0 : Double.valueOf(Math.ceil(end / size)).intValue() - 1;

        Sort srt = Sort.unsorted();

        if (!ObjectUtils.isEmpty(order) && !ObjectUtils.isEmpty(sort)) {
            srt = Sort.by(Sort.Direction.valueOf(order), sort);
        }

        Page<Autor> p = autorService.listar(page, size, srt);

        response.addHeader("X-Total-Count", String.valueOf(p.getTotalElements()));

        return p.getContent();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_POR_ID_AUTOR')")
    public Autor pesquisarPorId(@PathVariable("id") Long id){

        return autorService.pesquisarPorId (id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('ROLE_ALTERAR_AUTOR')")
    public Autor alterar(@RequestBody @Valid Autor autor, @PathVariable Long id){

        return autorService.alterar (autor, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('ROLE_EXCLUIR_AUTOR')")
    public void remover(@PathVariable Long id){

        autorService.excluir (id);
    }
}
