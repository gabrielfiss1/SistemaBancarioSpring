package br.edu.ifsul.cstsi.spring_sistema_bancario.ContaComum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContaComumService {
        @Autowired
        private ContaComumRepository rep;

        public List<Contacomum> getContaComum() {
            return rep.findAll();
        }

        public Contacomum getContaComumById(Long id) {
            Optional<Contacomum> optional = rep.findById(id);
            if(optional.isPresent()) {
                return optional.get();
            }
            return null;
        }
        public List<Contacomum> getContaComumByNumeroConta(String numeroConta) {
            return new ArrayList<>(rep.findByNumeroConta(numeroConta));

        }

        public Contacomum getContaByIdSituacaoTrue(Long id){
            Optional<Contacomum> optional = rep.findById(id);
            if(optional.isPresent()) {
                return optional.get();
            }
            return null;
        }

        public Contacomum insert(Contacomum contacomum) {
            Assert.isNull(contacomum.getIdConta(),"Não foi possível inserir o registro");
            return rep.save(contacomum);
        }

        public Contacomum update(Contacomum contacomum) {
            Assert.notNull(contacomum.getIdConta(),"Não foi possível atualizar o registro");

            // Busca a conta no banco de dados
            Optional<Contacomum> optional = rep.findById((long) contacomum.getIdConta());
            if(optional.isPresent()) {
                Contacomum db = optional.get();
                // Copiar as propriedades
                db.setNumeroConta(contacomum.getNumeroConta());
                db.setSenhaConta(contacomum.getSenhaConta());
                db.setSaldoConta(contacomum.getSaldoConta());
                db.setFechamentoConta(contacomum.getFechamentoConta());
                db.setSituacaoConta(contacomum.getSituacaoConta());
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
