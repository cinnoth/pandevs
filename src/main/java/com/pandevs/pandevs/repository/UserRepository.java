package com.pandevs.pandevs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pandevs.pandevs.model.User;

//Esta interfaz hereda los métodos de JpaRepository y toma dos parametros, el objeto model y el tipo de dato de la PK
public interface UserRepository extends JpaRepository<User, Long>{
//Más adelante aqui podemos realizar consultas (query): JPQL
	// User es lo de la entidad 
	@Query("SELECT u FROM User u WHERE u.email = ?1")
	User findByEmail(String email);
	
	
}
