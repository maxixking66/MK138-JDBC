package ir.maktabsharif138.jdbc.util;

import java.util.Collection;

public class CollectionUtils {

    private CollectionUtils() {
    }

    public static <T> T addAndReturn(T element, Collection<T> tCollection) {
        tCollection.add(element);
        return element;
    }

    public <T> T addAndReturnNonStatic(T element, Collection<T> tCollection) {
        tCollection.add(element);
        return element;
    }

    /*public static Collection<String> addAndReturnCollection(String o, Collection<String> c) {
        c.add(o);
        return c;
    }

    public static Collection<Integer> addAndReturnCollection(Integer o, Collection<Integer> c) {
        c.add(o);
        return c;
    }

    public static Collection<Long> addAndReturnCollection(Long o, Collection<Long> c) {
        c.add(o);
        return c;
    }*/

}
