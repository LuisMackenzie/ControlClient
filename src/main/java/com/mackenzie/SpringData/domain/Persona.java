package com.mackenzie.SpringData.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
@Table(name = "persona")
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpersona")
    private Long idPersona;

    @NotEmpty
    private String name;

    @NotEmpty
    private String last;

    @NotEmpty
    @Email
    private String email;

    private String phone;

    @NotNull
    private Double saldo;

}
