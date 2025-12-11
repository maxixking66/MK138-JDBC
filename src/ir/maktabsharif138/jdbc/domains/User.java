package ir.maktabsharif138.jdbc.domains;

public class User extends BaseDomain {

    public static final String TABLE_NAME = "tbl_users";

    public static final String USERNAME_COLUMN = "username";
    public static final String AGE_COLUMN = "age";

    private String username;

    private Integer age;

    public User() {
        super();
    }

    public User(Integer age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
               "id=" + getId() +
               ", username='" + username + '\'' +
               ", age=" + age +
               '}';
    }
}
