package ir.maktabsharif138.jdbc;

import java.util.List;
import java.util.function.Consumer;

public class JDBCApplication {

    static void main() {

        List<String> words = List.of("a", "b", "c");

        words.forEach(new ToUppercasePrintConsumer());
        System.out.println("----------");
        words.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s.toUpperCase());
            }
        });
        System.out.println("----------");
        words.forEach(
                (varname) -> System.out.println(varname.toUpperCase())
        );
        System.out.println("----------");
        words.forEach(
                (String myVarName) -> System.out.println(myVarName.toUpperCase())
        );
        System.out.println("----------");
        words.forEach(
                word -> System.out.println(word.toUpperCase())
        );

    }
}

class ToUppercasePrintConsumer implements Consumer<String> {

    @Override
    public void accept(String myVariableName) {
        System.out.println(myVariableName.toUpperCase());
    }
}