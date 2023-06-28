package br.edu.ifsul.cstsi.spring_sistema_bancario.Movimento;

import br.edu.ifsul.cstsi.spring_sistema_bancario.ContaComum.Contacomum;
import br.edu.ifsul.cstsi.spring_sistema_bancario.Pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovimentoRepository extends JpaRepository <Movimento,Long> {
    @Query(value = "SELECT m FROM Movimento m where m.idMovimento = ?1")
    List<Pessoa> findByIdMovimento(Long idMovimento);
}
