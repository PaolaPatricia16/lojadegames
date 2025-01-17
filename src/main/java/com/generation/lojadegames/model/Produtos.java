package com.generation.lojadegames.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
@Table (name = "tb_produtos")
public class Produtos {
	
	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private Long id;
	
	@NotBlank
	@Size(min = 5, max = 100, message = "O campo Nome deve conter de 5 a 100 caracteres.")
	private String nome;
	

	@NotBlank
	@Size(min = 4, max = 100, message = "O campo Marca deve conter de 4 a 100 caracteres.")
	private String marca;
	
	@NotNull
	@PositiveOrZero // valida que o númer seja positivo (considerando o 0 )
	private Integer quantidade;
	
	
	@PositiveOrZero // valida que o númer seja positivo (considerando o 0 )
	@Column (precision = 10, scale = 2, nullable = false) // configura o tamanh do campo no BD
	@Digits(integer = 8, fraction = 2) // valida os dados inseridos em memória, antes de gravar no BD
	private BigDecimal preco;

	
	// Criando relacionamento entre tabelas
	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Categorias categorias; // Objeto categorias do 'tipo' da Classe Categorias (model). Representa a FK




	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}

	
	public void setNome(String nome) {
		this.nome = nome;
	}


	
	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	
	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}



	public BigDecimal getPreco() {
		return preco;
	}


	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}



	public Categorias getCategorias() {
		return categorias;
	}


	public void setCategorias(Categorias categorias) {
		this.categorias = categorias;
	}


	

}
