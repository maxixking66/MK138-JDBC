package ir.maktabsharif138.jdbc.domains;

public class Tag extends BaseDomain {

    public static final String TABLE_NAME = "tbl_tag";
    public static final String NAME_COLUMN = "name";

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tag{" +
               "id=" + getId() +
               ", name='" + name + '\'' +
               '}';
    }
}
