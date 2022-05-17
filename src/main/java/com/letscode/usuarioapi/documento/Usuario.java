package com.letscode.usuarioapi.documento;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
public class Usuario {
    @Id
    private String id;
    private String nome;
    private String email;
    private String telefone;
    private String empresa;

}
