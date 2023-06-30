package com.example.tennis.service.impl.userService;

import com.example.tennis.converter.UserDtoToEntity;
import com.example.tennis.dto.UserDto;
import com.example.tennis.exception.NullFieldException;
import com.example.tennis.repository.UserRepository;
import com.example.tennis.service.impl.UserServiceImpl;
import com.example.tennis.validation.UserValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTestWithMock {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserValidator userValidator;

    @Mock
    private UserDtoToEntity userDtoToEntity;

    @Test
    void shouldThrowException_whenUserIsUpdated_withNullEmail() throws Exception {

        // given
        UserDto userDto = UserDto.builder()
                .withFirstName("Martyna")
                .withLastName("Pra")
                .withEmail("")
                .withPhoneNumber("123456789")
                .build();

        when(this.userValidator.isValid(userDto)).thenThrow(new NullFieldException("email"));

        // when
        NullFieldException ex = assertThrows(NullFieldException.class, () -> this.userService.updateUser(userDto,1L));

        assertEquals("The required field is null: email", ex.getMessage());
    }

}
