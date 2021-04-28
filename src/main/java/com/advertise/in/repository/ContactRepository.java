package com.advertise.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.advertise.in.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer > {

}
