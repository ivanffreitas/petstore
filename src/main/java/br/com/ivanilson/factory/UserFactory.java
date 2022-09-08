package br.com.ivanilson.factory;

import br.com.ivanilson.dto.UserDto;
import br.com.ivanilson.model.User;

import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class UserFactory {

    public User toUser(UserDto dto){
        return User.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .email(dto.getEmail())
                .senha(dto.getSenha())
                .status(dto.getStatus())
                .build();
    }

    public List<User> toListUser(List<UserDto> dtos){
        return dtos
                .stream()
                .map(this::toUser)
                .collect(Collectors.toList());
    }

    public UserDto toUserDto(User entidade){
        return UserDto.builder()
                .id(entidade.getId())
                .nome(entidade.getNome())
                .email(entidade.getEmail())
                .senha(entidade.getSenha())
                .status(entidade.getStatus())
                .build();
    }

    public List<UserDto> toListUserDtos(List<User> entidades){
        return entidades
                .stream()
                .map(this::toUserDto)
                .collect(Collectors.toList());
    }
}
