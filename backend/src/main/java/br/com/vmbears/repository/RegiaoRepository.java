package br.com.vmbears.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vmbears.model.Regiao;

@Repository
public interface RegiaoRepository extends JpaRepository<Regiao, Integer> {

	List<Regiao> findBySigla(String sigla);
	
}
