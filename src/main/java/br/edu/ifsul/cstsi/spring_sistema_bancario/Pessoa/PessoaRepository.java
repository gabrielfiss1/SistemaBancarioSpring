package br.edu.ifsul.cstsi.spring_sistema_bancario.Pessoa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {
        @Query(value = "SELECT p FROM Pessoa p where p.nomePessoa = ?1")
        List<Pessoa> findByNomePessoa(String nomePessoa);
}
