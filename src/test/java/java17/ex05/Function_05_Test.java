package java17.ex05;

import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;

import java17.data.Data;
import java17.data.Person;

/**
 * Exercice 5 - java.util.function.Consumer
 */
public class Function_05_Test {

    //tag::functions[]
    // TODO compléter la fonction
    // TODO modifier le mot de passe en "secret"
    Consumer<Person> changePasswordToSecret = pass -> {
        pass.setPassword("secret");
    };

    // TODO compléter la fonction
    // TODO vérifier que l'age > 4 avec une assertion JUnit
    Consumer<Person> verifyAge = years -> {
        assert years.getAge() > 4;
    };

    // TODO compléter la fonction
    // TODO vérifier que le mot de passe est "secret" avec une assertion JUnit
    Consumer<Person> verifyPassword = pass -> {
        assert pass.getPassword().equals("secret");
    };
    //end::functions[]


    @Test
    public void test_consumer() throws Exception {
        List<Person> personList = Data.buildPersonList();

        // TODO invoquer la méthode personList.forEach pour modifier les mots de passe en "secret"
        // personList.forEach...
        personList.forEach(changePasswordToSecret);
        // TODO remplacer la boucle for par l'invocation de la méthode forEach
        // TODO Utiliser la méthode andThen pour chaîner les vérifications verifyAge et verifyPassword
        // personList.forEach...
        for(Person p : personList) {
            verifyAge.andThen(verifyPassword).accept(p);

        }
    }
}