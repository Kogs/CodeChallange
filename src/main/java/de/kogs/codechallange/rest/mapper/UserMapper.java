package de.kogs.codechallange.rest.mapper;

import java.util.Collection;

import org.mapstruct.Mapper;

import de.kogs.codechallange.data.User;
import de.kogs.codechallange.rest.dto.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper {
    
    Collection<UserDto> toDto(Collection<User> users);
    
    UserDto toDto(User user);

    User fromDto(UserDto user);

}
