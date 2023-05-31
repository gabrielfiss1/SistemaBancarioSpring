package br.edu.ifsul.cstsi.spring_sistema_bancario.Pessoa;

import jakarta.persistence.*;

@Entity
public class Pessoa {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idPessoa", nullable = false)
    private int idPessoa;
    @Basic
    @Column(name = "nomePessoa", nullable = true, length = 50)
    private String nomePessoa;
    @Basic
    @Column(name = "enderecoPessoa", nullable = true, length = 50)
    private String enderecoPessoa;
    @Basic
    @Column(name = "cepPessoa", nullable = true, length = -1)
    private String cepPessoa;
    @Basic
    @Column(name = "telefonePessoa", nullable = true, length = 50)
    private String telefonePessoa;
    @Basic
    @Column(name = "rendaPessoa", nullable = true, precision = 0)
    private Double rendaPessoa;
    @Basic
    @Column(name = "situacaoPessoa", nullable = true)
    private Integer situacaoPessoa;
    @Basic
    @Column(name = "cpfPessoa", nullable = true, length = -1)
    private String cpfPessoa;
    @Basic
    @Column(name = "rgPessoa", nullable = true, length = -1)
    private String rgPessoa;
    @Basic
    @Column(name = "idadePessoa", nullable = true)
    private Integer idadePessoa;
    @Basic
    @Column(name = "cnpjPessoa", nullable = true, length = -1)
    private String cnpjPessoa;

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getEnderecoPessoa() {
        return enderecoPessoa;
    }

    public void setEnderecoPessoa(String enderecoPessoa) {
        this.enderecoPessoa = enderecoPessoa;
    }

    public String getCepPessoa() {
        return cepPessoa;
    }

    public void setCepPessoa(String cepPessoa) {
        this.cepPessoa = cepPessoa;
    }

    public String getTelefonePessoa() {
        return telefonePessoa;
    }

    public void setTelefonePessoa(String telefonePessoa) {
        this.telefonePessoa = telefonePessoa;
    }

    public Double getRendaPessoa() {
        return rendaPessoa;
    }

    public void setRendaPessoa(Double rendaPessoa) {
        this.rendaPessoa = rendaPessoa;
    }

    public Integer getSituacaoPessoa() {
        return situacaoPessoa;
    }

    public void setSituacaoPessoa(Integer situacaoPessoa) {
        this.situacaoPessoa = situacaoPessoa;
    }

    public String getCpfPessoa() {
        return cpfPessoa;
    }

    public void setCpfPessoa(String cpfPessoa) {
        this.cpfPessoa = cpfPessoa;
    }

    public String getRgPessoa() {
        return rgPessoa;
    }

    public void setRgPessoa(String rgPessoa) {
        this.rgPessoa = rgPessoa;
    }

    public Integer getIdadePessoa() {
        return idadePessoa;
    }

    public void setIdadePessoa(Integer idadePessoa) {
        this.idadePessoa = idadePessoa;
    }

    public String getCnpjPessoa() {
        return cnpjPessoa;
    }

    public void setCnpjPessoa(String cnpjPessoa) {
        this.cnpjPessoa = cnpjPessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pessoa pessoa = (Pessoa) o;

        if (idPessoa != pessoa.idPessoa) return false;
        if (nomePessoa != null ? !nomePessoa.equals(pessoa.nomePessoa) : pessoa.nomePessoa != null) return false;
        if (enderecoPessoa != null ? !enderecoPessoa.equals(pessoa.enderecoPessoa) : pessoa.enderecoPessoa != null)
            return false;
        if (cepPessoa != null ? !cepPessoa.equals(pessoa.cepPessoa) : pessoa.cepPessoa != null) return false;
        if (telefonePessoa != null ? !telefonePessoa.equals(pessoa.telefonePessoa) : pessoa.telefonePessoa != null)
            return false;
        if (rendaPessoa != null ? !rendaPessoa.equals(pessoa.rendaPessoa) : pessoa.rendaPessoa != null) return false;
        if (situacaoPessoa != null ? !situacaoPessoa.equals(pessoa.situacaoPessoa) : pessoa.situacaoPessoa != null)
            return false;
        if (cpfPessoa != null ? !cpfPessoa.equals(pessoa.cpfPessoa) : pessoa.cpfPessoa != null) return false;
        if (rgPessoa != null ? !rgPessoa.equals(pessoa.rgPessoa) : pessoa.rgPessoa != null) return false;
        if (idadePessoa != null ? !idadePessoa.equals(pessoa.idadePessoa) : pessoa.idadePessoa != null) return false;
        if (cnpjPessoa != null ? !cnpjPessoa.equals(pessoa.cnpjPessoa) : pessoa.cnpjPessoa != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPessoa;
        result = 31 * result + (nomePessoa != null ? nomePessoa.hashCode() : 0);
        result = 31 * result + (enderecoPessoa != null ? enderecoPessoa.hashCode() : 0);
        result = 31 * result + (cepPessoa != null ? cepPessoa.hashCode() : 0);
        result = 31 * result + (telefonePessoa != null ? telefonePessoa.hashCode() : 0);
        result = 31 * result + (rendaPessoa != null ? rendaPessoa.hashCode() : 0);
        result = 31 * result + (situacaoPessoa != null ? situacaoPessoa.hashCode() : 0);
        result = 31 * result + (cpfPessoa != null ? cpfPessoa.hashCode() : 0);
        result = 31 * result + (rgPessoa != null ? rgPessoa.hashCode() : 0);
        result = 31 * result + (idadePessoa != null ? idadePessoa.hashCode() : 0);
        result = 31 * result + (cnpjPessoa != null ? cnpjPessoa.hashCode() : 0);
        return result;
    }
}
