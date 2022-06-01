package br.edu.ifpr.medsaudelib.repository;

import br.edu.ifpr.medsaudelib.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    Optional<Usuario> findByEmail(String email);

}