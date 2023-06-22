package br.edu.ifsul.cstsi.spring_sistema_bancario.PessoaConta;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pessoaconta {
    @Basic
    @Column(name = "idPessoa", nullable = true)
    private Integer idPessoa;
    @Basic
    @Column(name = "idConta", nullable = true)
    private Integer idConta;
    @Id
    private Long id;

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
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

        Pessoaconta that = (Pessoaconta) o;

        if (idPessoa != null ? !idPessoa.equals(that.idPessoa) : that.idPessoa != null) return false;
        if (idConta != null ? !idConta.equals(that.idConta) : that.idConta != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPessoa != null ? idPessoa.hashCode() : 0;
        result = 31 * result + (idConta != null ? idConta.hashCode() : 0);
        return result;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
