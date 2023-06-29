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
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity

@Table(name="movimentos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMovimento;
    private Integer tipoMovimento;
    private LocalDate dataMovimento;
    private LocalTime horaMovimento;
    private Double valorMovimento;
    @ManyToOne
    @JoinColumn(name = "id_contacomum", referencedColumnName = "idConta")
    private Contacomum contacomum;

    @Override
    public String toString() {
        return "\nMovimento{" +
                "idMovimento=" + idMovimento +
                ", tipoMovimento=" + tipoMovimento +
                ", dataMovimento=" + dataMovimento +
                ", horaMovimento=" + horaMovimento +
                ", valorMovimento=" + valorMovimento +
                ", contacomum=" + contacomum +
                '}';
    }
}