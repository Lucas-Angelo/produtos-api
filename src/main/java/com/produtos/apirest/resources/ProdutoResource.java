package com.produtos.apirest.resources;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

// É o controller
// Classe responsável por receber as requisições http
@CrossOrigin(origins = "*") // Liberando todos os domínios para acessarem a API
@RestController // Classe que recebe requisições http restful
@RequestMapping(value="/api") // Uri padrão para a api
@Api(value="API REST Produtos") // Dando um título para a API, swagger
public class ProdutoResource {
	
	@Autowired // Importar o repository do produto, para utilizar os métodos e conectar com o banco de dados
	ProdutoRepository produtoRepository;
	
	@ApiOperation(value="Retorna uma lista de Produtos")
	@GetMapping("/produtos") // Método GET que retorna a lista de todos os produtos
	public List<Produto> listaProdutos(){
		return produtoRepository.findAll();
	}
	
	@ApiOperation(value="Retorna um produto unico")
	@GetMapping("/produto/{id}") // Método GET que retorna uma produto com ID específico
	public Produto listaProdutoUnico(@PathVariable(value="id") long id){
		return produtoRepository.findById(id);
	}
	
	@ApiOperation(value="Salva um produto")
	@PostMapping("/produto")
	public Produto salvaProduto(@RequestBody @Valid Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@ApiOperation(value="Deleta um produto")
	@DeleteMapping("/produto")
	public void deletaProduto(@RequestBody @Valid Produto produto) {
		produtoRepository.delete(produto);
	}
	
	@ApiOperation(value="Atualiza um produto")
	@PutMapping("/produto")
	public Produto atualizaProduto(@RequestBody @Valid Produto produto) {
		return produtoRepository.save(produto);
	}

	@GetMapping("/produtos/valor/{menor}/{maior}")
	@ApiOperation(value = "Procura produtos entre valores mínimo e máximo.")
	public List<Produto> procurarEntreValor(@PathVariable(value="menor") BigDecimal menor, @PathVariable(value="maior") BigDecimal maior) {
		return produtoRepository.findProductBetweenPrice(menor, maior);
	}

}
