package ir.maktabsharif138.jdbc;

import ir.maktabsharif138.jdbc.domains.User;
import ir.maktabsharif138.jdbc.dto.UserProfileDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class JDBCApplication {

    static void main() {

        List<User> users = new ArrayList<>();
        users.add(new User(1));
        users.add(new User(12));
        users.add(new User(123));

        List<UserProfileDTO> profileDTOList = new ArrayList<>();

        Function<User, UserProfileDTO> userToProfileDTOFunction = (User methodInput) -> {
            UserProfileDTO dto = new UserProfileDTO();
            dto.setAge(methodInput.getAge());
            return dto;
        };

        for (User user : users) {
            profileDTOList.add(userToProfileDTOFunction.apply(user));
        }

        System.out.println(profileDTOList);

    }
}