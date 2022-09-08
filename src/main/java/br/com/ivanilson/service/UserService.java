package br.com.ivanilson.service;

import br.com.ivanilson.dto.UserDto;
import br.com.ivanilson.factory.UserFactory;
import br.com.ivanilson.model.User;
import br.com.ivanilson.repository.UserRepository;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Transactional
public class UserService {

    @Inject
    UserRepository repository;

    @Inject
    UserFactory factory;

    public List<UserDto> listarUser(){
        PanacheQuery<User> query = repository.findAll();
        List<UserDto> dtos = query.stream().map(factory::toUserDto).collect(Collectors.toList());

       return dtos;
    }

    public UserDto buscarPorId(Integer id) {
        User user = repository.findByIdOptional(id).orElseThrow(() -> new NotFoundException());
        UserDto dto = factory.toUserDto(user);
        return dto;
    }

    public Boolean inserir(UserDto dto) {
        User novo = factory.toUser(dto);
        repository.persist(novo);
        return true;
    }

    public Boolean alterar(UserDto dto) {
        User user = repository.findByIdOptional(dto.getId()).orElseThrow( () -> new NotFoundException() );
        user.setNome(dto.getNome());
        user.setSenha(dto.getSenha());
        user.setStatus(dto.getStatus());
        repository.persist(user);
        return true;
    }
}
