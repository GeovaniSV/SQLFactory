import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public abstract class SQLClass {
    private String tableName;
    private String fildsList;
    private String valuesList;
    private String fieldValuesList;

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getValueKey() {
        //usa o método getKey() para descobrir qual o campo é a chave.
        //Acessa esse campo via reflection.
        //Le o valor atual dele no objeto
        //Converte esse valor para int e retorna.
        int keyValue = 0;
        try {
            Object value = this.getClass().getDeclaredField(this.getKey()).get(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return keyValue;
    }

    public String getKey() {
        //Vasculha todos os atributos da classe atual
        Field[] fields = this.getClass().getDeclaredFields();

        String keyName = "";

        for (Field field : fields) {
            if(field.isAnnotationPresent(Key.class)){
                keyName = field.getName();
            }
        }

        return keyName;
    }

    protected void listFields(){
        //Monta duas strings
        //Uma com os nomes dos campos

        Field[] fields = this.getClass().getDeclaredFields();

        String fieldString = "";
        String valuesString = "";

        for (Field field : fields) {
            fieldString = fieldString + ", " + field.getName();

            String fieldValue = "";
            try {
                fieldValue = FixFieldType(field);
            } catch (Exception e) {
                e.printStackTrace();
            }

            valuesString = valuesString + ", " + fieldValue;
        }

        this.fildsList = fieldString.substring(1);
        this.valuesList = valuesString.substring(1);
    }

    private String FixFieldType(Field field) throws Exception {
        //Acessa o valor do campo recebido via reflection
        //Se for uma String, adiciona aspas simples
        //Se for outro tipo, apenas transforma em texto
        //Retorna o valor como uma string
        String value = "";
        Object valueObject = field.get(this);

        if(field.getType() == String.class) {
            value = value + "'" + valueObject + "'";
        } else {
            value = value + valueObject;
        }

        return value;
    }

    protected void listFieldsValues() {

        Field[] fields = this.getClass().getDeclaredFields();

        String fieldsValuesString = "";

        for (Field field : fields) {
            String fieldValue = "";
            try {
                fieldValue = FixFieldType(field);
            } catch (Exception e) {
                e.printStackTrace();
            }
            fieldValuesList = fieldValuesList + ", " + field.getName() + ", " + fieldValue;
        }

        this.fieldValuesList = fieldsValuesString.substring(1);
    }

    public String getTableName() {
        return tableName;
    }

    public String selectSQL() {
        return "select * from " + this.tableName;
    }

    public String insertSQL() {
        this.listFields();
        return "insert into " + this.tableName + " (" + this.fildsList + " ) values (" + this.valuesList + ")";
    }

    public String deleteSQL() {
        return "delete from " + this.tableName + " where " + this.getKey() + " = " + this.getValueKey();
    }

    public String updateSQL() {
        this.listFieldsValues();
        return "update " + this.tableName + " set " + this.fieldValuesList + " where " + this.getKey() + " = " + this.getValueKey();
    }


}
