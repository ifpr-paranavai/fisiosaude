package br.edu.ifpr.medsaudelib.config;

import br.edu.ifpr.medsaudelib.entity.Usuario;
import br.edu.ifpr.medsaudelib.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired(required = false)
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> optional = repository.findByEmail(username);

        if(optional.isPresent()) {
            //fazer debug para ver onde esse return leva
            return optional.get();
        }

        throw new UsernameNotFoundException("User not found");
    }

}
