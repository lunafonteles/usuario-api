package com.letscode.usuarioapi.controller;

import com.letscode.usuarioapi.documento.Usuario;
import com.letscode.usuarioapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @GetMapping
    public Flux<Usuario> obterTodos() {
        return usuarioService.buscarTodos();
    }

    @GetMapping("/{id}")
    public Mono<Usuario> obterUsuarioPorId(@PathVariable String id){
        return usuarioService.buscarPorId(id);
    }

    @PostMapping
    public Mono<Usuario> salvarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.criarUsuario(usuario);
    }
}
