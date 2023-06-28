package br.edu.ifsul.cstsi.spring_sistema_bancario.Movimento;


import br.edu.ifsul.cstsi.spring_sistema_bancario.Pessoa.Pessoa;
import br.edu.ifsul.cstsi.spring_sistema_bancario.Pessoa.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class MovimentoService  {
    @Autowired
    private MovimentoRepository rep;

    public List<Movimento> getMovimentos() {
        return rep.findAll();
    }

    public Movimento getMovimentoById(Long id) {
        Optional<Movimento> optional = rep.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

   // public Movimento getMovimentoByData(Long id){
    //    Optional<Movimento> optional = rep.findById(id);
    //    if(optional.isPresent()) {
   //         return optional.get();
   //     }
       //return null;
   // }

    public Movimento insert(Movimento movimento) {
        Assert.isNull(movimento.getIdMovimento(),"Não foi possível inserir o registro");
        return rep.save(movimento);
    }

    public Movimento update(Movimento movimento) {
        Assert.notNull(movimento.getIdMovimento(),"Não foi possível atualizar o registro");

        // Busca a conta no banco de dados
        Optional<Movimento> optional = rep.findById((long)  movimento.getIdMovimento());
        if(optional.isPresent()) {
            Movimento db = optional.get();
            db.setDataMovimento(movimento.getDataMovimento());
            db.setValorMovimento(movimento.getValorMovimento());
            //db.setIdadePessoa(pessoa.getIdadePessoa());
            rep.save(db);

            return db;
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }

}
