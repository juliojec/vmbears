package br.com.vmbears.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vmbears.model.Agentes;

@Repository
@Transactional
public interface AgentesRepository extends JpaRepository<Agentes, Integer> {

	
}
