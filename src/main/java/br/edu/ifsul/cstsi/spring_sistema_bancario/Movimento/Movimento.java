package br.edu.ifsul.cstsi.spring_sistema_bancario.Movimento;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
public class Movimento {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idMovimento", nullable = false)
    private int idMovimento;
    @Basic
    @Column(name = "tipoMovimento", nullable = true)
    private Integer tipoMovimento;
    @Basic
    @Column(name = "dataMovimento", nullable = true)
    private Date dataMovimento;
    @Basic
    @Column(name = "horaMovimento", nullable = true)
    private Time horaMovimento;
    @Basic
    @Column(name = "valorMovimento", nullable = true, precision = 0)
    private Double valorMovimento;
    @Basic
    @Column(name = "idConta", nullable = true)
    private Integer idConta;

    public int getIdMovimento() {
        return idMovimento;
    }

    public void setIdMovimento(int idMovimento) {
        this.idMovimento = idMovimento;
    }

    public Integer getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(Integer tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public Date getDataMovimento() {
        return dataMovimento;
    }

    public void setDataMovimento(Date dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public Time getHoraMovimento() {
        return horaMovimento;
    }

    public void setHoraMovimento(Time horaMovimento) {
        this.horaMovimento = horaMovimento;
    }

    public Double getValorMovimento() {
        return valorMovimento;
    }

    public void setValorMovimento(Double valorMovimento) {
        this.valorMovimento = valorMovimento;
    }

    public Integer getIdConta() {
        return idConta;
    }

    public void setIdConta(Integer idConta) {
        this.idConta = idConta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movimento movimento = (Movimento) o;

        if (idMovimento != movimento.idMovimento) return false;
        if (tipoMovimento != null ? !tipoMovimento.equals(movimento.tipoMovimento) : movimento.tipoMovimento != null)
            return false;
        if (dataMovimento != null ? !dataMovimento.equals(movimento.dataMovimento) : movimento.dataMovimento != null)
            return false;
        if (horaMovimento != null ? !horaMovimento.equals(movimento.horaMovimento) : movimento.horaMovimento != null)
            return false;
        if (valorMovimento != null ? !valorMovimento.equals(movimento.valorMovimento) : movimento.valorMovimento != null)
            return false;
        if (idConta != null ? !idConta.equals(movimento.idConta) : movimento.idConta != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMovimento;
        result = 31 * result + (tipoMovimento != null ? tipoMovimento.hashCode() : 0);
        result = 31 * result + (dataMovimento != null ? dataMovimento.hashCode() : 0);
        result = 31 * result + (horaMovimento != null ? horaMovimento.hashCode() : 0);
        result = 31 * result + (valorMovimento != null ? valorMovimento.hashCode() : 0);
        result = 31 * result + (idConta != null ? idConta.hashCode() : 0);
        return result;
    }
}
