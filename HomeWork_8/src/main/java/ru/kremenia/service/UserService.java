package ru.kremenia.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.kremenia.model.dto.UserDto;
import ru.kremenia.model.mapper.UserDtoMapper;
import ru.kremenia.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDtoMapper mapper;
    private final UserRepository userRepository;

    public Page<UserDto> findAllByFilter(String usernameFilter, String emailFilter, int page, int size) {
        usernameFilter = usernameFilter == null || usernameFilter.isBlank() ? null : "%" + usernameFilter.trim() + "%";
        emailFilter = emailFilter == null || emailFilter.isBlank() ? null : "%" + emailFilter.trim() + "%";
        return userRepository.usersByFilter(usernameFilter, emailFilter, PageRequest.of(page, size)).map(mapper::map);

    }

    public Optional<UserDto> findUserById(Long id) {
        return userRepository.findById(id).map(mapper::map);
    }

    public void save(UserDto dto) {
        userRepository.save(mapper.map(dto));
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

}
