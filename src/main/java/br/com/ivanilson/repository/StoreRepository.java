package br.com.ivanilson.repository;

import br.com.ivanilson.model.Store;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StoreRepository implements PanacheRepositoryBase<Store, Integer> {
}
