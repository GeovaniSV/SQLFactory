public class Produto extends SQLClass{
    @Key
    int id; //identifica o produto no banco(Chave primaria)

    String descricao;
    double preco;
    String um; //unidade de medida

    Produto() {
        //Define o nome da tabela como 'produtos' para que os metodos da SQLClass saibam para onde gerar os comandos SQL
        this.setTableName("PRODUTOS");
    }
}

/*
* A classe Produto herda da classe base SQLClass, que já possui:
* - Métodos para gerar SQL (insertSQL, updateSQL, etc...)
* - Lógica de reflexão para ler campos e valores
* - Suporte para a anotação @Key*/