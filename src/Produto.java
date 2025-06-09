public class Produto extends SQLClass{
    @Key
    protected int id; //identifica o produto no banco(Chave primaria)

    protected String descricao;
    protected double preco;
    protected String um; //unidade de medida

    Produto() {
        //Define o nome da tabela como 'produtos' para que os metodos da SQLClass saibam para onde gerar os comandos SQL
        this.setTableName("PRODUTOS");
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setUm(String um) {
        this.um = um;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public String getUm() {
        return um;
    }
}

/*
* A classe Produto herda da classe base SQLClass, que já possui:
* - Métodos para gerar SQL (insertSQL, updateSQL, etc...)
* - Lógica de reflexão para ler campos e valores
* - Suporte para a anotação @Key*/