package br.edu.ifsul.cstsi.spring_sistema_bancario.ContaComum;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Contacomum {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idConta", nullable = false)
    private int idConta;
    @Basic
    @Column(name = "numeroConta", nullable = true, length = 250)
    private String numeroConta;
    @Basic
    @Column(name = "aberturaConta", nullable = true)
    private Date aberturaConta;
    @Basic
    @Column(name = "fechamentoConta", nullable = true)
    private Date fechamentoConta;
    @Basic
    @Column(name = "situacaoConta", nullable = true)
    private Integer situacaoConta;
    @Basic
    @Column(name = "senhaConta", nullable = true)
    private Integer senhaConta;
    @Basic
    @Column(name = "saldoConta", nullable = true)
    private Integer saldoConta;
    @Basic
    @Column(name = "limiteConta", nullable = true, precision = 0)
    private Double limiteConta;
    @Basic
    @Column(name = "aniversarioConta", nullable = true)
    private Date aniversarioConta;


    @Override
    public String   toString() {
        return "Contacomum{" +
                "idConta=" + idConta +
                ", numeroConta='" + numeroConta + '\'' +
                ", aberturaConta=" + aberturaConta +
                ", fechamentoConta=" + fechamentoConta +
                ", situacaoConta=" + situacaoConta +
                ", senhaConta=" + senhaConta +
                ", saldoConta=" + saldoConta +
                ", limiteConta=" + limiteConta +
                ", aniversarioConta=" + aniversarioConta +
                '}';
    }
}
