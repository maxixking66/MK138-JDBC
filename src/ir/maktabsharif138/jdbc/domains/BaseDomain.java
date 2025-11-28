package ir.maktabsharif138.jdbc.domains;

public class BaseDomain {

    private Integer id;

    public BaseDomain() {
    }

    public BaseDomain(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
