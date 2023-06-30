package com.example.tennis.service.impl.userService;

import com.example.tennis.dto.UserDto;
import com.example.tennis.exception.InvalidFieldLengthException;
import com.example.tennis.exception.NullFieldException;
import com.example.tennis.repository.UserRepository;
import com.example.tennis.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldThrowException_whenUserIsAdded_withNullFirstName() throws Exception {
        // given
        UserDto userDto = UserDto.builder()
                .withFirstName("")
                .withLastName("Pradela")
                .withEmail("praf@gmail.com")
                .withPhoneNumber("1234567899")
                .build();

        // when
        NullFieldException ex = assertThrows(NullFieldException.class, () -> this.userService.saveUser(userDto));
        assertEquals("The required field is null: firstName", ex.getMessage());
    }

    @Test
    void shouldThrowException_whenUserIsAdded_withLessThanMinPhoneLength() throws Exception {
        // given
        UserDto userDto = UserDto.builder()
                .withFirstName("Martyna")
                .withLastName("Pradela")
                .withEmail("praf@gmail.com")
                .withPhoneNumber("12399")
                .build();

        // when
        InvalidFieldLengthException ex = assertThrows(InvalidFieldLengthException.class, () -> this.userService.saveUser(userDto));
        assertEquals("Invalid field length, the min length is: 9", ex.getMessage());
    }

    @Test
    void shouldThrowException_whenClientIsUpdated_withNulLEmail() throws Exception {
        // given
        UserDto clientToSave = UserDto.builder()
                .withFirstName("Martyna")
                .withLastName("Pra")
                .withEmail("")
                .withPhoneNumber("123456789")
                .build();
        // when
        NullFieldException ex = assertThrows(NullFieldException.class, () -> this.userService.updateUser(clientToSave,1L));
        assertEquals("The required field is null: email", ex.getMessage());
    }


}
