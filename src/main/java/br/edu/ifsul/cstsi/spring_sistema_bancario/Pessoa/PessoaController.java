package br.edu.ifsul.cstsi.spring_sistema_bancario.Pessoa;


import java.util.Scanner;

import br.edu.ifsul.cstsi.spring_sistema_bancario.ContaComum.Contacomum;
import org.springframework.stereotype.Controller;

@Controller
public class PessoaController {
    private static final Scanner input = new Scanner(System.in);
    private static PessoaService PessoaService;

    //Injeção de dependência (Não utilizou @Autowired porque o Springboot não injeta a dependência. Afinal, estamos adaptando um framework web para modo texto)
    public PessoaController(PessoaService PessoaService) {

        PessoaController.PessoaService = PessoaService;
    }

    public static void main(String[] args) {

        int opcao;
        do {
            System.out.print("\n\"-------  MENU Pessoa -------\"");
            System.out.print(
                    """
                        
                        
                        1. Inserir nova Pessoa
                        2. Atualizar uma Pessoa
                        3. Excluir uma Pessoa
                        4. Listar todas as Pessoas
                        5. Buscar Pessoa pelo código
                        6. Buscar Pessoa pelo nome
                        Opção (Zero p/sair):\s""");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1 -> inserir();
                case 2 -> atualizar();
                case 3 -> excluir();
                case 4 -> selectPessoas();
                case 5 -> selectPessoasById();
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
        Pessoa p1 = new Pessoa();
        System.out.println("\n++++++ Cadastro de nova pessoa ++++++");
        System.out.print("Digite o seu nome: ");
        p1.setNomePessoa(input.nextLine());
       System.out.print("\nDigite o endereco: ");
       p1.setEnderecoPessoa(input.nextLine());
       System.out.print("\nDigite o cep: ");
       p1.setCepPessoa("dsadasdasdsaads1");
       p1.setTelefonePessoa("98432433");
       p1.setRendaPessoa(2000.20);
       p1.setSituacaoPessoa(1);
       p1.setCpfPessoa("0522-333-222");
       p1.setRgPessoa("33333");
       p1.setIdadePessoa(30);
       p1.setCnpjPessoa("4322222");
      //  LocalDate dataFechamento = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
      //  cc1.setFechamentoConta(dataFechamento);
     //   cc1.setSituacaoConta(1);
      //  System.out.print("\nDigite a senha da conta: ");
      //  cc1.setSenhaConta(Integer.valueOf(input.nextLine()));
      //  System.out.print("\nsaldo: ");
      //  cc1.setSaldoConta(Integer.valueOf(input.nextLine()));
      //  cc1.setLimiteConta(1000.00);
      //  System.out.print("\nanive: ");
      //  LocalDate aniversario = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
       // cc1.setAniversarioConta(aniversario);
        System.out.println("pessoa cadastrada:" + PessoaService.insert(p1) );
        System.out.println(p1);
    }
    private static void atualizar() {
        System.out.println("\n++++++ Alterar uma Pessoa ++++++");
        Pessoa pessoa;
        int opcao = 0;
        do {
            System.out.print("\nDigite o código da pessoa (Zero p/sair): ");
            long codigo = input.nextLong();
            input.nextLine();
            if (codigo == 0) {
                opcao = 0;
            } else {
                pessoa = PessoaService.getPessoaById(codigo);
                if (pessoa == null) {
                    System.out.println("Código inválido.");
                } else {
                    System.out.println("Nome: " + pessoa.getNomePessoa());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.println("Novo nome: ");
                        pessoa.setNomePessoa(input.nextLine());
                    }
                    System.out.println("idade: " + pessoa.getIdadePessoa() );
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                      input.nextLine();
                    System.out.print("Digite a nova idade: ");
                      pessoa.setIdadePessoa(input.nextInt());
                    }
                    if(PessoaService.update(pessoa) != null) {
                        System.out.println("Pessoa atualizada com sucesso. " + PessoaService.getPessoaById(pessoa.getIdPessoa()));
                    } else {
                        System.out.println("Não foi possível atualizar esta pessoa. Por favor, contate o administrador.");
                    }
                    opcao = 1;
                }
            }
        } while (opcao != 0);
    }
    private static void excluir() {
        System.out.println("\n++++++ Excluir uma pessoa ++++++");
        Pessoa pessoa;
        int opcao = 0;
        do {
            System.out.print("\nDigite o código da pessoa (Zero p/sair): ");
            Long codigo = input.nextLong();
            input.nextLine();
            if (codigo == 0) {
                opcao = 0;
            } else if (codigo > 0) {
                pessoa = PessoaService.getPessoaById(codigo);
                if (pessoa == null) {
                    System.out.println("Código inválido.");
                } else {
                    System.out.println(pessoa);
                    System.out.print("Excluir esta pessoa? (0-sim/1-não) ");
                    if (input.nextInt() == 0) {
                        input.nextLine();
                        PessoaService.delete(pessoa.getIdPessoa());
                        System.out.println("Pessoa excluída:" + pessoa);
                    }

                }
            } else {
                System.out.println("Digite um código válido!!!");
            }
        } while (opcao != 0);
    }

    private static void selectPessoas() {
        System.out.println("\nLista todas as pessoas no banco de dados:\n" + PessoaService.getPessoa());
    }

    private static void selectPessoasById() {
        System.out.print("\nDigite o código da pessoa: ");
        Pessoa pessoa = PessoaService.getPessoaById(input.nextLong());
        input.nextLine();
        if (pessoa != null) {
            System.out.println(pessoa);
        } else {
            System.out.println("Código não localizado.");
        }
    }

}
