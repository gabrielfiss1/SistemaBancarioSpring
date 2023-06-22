package br.edu.ifsul.cstsi.spring_sistema_bancario.ContaComum;

import br.edu.ifsul.cstsi.spring_sistema_bancario.Movimento.Movimento;
import br.edu.ifsul.cstsi.spring_sistema_bancario.PessoaConta.Pessoaconta;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

@Entity
@Table(name="contas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contacomum {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idConta")
    private Long idConta;
    @Basic
    @Column(name = "numeroConta")
    private String numeroConta;
    @Basic
    @Column(name = "aberturaConta")
    private LocalDate aberturaConta;
    @Basic
    @Column(name = "fechamentoConta")
    private LocalDate fechamentoConta;
    @Basic
    @Column(name = "situacaoConta")
    private Integer situacaoConta;
    @Basic
    @Column(name = "senhaConta")
    private Integer senhaConta;
    @Basic
    @Column(name = "saldoConta")
    private Integer saldoConta;
    @Basic
    @Column(name = "limiteConta")
    private Double limiteConta;
    @Basic
    @Column(name = "aniversarioConta")
    private LocalDate aniversarioConta;
    @OneToMany(mappedBy = "contacomum")
    private Collection<Movimento> movimentos;
    @OneToMany(mappedBy = "idConta")
    private Collection<Pessoaconta> pessoacontasByIdConta;


}
