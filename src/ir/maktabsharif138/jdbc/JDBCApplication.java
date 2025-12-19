package ir.maktabsharif138.jdbc;

import java.util.ArrayList;
import java.util.List;

public class JDBCApplication {

    static void main() {
        List<A> aList = new ArrayList<A>();

        List<B> bList = new ArrayList<B>();

        process(aList);

        process(bList);

        printElementsOfCollection(aList);
        printElementsOfCollection(bList);

    }

    static void printElementsOfCollection(List<?> objects) {
        for (Object object : objects) {
            System.out.println(object);
        }
    }

    static void process(List<? extends A> aList) {
        for (A a : aList) {
            a.test();
        }
    }

    static void insert(List<? super A> aList) {
        aList.add(new A());
        aList.add(new B());
        aList.add(new C());

        Object object = aList.get(0);
    }

//    static void process(List<? extends A> list) {
//        for (A a : list) {
//            a.test();
//        }
//    }
}

class X {

}

class A extends X {
    public void test() {
    }
}

class B extends A {
}

class C extends A {
}

