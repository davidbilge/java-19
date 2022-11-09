package de.cronos.test.javanineteen.records;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {

    @Mapping(target = "zweiterVorname", source = "middleName")
    @Mapping(target = "vorname", source = "firstName")
    @Mapping(target = "nachname", source = "lastName")
    UserDto mapUserToUserDto(User user);
}
