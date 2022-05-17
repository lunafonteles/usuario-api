package com.letscode.usuarioapi.controller.router;

import com.letscode.usuarioapi.controller.handler.UsuarioHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;

@Configuration
public class UsuarioRouter {
    @Bean
    public RouterFunction<ServerResponse> router(UsuarioHandler handler) {
        return RouterFunctions.route(GET("/v1/usuarios"), handler::buscarTodos)
                .andRoute(GET("/v1/usuarios/{id}"), handler::buscarPorId)
                .andRoute(POST("/v1/usuarios"), handler::cadastrarUsuario);

       /* return route()
                .path("/v1/usuario", b1 -> b1
                        .nest(accept(APPLICATION_JSON), b2 -> b2
                                .GET("/{id}", handler::buscarPorId)
                                .GET("", handler::listaUsuario)))
                .build();*/
    }
}
