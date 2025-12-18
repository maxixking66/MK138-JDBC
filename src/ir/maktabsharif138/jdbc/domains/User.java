package ir.maktabsharif138.jdbc.domains;

public class User extends BaseDomain {

    public static final String TABLE_NAME = "tbl_users";

    public static final String USERNAME_COLUMN = "username";
    public static final String AGE_COLUMN = "age";

    private String username;

    private Integer age;

    private Boolean isActive;

    private String primaryMobileNumber;

    private String secondaryMobileNumber;

    public User() {
        super();
    }

    public User(Integer id) {
        super();
        setId(id);
    }

//    public User(Integer age) {
//        this.age = age;
//    }

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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public User setIsActive(Boolean active) {
        this.isActive = active;
        return this;
    }

    public String getPrimaryMobileNumber() {
        return primaryMobileNumber;
    }

    public void setPrimaryMobileNumber(String primaryMobileNumber) {
        this.primaryMobileNumber = primaryMobileNumber;
    }

    public String getSecondaryMobileNumber() {
        return secondaryMobileNumber;
    }

    public void setSecondaryMobileNumber(String secondaryMobileNumber) {
        this.secondaryMobileNumber = secondaryMobileNumber;
    }
}
