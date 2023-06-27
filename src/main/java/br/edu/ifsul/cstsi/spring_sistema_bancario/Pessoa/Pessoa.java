package br.edu.ifsul.cstsi.spring_sistema_bancario.Pessoa;

import br.edu.ifsul.cstsi.spring_sistema_bancario.ContaComum.Contacomum;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Collection;

@Entity
@Table(name="pessoas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPessoa;
    private String nomePessoa;
    private String enderecoPessoa;
    private String cepPessoa;
    private String telefonePessoa;
    private Double rendaPessoa;
    private Integer situacaoPessoa;
    private String cpfPessoa;
    private String rgPessoa;
    private Integer idadePessoa;
    private String cnpjPessoa;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "pessoas_contas",
            joinColumns = @JoinColumn(name = "idPessoa"),
            inverseJoinColumns = @JoinColumn(name = "idConta"))
    private Collection<Contacomum> contas;


}
