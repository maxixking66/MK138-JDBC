package ir.maktabsharif138.jdbc.domains;

//  T, E, K, V, U, S
public class BaseEntity<T> {

    private T id;

    public void setId(T id) {
        this.id = id;
    }

    public T getId() {
        return this.id;
    }

}
