package ir.maktabsharif138.jdbc.dto;

public class UserProfileDTO {

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserProfileDTO{" +
               "age=" + age +
               '}';
    }

    //    private String firstName;
//
//    private String lastName;

}
