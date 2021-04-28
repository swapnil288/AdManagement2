package com.advertise.in.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.advertise.in.model.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin,String> {

}

