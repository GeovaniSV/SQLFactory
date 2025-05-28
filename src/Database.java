import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
     private static Connection connect() {
         String url = "jdbc:sqlite:db\\data.db"; //Define a url do banco SQLite. Online ou local
         Connection connection = null;

         try {
             connection = DriverManager.getConnection(url);

         } catch (SQLException e) {
             e.printStackTrace();
         }
         return connection;
     }

     /*
     * Usa o DriverManager.getConnection(url) para abrir a conexão.
     * Se der algum erro, imprime o erro com e.printStackTrace().
     * Retorna o Connection - null se deu errado e ok se deu tudo ok.*/


    public static boolean executeSQL(String sql) {
        //Executa um comando SQL no banco SQLite
        boolean ok = false;

        //Chama o método connect() para abrir uma conexão com o banco.
        Connection currentConnection = connect();

        try {
            //Usa currentConnection.createStatement() para criar um objeto que executa comandos SQL.
            Statement statement = currentConnection.createStatement();
            statement.execute(sql); //executa o sql passado como parâmetro
            currentConnection.close(); //Fecha a conexão
            ok = true;
        } catch (SQLException e) {
            e.printStackTrace();
            ok = false;
        }
        return ok; //Retorna true se deu certo, ou false se deu erro.
    }

    /*
    * As funções abaixo fazer as seguintes ações:
    * -Inserir um objeto no banco de dados;
    * -Atualizar um objeto no banco de dados
    * -Deletar um objeto no banco de dados
    * -Buscar um objeto no banco a partir do ID
    *
    * Tudo isso usando uma classe genérica SQLClass, que representa qualquer entidade persistível (como Produto, Estoque, etc.);
    * Todos os três métodos usam o executeSQL() para enviar comandos SQL*/

    public static boolean inserirRegistro(SQLClass registro){
        //Gera a string SQL com insertSQL() (ex: INSERT INTO produtos (...) VALUES (...))
        //Executa usando o método executeSQL() / Retorna true se deu certo, false se deu erro

        return executeSQL(registro.insertSQL());
    }

    public static boolean atualizarRegistro(SQLClass registro){
        //Atualiza um objeto no banco de dados usando seu ID
        return executeSQL((registro.updateSQL()));
    }

    public static boolean deletarRegistro(SQLClass registro) {
        //Deleta o registro do banco, também usando seu ID.
        return executeSQL(registro.deleteSQL());
    }

    //Esse método busca no banco o registro com o id passado e preenche o objeto registro com os dados retornados.
    public static boolean abrirID(SQLClass registro, int id) {
        //obtém os campos da classe
        Field[] fields = registro.getClass().getDeclaredFields();
        boolean ok = false;

        //conecta no banco e faz a consulta:
        Connection currentConnection = connect();
        try {
            //executa a query e recebe os resultados:
            PreparedStatement stmt = currentConnection.prepareStatement(registro.selectSQL() + " where id = " + id);
            ResultSet resultSet = stmt.executeQuery();

            //percorre os campos da classe:
            for(Field field : fields) {
                //Se for string, usa get String
                if(field.getType() == String.class) {
                    field.set(registro, resultSet.getString(field.getName())); //preenche os valores do objeto
                } else {
                    field.set(registro, resultSet.getInt(field.getName())); //Preenche os valores do objetto
                }
                ok = true;

                currentConnection.close(); //Fecha a conexão e retorna true se deu tudo certo
            }
        } catch (Exception e) {
            e.printStackTrace();
            ok = false;
        }
        return ok;
    }
}
