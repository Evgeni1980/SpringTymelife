package ru.kremenia.model.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.kremenia.model.User;
import ru.kremenia.model.dto.UserDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-08T15:29:02+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.3 (Oracle Corporation)"
)
@Component
public class UserDtoMapperImpl implements UserDtoMapper {

    @Override
    public UserDto map(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        if ( user.getId() != null ) {
            userDto.setId( user.getId() );
        }
        if ( user.getUsername() != null ) {
            userDto.setUsername( user.getUsername() );
        }
        if ( user.getEmail() != null ) {
            userDto.setEmail( user.getEmail() );
        }

        return userDto;
    }

    @Override
    public User map(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        if ( dto.getUsername() != null ) {
            user.setUsername( dto.getUsername() );
        }
        if ( dto.getEmail() != null ) {
            user.setEmail( dto.getEmail() );
        }
        if ( dto.getPassword() != null ) {
            user.setPassword( dto.getPassword() );
        }

        return user;
    }
}
