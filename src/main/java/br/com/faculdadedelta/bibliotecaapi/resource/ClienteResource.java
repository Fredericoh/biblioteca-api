package br.com.faculdadedelta.bibliotecaapi.resource;

import br.com.faculdadedelta.bibliotecaapi.model.Cliente;
import br.com.faculdadedelta.bibliotecaapi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente inserir(@RequestBody @Valid Cliente cliente, HttpServletResponse response){

        Cliente clienteSalvo = clienteService.inserir (cliente);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest ()
                .path ("/{id}")
                .buildAndExpand (cliente.getId ()).toUri ();

        response.setHeader (HttpHeaders.LOCATION, uri.toString ());

        return clienteSalvo;

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> listar(){

        return clienteService.listar ();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente pesquisarPorId(@PathVariable("id") Long id){

        return clienteService.pesquisarPorId (id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente alterar(@RequestBody @Valid Cliente cliente, @PathVariable Long id){

        return clienteService.alterar (cliente, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){

        clienteService.excluir (id);
    }
}
