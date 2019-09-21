package br.com.faculdadedelta.bibliotecaapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo rua é obrigatorio.")
    private String rua;

    @NotBlank(message = "O campo bairro é obrigatorio.")
    private String bairro;

    @NotBlank(message = "O campo quadra é obrigatorio.")
    private String quadra;

    @NotBlank(message = "O campo lote é obrigatorio.")
    private String lote;

    @NotBlank(message = "O campo numero é obrigatorio.")
    private String numero;

    @NotBlank(message = "O campo complemento é obrigatorio.")
    private String complemento;

    @NotBlank(message = "O campo cidade é obrigatorio.")
    private String cidade;

    @NotBlank(message = "O campo estado é obrigatorio.")
    private String estado;

    @NotBlank(message = "O campo pais é obrigatorio.")
    private String pais;
}
