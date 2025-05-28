import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
//Essa linha define por quanto tempo a anotação @Key estará disponível
//Essa anotação estará disponivel em tempo de execução

@Retention(RetentionPolicy.RUNTIME)
public @interface Key {
    /*
    Essa linha cria uma nova anotação personalizada chamada @Key.
    É como criar uma "etiqueta" que você pode colocar em atributos
    nesse caso, um campo que representa a chave primária
    * */
}