package com.generation.lojadegames.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.lojadegames.model.Produtos;

public interface ProdutosRepository extends JpaRepository <Produtos, Long>{

	public List <Produtos> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
	public List <Produtos> findByPrecoGreaterThanEqual(@Param("preco") BigDecimal preco);
}
