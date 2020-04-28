package com.example.hbmysql.repository;

import com.example.hbmysql.model.ClientEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Harvey Braun
 * @version 1.0
 * @since 25/04/2020
 */
public interface ClientRepository extends CrudRepository<ClientEntity, Long> {



}
