package com.dmadev.spring.intergration.service;

import com.dmadev.spring.database.entity.Role;
import com.dmadev.spring.dto.UserCreateEditDto;
import com.dmadev.spring.dto.UserReadDto;
import com.dmadev.spring.intergration.IntegrationTestBase;
import com.dmadev.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

//@SpringBootTest(classes = ApplicationRunner.class)
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = ApplicationRunner.class,
//initializers = ConfigDataApplicationContextInitializer.class)

@RequiredArgsConstructor
public class UserServiceIT extends IntegrationTestBase {

    private static final Long USER_1 = 1L;
    private static final Integer COMPANY_1=1;


    private UserService userService;

    @Test
    void findAll() {
        List<UserReadDto> result = userService.findAll();
        assertThat(result).hasSize(5);
    }

    @Test
    void findById() {
        Optional<UserReadDto> maybeUser = userService.findById(USER_1);
        assertTrue(maybeUser.isPresent());
        maybeUser.ifPresent(user -> assertEquals("ivan@gmail.com", user.getUsername()));
    }

    @Test
    void create() {
        UserCreateEditDto userDTO = new UserCreateEditDto(
                "test@gmail.com",
                LocalDate.now(),
                "Test",
                "Test",
                Role.ADMIN,
                COMPANY_1
        );
        UserReadDto actualResult = userService.create(userDTO);
        assertEquals(userDTO.getUsername(),actualResult.getUsername());
        assertEquals(userDTO.getBirthDate(),actualResult.getBirthDate());
        assertEquals(userDTO.getFirstname(),actualResult.getFirstname());
        assertEquals(userDTO.getLastname(),actualResult.getLastname());
        assertEquals(userDTO.getCompanyId(),actualResult.getCompany().id());
        assertSame(userDTO.getRole(),actualResult.getRole());

    }

    @Test
    void update(){
        UserCreateEditDto userDTO = new UserCreateEditDto(
                "test@gmail.com",
                LocalDate.now(),
                "Test",
                "Test",
                Role.ADMIN,
                COMPANY_1
        );

        Optional<UserReadDto> actualResult = userService.update(USER_1, userDTO);
        assertTrue(actualResult.isPresent());
        actualResult.ifPresent(user->{
            assertEquals(userDTO.getUsername(),user.getUsername());
            assertEquals(userDTO.getBirthDate(),user.getBirthDate());
            assertEquals(userDTO.getFirstname(),user.getFirstname());
            assertEquals(userDTO.getLastname(),user.getLastname());
            assertEquals(userDTO.getCompanyId(),user.getCompany().id());
            assertSame(userDTO.getRole(),user.getRole());
        });
    }

    @Test
    void delete(){
        boolean result = userService.delete(USER_1);
        boolean resultWrong= userService.delete(2L);
        assertTrue(result);
        assertFalse(resultWrong);
    }

}




