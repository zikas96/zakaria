package com.example.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.entities.Categorie;
@RepositoryRestResource
public interface categorieRepository extends JpaRepository<Categorie, Long> {

	
}
