package br.com.zup.projetoVac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.projetoVac.domain.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
	
	List<Usuarios> findByEmail(String email);

	List<Usuarios> findByCpf(String cpf);
	
	List<Usuarios> findByNome(String nome);
}
