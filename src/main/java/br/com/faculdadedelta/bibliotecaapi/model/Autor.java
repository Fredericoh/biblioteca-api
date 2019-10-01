package br.com.faculdadedelta.bibliotecaapi.model;

import br.com.faculdadedelta.bibliotecaapi.model.type.Sexo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo nome é obrigatorio.")
    private String nome;

    @Enumerated(EnumType.STRING)
//    @NotNull(message = "O campo sexo é obrigatorio.")
    private Sexo sexo;
}
