package br.edu.ifpr.medsaudelib.repository;

import br.edu.ifpr.medsaudelib.entity.Estado;
import br.edu.ifpr.medsaudelib.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

    Optional<Estado> findByNome(String nome);

    Optional<Estado> findBySigla(String sigla);

}