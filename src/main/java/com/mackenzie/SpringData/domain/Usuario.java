package com.mackenzie.SpringData.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name="usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUsuario;

    @NotEmpty
    private String username;

    @NotEmpty
    private String pass;

    @OneToMany
    @JoinColumn(name="id_usuario")
    private List<Rol> roles;

}
