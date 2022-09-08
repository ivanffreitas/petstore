package br.com.ivanilson.repository;

import br.com.ivanilson.model.Category;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CategotyRepository implements PanacheRepositoryBase<Category, Integer> {
}
