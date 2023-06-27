package br.edu.ifsul.cstsi.spring_sistema_bancario.ContaComum;

import br.edu.ifsul.cstsi.spring_sistema_bancario.Movimento.Movimento;
import br.edu.ifsul.cstsi.spring_sistema_bancario.Pessoa.Pessoa;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConta;
    private String numeroConta;
    private LocalDate aberturaConta;
    private LocalDate fechamentoConta;
    private Integer situacaoConta;
    private Integer senhaConta;
    private Integer saldoConta;
    private Double limiteConta;
    private LocalDate aniversarioConta;
    @Transient
    private Collection<Movimento> movimentos;
    @ManyToMany(fetch = FetchType.EAGER , mappedBy = "contas")
    private Collection<Pessoa> pessoas;


}



