import javax.xml.crypto.Data;
import java.util.Scanner;

public class SQLFactory {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Produto produto = new Produto();
        Pessoa pessoa = new Pessoa();
        Loja loja = new Loja();

        boolean continuar = true;

do {
    System.out.println("Deseja entrar em qual tabela?");
    System.out.println("[ 1 ] PRODUTOS");
    System.out.println("[ 2 ] PESSOAS");
    System.out.println("[ 3 ] LOJAS");
    System.out.println("[ 4 ] SAIR");
    int resposta =  scanner.nextInt();

    switch (resposta) {
        case 1:
            System.out.println("Entrou na tabela PRODUTOS!");
            System.out.println("<----------------------------------->");
            System.out.println("O que deseja fazer na tabela?");
            System.out.println("[ 1 ] INSERIR UM REGISTRO");
            System.out.println("[ 2 ] ALTERAR UM REGISTRO");
            System.out.println("[ 3 ] DELETAR UM REGISTRO");
            resposta = scanner.nextInt();
            switch (resposta) {
                case 1:
                    int id;
                    String descricao;
                    double preco;
                    String um;
                    System.out.println("Qual o ID do produto? *Lembrando que não é possível ter o mesmo ID em dois registros diferentes");
                    id = scanner.nextInt();
                    produto.setId(id);

                    System.out.println("Digite a descrição do produto, ex: Café 500g ");
                    scanner.nextLine();
                    descricao = scanner.nextLine();
                    produto.setDescricao(descricao);

                    System.out.println("Digite o preço do produto: ");
                    preco = scanner.nextDouble();
                    produto.setPreco(preco);

                    System.out.println("Qual a unidade de medida do produto? Cx, pct, Pç, Kg, Lta, etc...");
                    scanner.nextLine();
                    um = scanner.nextLine();
                    produto.setUm(um);

                    Database.inserirRegistro(produto);
                    break;
                case 2:
                    System.out.println("Digite o ID do produto que deseja alterar: ");
                    id = scanner.nextInt();
                    Database.abrirID(produto, id);

                    System.out.println("Digite a descrição do produto: ");
                    scanner.nextLine();
                    descricao = scanner.nextLine();
                    produto.setDescricao(descricao);

                    System.out.println("Digite o preço do produto: ");
                    preco = scanner.nextDouble();
                    produto.setPreco(preco);

                    System.out.println("Qual a unidade de medida do produto? Cx, pct, Pç, Kg, Lta, etc...");
                    scanner.nextLine();
                    um = scanner.nextLine();
                    produto.setUm(um);

                    Database.atualizarRegistro(produto);
                    break;
                case 3:
                    System.out.println("Qual o ID do registro que deseja deletar?");
                    id = scanner.nextInt();
                    produto.setId(id);
                    Database.deletarRegistro(produto);
                    System.out.println("Deletado com sucesso");
                    break;

                default:
                    System.out.println("Opção não encontrada!");
                    continue;

            }
            break;
        case 2:
            System.out.println("Entrou tabela PESSOAS!");
            System.out.println("<----------------------------------->");
            System.out.println("O que deseja fazer na tabela?");
            System.out.println("[ 1 ] INSERIR UM REGISTRO");
            System.out.println("[ 2 ] ALTERAR UM REGISTRO");
            System.out.println("[ 3 ] DELETAR UM REGISTRO");
            resposta = scanner.nextInt();
            switch (resposta) {
                case 1:
                    int id = 0;
                    String nome;
                    String sobrenome;
                    String cpf;
                    System.out.println("Qual o ID da pessoa? *Lembrando que não é possível ter o mesmo ID em dois registros diferentes");
                    id = scanner.nextInt();
                    pessoa.setId(id);

                    System.out.println("Digite o nome da pessoa:  ");
                    scanner.nextLine();
                    nome = scanner.nextLine();
                    pessoa.setNome(nome);

                    System.out.println("Digite o sobrenome: ");
                    sobrenome = scanner.nextLine();
                    pessoa.setSobrenome(sobrenome);

                    System.out.println("Digite o CPF: ");
                    cpf = scanner.nextLine();
                    pessoa.setCpf(cpf);

                    Database.inserirRegistro(pessoa);
                    break;
                case 2:
                    System.out.println("Digite o ID da pessoa que deseja alterar: ");
                    id = scanner.nextInt();
                    Database.abrirID(pessoa, id);

                    System.out.println("Digite a novo nome da pessoa: ");
                    scanner.nextLine();
                    nome = scanner.nextLine();
                    pessoa.setNome(nome);

                    System.out.println("Digite o novo sobrenome: ");
                    sobrenome = scanner.nextLine();
                    pessoa.setSobrenome(sobrenome);

                    System.out.println("Digite o novo CPF: ");
                    cpf = scanner.nextLine();
                    pessoa.setCpf(cpf);

                    Database.atualizarRegistro(pessoa);
                    break;
                case 3:
                    System.out.println("Qual o ID do registro que deseja deletar?");
                    id = scanner.nextInt();
                    pessoa.setId(id);
                    Database.deletarRegistro(pessoa);
                    System.out.println("Deletado com sucesso");
                    break;

                default:
                    System.out.println("Opção não encontrada!");
                    continue;

            }
            break;

        case 3:
            System.out.println("Entrou na tabela LOJAS!");
            System.out.println("<----------------------------------->");
            System.out.println("O que deseja fazer na tabela?");
            System.out.println("[ 1 ] INSERIR UM REGISTRO");
            System.out.println("[ 2 ] ALTERAR UM REGISTRO");
            System.out.println("[ 3 ] DELETAR UM REGISTRO");
            resposta = scanner.nextInt();
            switch (resposta) {
                case 1:
                    int id;
                    String nome;
                    String endereco;
                    String telefone;
                    String cnpj;
                    System.out.println("Qual o ID da LOJA? *Lembrando que não é possível ter o mesmo ID em dois registros diferentes");
                    id = scanner.nextInt();
                    loja.setId(id);

                    System.out.println("Digite o nome da loja: ");
                    scanner.nextLine();
                    nome = scanner.nextLine();
                    loja.setNome(nome);

                    System.out.println("Digite o endereço da loja: ");
                    endereco = scanner.nextLine();
                    loja.setEndereco(endereco);

                    System.out.println("Digite o telefone da loja: ");
                    telefone = scanner.nextLine();
                    loja.setTelefone(telefone);

                    System.out.println("Digite o cnpj da loja: ");
                    cnpj = scanner.nextLine();
                    loja.setCnpj(cnpj);

                    Database.inserirRegistro(loja);
                    break;
                case 2:
                    System.out.println("Digite o ID da LOJA que deseja alterar: ");
                    id = scanner.nextInt();
                    Database.abrirID(loja, id);

                    System.out.println("Digite o novo nome da loja: ");
                    scanner.nextLine();
                    nome = scanner.nextLine();
                    loja.setNome(nome);

                    System.out.println("Digite o novo endereço da loja: ");
                    endereco = scanner.nextLine();
                    loja.setEndereco(endereco);

                    System.out.println("Digite o novo telefone da loja: ");
                    telefone = scanner.nextLine();
                    loja.setTelefone(telefone);

                    System.out.println("Digite o novo CNPJ da loja: ");
                    cnpj = scanner.nextLine();
                    loja.setCnpj(cnpj);

                    Database.atualizarRegistro(loja);
                    break;
                case 3:
                    System.out.println("Qual o ID do registro que deseja deletar?");
                    id = scanner.nextInt();
                    produto.setId(id);
                    Database.deletarRegistro(loja);
                    System.out.println("Deletado com sucesso");
                    break;

                default:
                    System.out.println("Opção não encontrada!");
                    continue;

            }
            break;

        case 4:
            break;

        default:
            System.out.println("Opção não encontrada!");
            break;

    }

    System.out.println("Deseja sair?");
    System.out.println("[ 1 ] SIM");
    System.out.println("[ 2 ] NÃO");
    resposta = scanner.nextInt();

    switch (resposta) {
        case 1:
            System.out.println("Para continuar a usar o SQLFactory, execute o código novamente!");
            continuar = false;
            break;
        case 2:
            continuar = true;
            continue;
        default:
            System.out.println("Opção não encontrada!");
    }
} while(continuar);

//
//        pessoa.setId(1);
//        pessoa.setNome("Geovani");
//        pessoa.setSobrenome("Dos Santos Vargas");
//        pessoa.setCpf("70988666544");//cpf ficticio, ou não, so joguei numeros aleatórios
//
//        Database.inserirRegistro(pessoa);
//        Database.abrirID(pessoa, 1);
//        System.out.println("ID: " + pessoa.getId());

//        pessoa.setId(1);
//        pessoa.setCpf("78545612355");
//        pessoa.setNome("Carlinhos");
//        pessoa.setSobrenome("Maia");
//
//        Database.atualizarRegistro(pessoa);
//
//        Database.deletarRegistro(pessoa);


//        loja.setId(1);
//        loja.setNome("4Estações Vasos & Acessórios");
//        loja.setEndereco("Av. Jacarandás, 5077 - Jardim Primaveras");
//        loja.setTelefone("(66)99678-2254");
//        loja.setCnpj("31571209000139");

//        Database.inserirRegistro(loja);

//        loja.setId(1);
//        loja.setNome("Machados Primaveras");
//        loja.setTelefone("(66)99999-9999");
//        loja.setCnpj("999999990000199");
//        loja.setEndereco("Av. Dos Mercados, 7856 - Mercadolândia");
//
//        Database.atualizarRegistro(loja);
//
//        Database.deletarRegistro(loja);
    }
}
