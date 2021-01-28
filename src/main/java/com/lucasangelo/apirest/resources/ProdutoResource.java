package com.lucasangelo.apirest.resources;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lucasangelo.apirest.repository.ProdutoRepository;
import com.lucasangelo.apirest.models.Produto;

import java.math.BigDecimal;
import java.util.List;

// É o controller
// Classe responsável por receber as requisições http
@RestController // Classe que recebe requisições http restful
@RequestMapping(value = "/api") // Uri padrão para a api
@Api(value = "API REST Produtos") // Dando um título para a API
@CrossOrigin(origins = "*") // Liberando todos os domínios para acessarem a API
public class ProdutoResource {

    @Autowired // Importar o repository do produto, para utilizar os métodos e conectar com o banco de dados
    ProdutoRepository produtoRepository;

    @GetMapping("/produtos") // Método GET que retorna a lista de todos os produtos
    @ApiOperation(value = "Retorna uma lista de produtos.")
    public List<Produto> listaProdutos() {
        return produtoRepository.findAll();
    }

    @GetMapping("/produto/{id}") // Método GET que retorna a lista de todos os produtos
    @ApiOperation(value = "Retorna um produto único.")
    public Produto produtoUnico(@PathVariable(value="id") long id) {
        return produtoRepository.findById(id);
    }

    @PostMapping("/produto")
    @ApiOperation(value = "Salva um produto.")
    public Produto salvaProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @GetMapping("/produto/valor/{menor}/{maior}")
    @ApiOperation(value = "Procura produtos entre valores mínimo e máximo.")
    public List<Produto> procurarEntreValor(@PathVariable(value="menor") BigDecimal menor, @PathVariable(value="maior") BigDecimal maior) {
        return produtoRepository.findProductBetweenPrice(menor, maior);
    }

    @DeleteMapping("/produto")
    @ApiOperation(value = "Deleta um produto.")
    public void deletaProduto(@RequestBody Produto produto) {
        produtoRepository.delete(produto);
    }

    @PutMapping("/produto")
    @ApiOperation(value = "Atualiza um produto.")
    public Produto atualizaProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

}