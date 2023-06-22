package br.edu.ifsul.cstsi.spring_sistema_bancario.Pessoa;

import br.edu.ifsul.cstsi.spring_sistema_bancario.PessoaConta.Pessoaconta;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idPessoa")
    private Long idPessoa;
    @Basic
    @Column(name = "nomePessoa")
    private String nomePessoa;
    @Basic
    @Column(name = "enderecoPessoa")
    private String enderecoPessoa;
    @Basic
    @Column(name = "cepPessoa")
    private String cepPessoa;
    @Basic
    @Column(name = "telefonePessoa")
    private String telefonePessoa;
    @Basic
    @Column(name = "rendaPessoa")
    private Double rendaPessoa;
    @Basic
    @Column(name = "situacaoPessoa")
    private Integer situacaoPessoa;
    @Basic
    @Column(name = "cpfPessoa")
    private String cpfPessoa;
    @Basic
    @Column(name = "rgPessoa")
    private String rgPessoa;
    @Basic
    @Column(name = "idadePessoa")
    private Integer idadePessoa;
    @Basic
    @Column(name = "cnpjPessoa")
    private String cnpjPessoa;
    @OneToMany(mappedBy = "pessoaByIdPessoa")
    private Collection<Pessoaconta> pessoacontasByIdPessoa;

}
