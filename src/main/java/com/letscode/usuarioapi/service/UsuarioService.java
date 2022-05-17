package com.letscode.usuarioapi.service;

import com.letscode.usuarioapi.documento.Usuario;
import com.letscode.usuarioapi.repositorio.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public Mono<Usuario> criarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Flux<Usuario> buscarTodos() {
        final var fluxdeUsuarisEncontrados = usuarioRepository.findAll();
        return fluxdeUsuarisEncontrados;
    }

    public Mono<Usuario> buscarPorId(String id) {
        return usuarioRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException((HttpStatus.NOT_FOUND), "usuario nao encontrado")));
    }

    public Mono<Usuario> deletarPorId(String id) {
        return usuarioRepository.findById(id);
    }

}
