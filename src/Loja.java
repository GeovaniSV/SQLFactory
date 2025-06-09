public class Loja extends SQLClass {
    @Key
    protected int id;

    protected String nome;
    protected String endereco;
    protected String telefone;
    protected String cnpj;

    Loja() {
        this.setTableName("LOJAS");
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCnpj() {
        return cnpj;
    }
}
