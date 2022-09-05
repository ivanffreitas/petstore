package br.com.ivanilson.repository;

import br.com.ivanilson.model.User;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

public class UserRepository implements PanacheRepositoryBase<User, Integer> {
}
