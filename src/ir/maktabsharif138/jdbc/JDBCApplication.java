package ir.maktabsharif138.jdbc;

import java.util.List;
import java.util.function.Consumer;

public class JDBCApplication {

    static void main() {

        List<String> words = List.of("a", "b", "c");

        words.forEach(new ToUppercasePrintConsumer());
        words.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s.toLowerCase());
            }
        });
        words.forEach(
                (varname) -> System.out.println(varname.toLowerCase())
        );
        words.forEach(
                (String myVarName) -> System.out.println(myVarName.toLowerCase())
        );
        words.forEach(
                word -> System.out.println(word.toLowerCase())
        );

    }
}

class ToUppercasePrintConsumer implements Consumer<String> {

    @Override
    public void accept(String myVariableName) {
        System.out.println(myVariableName.toLowerCase());
    }
}