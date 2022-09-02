package br.edu.ifpr.medsaudelib.repository;

import br.edu.ifpr.medsaudelib.entity.Estado;
import br.edu.ifpr.medsaudelib.entity.Fisioterapeuta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FisioterapeutaRepository extends JpaRepository<Fisioterapeuta, Long> {

}