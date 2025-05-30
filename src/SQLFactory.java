public class SQLFactory {
    public static void main(String[] args) {

        Produto p = new Produto();
        p.id = 1;
        p.descricao = "Café 500g";
        p.preco = 9.90;
        p.um = "pct";



        System.out.println(p.insertSQL());

        Database.inserirRegistro(p);
        System.out.println("Select na table");
        Database.abrirID(p, 1);
        System.out.println("ID: " + p.id);
    }
}
