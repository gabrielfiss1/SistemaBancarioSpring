package br.edu.ifsul.cstsi.spring_sistema_bancario.ContaComum;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;


import br.edu.ifsul.cstsi.spring_sistema_bancario.Pessoa.Pessoa;
import br.edu.ifsul.cstsi.spring_sistema_bancario.Pessoa.PessoaService;
import org.springframework.stereotype.Controller;

@Controller
public class ContaComumController {
    private static final Scanner input = new Scanner(System.in);
    private static ContaComumService ContaComumService;
    private static PessoaService PessoaService;

    //Injeção de dependência (Não utilizou @Autowired porque o Springboot não injeta a dependência. Afinal, estamos adaptando um framework web para modo texto)
    public ContaComumController(ContaComumService ContaComumService) {
        ContaComumController.ContaComumService = ContaComumService;
    }

    public static void main(String[] args) {

        int opcao;
        do {
            System.out.print("\n\"-------  MENU Conta -------\"");
            System.out.print(
                    """
    
                        1. Inserir nova Conta
                        2. Atualizar uma Conta
                        3. Excluir uma conta
                        4. Listar todos as Contas
                        5. Buscar contas pelo código
                        6. Buscar contas pelo numero
                        Opção (Zero p/sair):\s""");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1 -> inserir();
                case 2 -> atualizar();
                case 3 -> excluir();
                case 4 -> selectcontas();
                case 5 -> selectContacomumById();
               // case 7 -> selectclientesByNome();
               // case 8 -> selectClientesBySituacao();
                default -> {
                    if (opcao != 0) System.out.println("Opção inválida.");
                }
            }
        } while (opcao != 0);
    }

    //opção 1
    private static void inserir() {
        Contacomum cc1 = new Contacomum();
        System.out.println("\n++++++ Cadastro de nova conta ++++++");
        System.out.print("Digite o numero da conta: ");
        cc1.setNumeroConta(input.nextLine());
        System.out.print("\nDigite a data abertura da conta: ");
        LocalDate dataAbertura = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        cc1.setAberturaConta(dataAbertura);
        //LocalDate dataFechamento = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        cc1.setFechamentoConta(null);
        cc1.setSituacaoConta(1);
        System.out.print("\nDigite a senha da conta: ");
        cc1.setSenhaConta(Integer.valueOf(input.nextLine()));
        System.out.print("\nsaldo da conta: ");
        cc1.setSaldoConta(Integer.valueOf(input.nextLine()));
        cc1.setLimiteConta(1000.00);
        System.out.print("\naniversario da conta: ");
        LocalDate aniversario = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        cc1.setAniversarioConta(aniversario);
        System.out.println("conta criada:" + ContaComumService.insert(cc1));
        System.out.println(cc1);
    }

    //opção 2
    private static void atualizar() {
        System.out.println("\n++++++ Alterar uma Conta ++++++");
        Contacomum contacomum;
        int opcao = 0;
        do {
            System.out.print("\nDigite o código do cliente (Zero p/sair): ");
            long codigo = input.nextLong();
            input.nextLine();
            if (codigo == 0) {
                opcao = 0;
            } else {
                contacomum = ContaComumService.getContaComumById(codigo);
                if (contacomum == null) {
                    System.out.println("Código inválido.");
                } else {
                    System.out.println("Numero: " + contacomum.getNumeroConta());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.println("Digite o numero novo da conta: ");
                        contacomum.setNumeroConta(input.nextLine());
                    }
                    System.out.println("Senha: " + contacomum.getSenhaConta());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.print("Digite a nova senha: ");
                        contacomum.setSenhaConta(input.nextInt());
                    }
                    System.out.println("Saldo: " + contacomum.getSaldoConta());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.print("Digite o novo saldo: ");
                        contacomum.setSaldoConta(input.nextInt());
                    }
                    System.out.println("Deseja fechar a conta?(0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.print("Digite a data do fechamento: ");
                        contacomum.setFechamentoConta(LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));

                        contacomum.setSituacaoConta(0);
                    }
                    if(ContaComumService.update(contacomum) != null) {
                        System.out.println("cliente atualizado com sucesso. " + ContaComumService.getContaComumById(contacomum.getIdConta()));
                    } else {
                       System.out.println("Não foi possível atualizar esta conta. Por favor, contate o administrador.");
                    }

                    opcao = 1;
                }
            }
        } while (opcao != 0);
    }
    private static void excluir() {
        System.out.println("\n++++++ Excluir uma conta ++++++");
        Contacomum contacomum;
        int opcao = 0;
        do {
            System.out.print("\nDigite o código da conta (Zero p/sair): ");
            Long codigo = input.nextLong();
            input.nextLine();
            if (codigo == 0) {
                opcao = 0;
            } else if (codigo > 0) {
                contacomum = ContaComumService.getContaComumById(codigo);
                if (contacomum == null) {
                    System.out.println("Código inválido.");
                } else {
                    System.out.println(contacomum);
                    System.out.print("Excluir esta conta? (0-sim/1-não) ");
                    if (input.nextInt() == 0) {
                        input.nextLine();
                        ContaComumService.delete(contacomum.getIdConta());
                        System.out.println("Conta excluída:" + contacomum);
                    }

                }
            } else {
                System.out.println("Digite um código válido!!!");
            }
        } while (opcao != 0);
    }

    private static void selectcontas() {
        System.out.println("\nLista todas as contas no banco de dados:\n" + ContaComumService.getContaComum());
    }
    private static void selectContacomumById() {
        System.out.print("\nDigite o código da conta: ");
        Contacomum contacomum = ContaComumService.getContaComumById(input.nextLong());
        input.nextLine();
        if (contacomum != null) {
            System.out.println(contacomum);
        } else {
            System.out.println("Código não localizado.");
        }
    }
}
