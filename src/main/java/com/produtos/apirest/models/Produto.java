package com.produtos.apirest.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity // Pois vai ser um enteidade do banco de dados
@Table(name="produtos") // Nome da tabela no banco de dados
public class Produto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/* Os atributos de produto no banco de dados: */

	@Id // Vai ser o ID do banco de dados
	@GeneratedValue(strategy=GenerationType.AUTO) // Isso indica para o banco de dados criar automaticamente os IDs
	private long id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private BigDecimal quantidade;
	
	@NotNull
	private BigDecimal valor;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	

}
