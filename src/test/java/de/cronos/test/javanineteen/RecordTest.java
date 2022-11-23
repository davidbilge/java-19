package de.cronos.test.javanineteen;

import static org.assertj.core.api.Assertions.assertThat;

import de.cronos.test.javanineteen.records.User;
import de.cronos.test.javanineteen.records.UserDto;
import de.cronos.test.javanineteen.records.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

/**
 * Since Java 16
 * <a href="https://openjdk.org/jeps/395">JEP 395</a>
 */
@Slf4j
class RecordTest {

    @Test
    void useRecord() {
        User user1 = new User("Max", null, "Mustermann");


        assertThat(user1.toString()).isEqualTo("User[firstName=Max, middleName=null, lastName=Mustermann]");
        assertThat(user1.firstName()).isEqualTo("Max");

        User user2 = new User("Max", null, "Mustermann");
        User user3 = new User("Maria", null, "Mustermann");

        assertThat(user1).isEqualTo(user2);
        assertThat(user1).isNotEqualTo(user3);

        assertThat(user1.getConcatenatedNames()).isEqualTo("Max null Mustermann");

        User user4 = User.builder().firstName("Max").lastName("Mustermann").build();
        assertThat(user4).isEqualTo(user1);
    }

    @Test
    void mapRecord() {
        UserMapper mapper = Mappers.getMapper(UserMapper.class);
        UserDto userDto = mapper.mapUserToUserDto(new User("Max", "Martin", "Mustermann"));

        assertThat(userDto).isEqualTo(new UserDto("Max", "Martin", "Mustermann"));
    }
}
