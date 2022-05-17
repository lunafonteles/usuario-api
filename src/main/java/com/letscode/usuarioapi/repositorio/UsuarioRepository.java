package com.letscode.usuarioapi.repositorio;

import com.letscode.usuarioapi.documento.Usuario;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends ReactiveCrudRepository<Usuario, String> {

}
