package br.edu.ifsul.cstsi.spring_sistema_bancario.Pessoa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository rep;

    public List<Pessoa> getPessoa() {
        return rep.findAll();
    }

    public Pessoa getPessoaById(Long id) {
        Optional<Pessoa> optional = rep.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    public List<Pessoa> getPessoaByName(String nomePessoa){
        return new ArrayList<>(rep.findByNomePessoa(nomePessoa));
    }

    public Pessoa insert(Pessoa pessoa) {
        Assert.isNull(pessoa.getIdPessoa(),"Não foi possível inserir o registro");
        return rep.save(pessoa);
    }

    public Pessoa update(Pessoa pessoa) {
        Assert.notNull(pessoa.getIdPessoa(),"Não foi possível atualizar o registro");

        // Busca a conta no banco de dados
        Optional<Pessoa> optional = rep.findById((long)  pessoa.getIdPessoa());
        if(optional.isPresent()) {
            Pessoa db = optional.get();
            db.setNomePessoa(pessoa.getNomePessoa());
            db.setIdadePessoa(pessoa.getIdadePessoa());
            db.setEnderecoPessoa(pessoa.getEnderecoPessoa());
            db.setCepPessoa(pessoa.getCepPessoa());
            db.setTelefonePessoa(pessoa.getTelefonePessoa());
            db.setRendaPessoa(pessoa.getRendaPessoa());
            db.setCpfPessoa(pessoa.getCpfPessoa());
            db.setRgPessoa(pessoa.getRgPessoa());
            db.setCnpjPessoa(pessoa.getCnpjPessoa());
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
