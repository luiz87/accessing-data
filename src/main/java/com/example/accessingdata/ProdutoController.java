package com.example.accessingdata;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // Isso significa que esta classe é um controlador
@RequestMapping(path = "/produto") // Isso significa que os URLs começam com / demo (após o caminho do aplicativo)
@CrossOrigin(origins = "*")
public class ProdutoController {

    @Autowired // faz o star do nosso objeto
    private ProdutoRepository uRepository;

    @PostMapping(path = "/")
    public @ResponseBody int add(@RequestBody Produto produto) {
        uRepository.save(produto);
        return produto.getId();
    }

    @GetMapping(path = "/")
    public @ResponseBody Iterable<Produto> getAllUsuarios(){
        return uRepository.findAll();
    }

    // PUT atualizar
    @PutMapping(path = "/")
    public @ResponseBody int updateUsuario(@RequestBody Produto produto) {
        uRepository.save(produto);
        return produto.getId();
    }

    // DELETE apagar
    @DeleteMapping(path = "/")
    public @ResponseBody String deleteUsuario(@PathVariable int id) {
        uRepository.deleteById(id);
        return "Ok ao apagar.";
    }
}
