package br.com.zup.projetoVac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.projetoVac.domain.Vacina;

@Repository
public interface VacinaRepository extends JpaRepository<Vacina, Long> {

	List<Vacina> findByEmail(String email);
}
