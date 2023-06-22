package br.edu.ifsul.cstsi.spring_sistema_bancario.Movimento;

import br.edu.ifsul.cstsi.spring_sistema_bancario.ContaComum.Contacomum;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

@Entity

@Table(name="movimentos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movimento {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idMovimento")
    private Long idMovimento;
    @Basic
    @Column(name = "tipoMovimento")
    private Integer tipoMovimento;
    @Basic
    @Column(name = "dataMovimento")
    private LocalDate dataMovimento;
    @Basic
    @Column(name = "horaMovimento")
    private Time horaMovimento;
    @Basic
    @Column(name = "valorMovimento")
    private Double valorMovimento;
    @Basic
    @Column(name = "idConta")
    private Integer idConta;
    @ManyToOne
    @JoinColumn(name = "idConta", referencedColumnName = "idConta")
    private Contacomum contacomum;


}
