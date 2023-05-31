package br.edu.ifsul.cstsi.spring_sistema_bancario.ContaComum;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContaComumRepository extends JpaRepository<Contacomum,Long> {
        @Query(value = "SELECT c FROM Contacomum c where c.numeroConta = ?1")
        List<Contacomum> findByNumeroConta(String numeroConta);

}
