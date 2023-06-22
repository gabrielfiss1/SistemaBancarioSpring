package br.edu.ifsul.cstsi.spring_sistema_bancario.PessoaConta;

import br.edu.ifsul.cstsi.spring_sistema_bancario.ContaComum.Contacomum;
import br.edu.ifsul.cstsi.spring_sistema_bancario.Pessoa.Pessoa;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
@Entity
@Table(name="pessoa_conta")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoaconta {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "idPessoa")
    private Long idPessoa;
    @Basic
    @Column(name = "idConta")
    private Long idConta;
    @ManyToOne
    @JoinColumn(name = "idPessoa", referencedColumnName = "idPessoa")
    private Pessoa pessoaByIdPessoa;
    @ManyToOne
    @JoinColumn(name = "idConta", referencedColumnName = "idConta")
    private Contacomum contacomumByIdConta;


}
