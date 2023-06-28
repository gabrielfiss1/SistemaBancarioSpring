package br.edu.ifsul.cstsi.spring_sistema_bancario;

import br.edu.ifsul.cstsi.spring_sistema_bancario.Movimento.Movimento;
import br.edu.ifsul.cstsi.spring_sistema_bancario.Movimento.MovimentoController;
import br.edu.ifsul.cstsi.spring_sistema_bancario.Pessoa.PessoaController;
import br.edu.ifsul.cstsi.spring_sistema_bancario.ContaComum.ContaComumController;
import java.util.Scanner;

public class HomeController {
    private static final Scanner input = new Scanner(System.in);

    public static void main() {

        int opcao;
        do {
            System.out.print("\n-------  Home -------");
            System.out.print(
                    """
    
                        
                        1. Manter Pessoa
                        2. Manter Conta
                        3. Manter Movimento
                  
                        Opção (Zero p/sair):\s""");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1 -> PessoaController.main(null);
                case 2 -> ContaComumController.main(null);
                case 3 -> MovimentoController.main(null);

                default -> {
                    if (opcao != 0) System.out.println("Opção inválida.");
                }
            }
        } while(opcao != 0) ;
        System.out.println("\n\n!!!!!!!! Fim da aplicação !!!!!!!!");
        input.close(); //libera o recurso
    }

}
