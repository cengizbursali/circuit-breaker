package com.circuitbroker.provider.service;

import com.circuitbroker.provider.exception.UserNotFoundException;
import com.circuitbroker.provider.model.User;
import com.circuitbroker.provider.model.enums.Profession;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    private static final List<User> USER_LIST;

    static {
        USER_LIST = new ArrayList<>();
        USER_LIST.add(new User(1, "Cengiz", "Bursalioglu", Profession.ENGINEER));
        USER_LIST.add(new User(2, "Sedatcan", "Sonat", Profession.SOLDIER));
        USER_LIST.add(new User(3, "Yilmaz", "Demir", Profession.TEACHER));
        USER_LIST.add(new User(4, "Ekrem", "Pinar", Profession.DOCTOR));
        USER_LIST.add(new User(5, "Mehmet", "Demircan", Profession.SOLDIER));
        USER_LIST.add(new User(6, "Selcan", "Gulec", Profession.TEACHER));
        USER_LIST.add(new User(7, "Hasan", "Efe", Profession.ENGINEER));
        USER_LIST.add(new User(9, "Gokcan", "Ustun", Profession.DOCTOR));
    }

    public User getUserById(Integer id) {
        return USER_LIST.stream()
                .filter(user -> Objects.equals(user.getUserId(), id))
                .findAny()
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }
}
