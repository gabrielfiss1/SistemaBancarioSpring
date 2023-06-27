package br.edu.ifsul.cstsi.spring_sistema_bancario;

import br.edu.ifsul.cstsi.spring_sistema_bancario.ContaComum.ContaComumController;
import br.edu.ifsul.cstsi.spring_sistema_bancario.Pessoa.PessoaController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSistemaBancarioApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringSistemaBancarioApplication.class, args);
        HomeController.main();
    }

}
