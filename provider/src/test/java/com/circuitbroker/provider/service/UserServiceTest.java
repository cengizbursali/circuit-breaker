package com.circuitbroker.provider.service;

import com.circuitbroker.provider.exception.UserNotFoundException;
import com.circuitbroker.provider.model.User;
import com.circuitbroker.provider.model.enums.Profession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;


@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Test
    public void it_should_get_user_by_id() {
        // When
        User user = userService.getUserById(1);

        // Then
        assertThat(user.getName()).isEqualTo("Cengiz");
        assertThat(user.getSurname()).isEqualTo("Bursalioglu");
        assertThat(user.getProfession()).isEqualTo(Profession.ENGINEER);
    }

    @Test
    public void it_should_throw_exception_when_user_not_found() {
        // When
        Throwable throwable = catchThrowable(() -> userService.getUserById(99));

        // Then
        assertThat(throwable).isInstanceOf(UserNotFoundException.class);
        UserNotFoundException exception = (UserNotFoundException) throwable;
        assertThat(exception.getMessage()).isEqualTo("User not found");
    }
}
