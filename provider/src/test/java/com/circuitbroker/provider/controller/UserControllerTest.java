package com.circuitbroker.provider.controller;

import com.circuitbroker.provider.model.User;
import com.circuitbroker.provider.model.enums.Profession;
import com.circuitbroker.provider.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void it_should_get_user_by_id() throws Exception {
        // Given
        User user = new User(1, "Cengiz", "Bursalioglu", Profession.ENGINEER);
        when(userService.getUserById(1)).thenReturn(user);

        // When
        ResultActions resultActions = mockMvc.perform(get("/users/1"));

        // Then
        resultActions.andExpect(status().isOk());
        resultActions.andExpect(jsonPath("$.userId", is(1)));
        resultActions.andExpect(jsonPath("$.name", is("Cengiz")));
        resultActions.andExpect(jsonPath("$.surname", is("Bursalioglu")));
        resultActions.andExpect(jsonPath("$.profession", is("ENGINEER")));
        verify(userService).getUserById(1);
    }
}