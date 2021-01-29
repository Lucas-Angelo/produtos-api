package com.produtos.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.apirest.models.Produto;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

// JpaRepository possui os métodos de pesistência no banco de dados
// Facilita para save, delete, findbyid
// Basta apenas criar a instância desse JpaRepository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	Produto findById(long id);

	@Query(value = "SELECT * FROM tb_produtos WHERE valor BETWEEN ?1 AND ?2", nativeQuery = true)
	List<Produto> findProductBetweenPrice(BigDecimal menor, BigDecimal maior);

}
