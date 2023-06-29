package br.edu.ifsul.cstsi.spring_sistema_bancario.Movimento;

import br.edu.ifsul.cstsi.spring_sistema_bancario.ContaComum.ContaComumService;
import br.edu.ifsul.cstsi.spring_sistema_bancario.ContaComum.Contacomum;
import br.edu.ifsul.cstsi.spring_sistema_bancario.Pessoa.Pessoa;
import org.springframework.stereotype.Controller;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Controller
public class MovimentoController {
    private static final Scanner input = new Scanner(System.in);

    private static br.edu.ifsul.cstsi.spring_sistema_bancario.Movimento.MovimentoService movimentoService;
    private static br.edu.ifsul.cstsi.spring_sistema_bancario.ContaComum.ContaComumService contaComumService;


    public MovimentoController(MovimentoService movimentoService, ContaComumService contaComumService) {
        MovimentoController.movimentoService = movimentoService;
        MovimentoController.contaComumService = contaComumService;

    }
    public static void main(String[] args) {
        int opcao;
        do {
            System.out.print("\n\"-------  Menu Movimento -------\"");
            System.out.print(
                    """

                            1. Inserir um movimento
                            2. Atualizar um movimento
                            3. Excluir um movimento
                            4. Listar todos os movimentos
                            5. Buscar movimento pelo código
                            Opção (Zero p/sair):\s""");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1 -> inserir();
                case 2 -> atualizar();
                case 3 -> excluir();
                case 4 -> selectMovimentos();
                case 5 -> selectMovimentosById();
                default -> {
                    if (opcao != 0) System.out.println("Opção inválida.");
                }
            }
        } while (opcao != 0);
    }
    private static void inserir() {
        Movimento movimento = new Movimento();
        System.out.println("\n++++++ Inserção de movimento +++++");
        System.out.println("Digite tipo de movimento: ");
        movimento.setTipoMovimento(input.nextInt());
        input.nextLine();
        System.out.println("Digite a data do movimento: ");
        LocalDate data = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        movimento.setDataMovimento(data);
        System.out.println("Digite a hora do movimento: ");
        LocalTime hora = LocalTime.parse(input.nextLine(), DateTimeFormatter.ofPattern("HH:mm:ss"));
        movimento.setHoraMovimento(hora);
        System.out.println("Digite o valor do movimento: ");
        movimento.setValorMovimento(input.nextDouble());
        //
        System.out.println("Contas cadastradas: " + contaComumService.getContaComum());
        System.out.println("Digite o id da conta para o movimento: ");
        Contacomum contacomum = contaComumService.getContaComumById(input.nextLong());
        if (contacomum == null) {
            System.out.println("Código inválido.");
        } else {
            movimento.setContacomum(contacomum);
            System.out.println("Movimento salvo com sucesso: " + movimentoService.insert(movimento));
        }


    }
    private static void atualizar() {
        System.out.println("\n++++++ Alterar um movimento ++++++");
        Movimento movimento;
        int opcao = 0;
        do {
            System.out.print("\nDigite o código do movimento (Zero p/sair): ");
            long codigo = input.nextLong();
            input.nextLine();
            if (codigo == 0) {
                opcao = 0;
            } else {
                movimento = movimentoService.getMovimentoById(codigo);
                if (movimento == null) {
                    System.out.println("Código inválido.");
                } else {
                    System.out.println("Numero movimento: " + movimento.getIdMovimento());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.println("Digite o novo valor do movimento: ");
                        movimento.setValorMovimento(input.nextDouble());
                    }
                    System.out.println("Data: " + movimento.getDataMovimento());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.print("Digite a nova data: ");
                        LocalDate data = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        movimento.setDataMovimento(data);
                    }
                    System.out.println("Hora: " + movimento.getHoraMovimento());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.println("Digite a hora do movimento: ");
                        LocalTime hora = LocalTime.parse(input.nextLine(), DateTimeFormatter.ofPattern("HH:mm:ss"));
                        movimento.setHoraMovimento(hora);
                    }
                    if(movimentoService.update(movimento) != null) {
                        System.out.println("movimento atualizado com sucesso. " + movimentoService.getMovimentoById(movimento.getIdMovimento()));
                    } else {
                        System.out.println("Não foi possível atualizar este movimento. Por favor, contate o administrador.");
                    }

                    opcao = 1;
                }
            }
        } while (opcao != 0);
    }
    private static void excluir(){
        System.out.println("\n+++++ Excluir um movimento ++++++");
        Movimento movimento;
        int opcao = 0;
        do {
            System.out.println("\nDigite o codigo do movimento (Zero p/sair)");
            Long codigo = input.nextLong();
            input.nextLine();
            if(codigo == 0) {
                opcao = 0;
            } else if (codigo > 0){
                movimento = movimentoService.getMovimentoById(codigo);
                if (movimento == null){
                    System.out.println("Código invalido.");
                } else {
                    System.out.println(movimento);
                    System.out.println("Excluir este movimento? (0-sim/1-não)");
                    if (input.nextInt() == 0){
                        input.nextLine();
                        movimentoService.delete(movimento.getIdMovimento());
                        System.out.println("Movimento excluida com sucesso.");
                    }
                }
            } else {
                System.out.println("Digite um codigo valido!!!");
            }
        } while (opcao != 0);
    }
    private static void selectMovimentos() {
        System.out.println("\nLista todos os movimentos no banco de dados:\n" + movimentoService.getMovimentos());
    }

    private static void selectMovimentosById() {
        System.out.print("\nDigite o código do movimento: ");
        Movimento movimento = movimentoService.getMovimentoById(input.nextLong());
        input.nextLine();
        if (movimento != null) {
            System.out.println(movimento);
        } else {
            System.out.println("Código não localizado.");
        }
    }
}

