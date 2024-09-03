package com.pandevs.pandevs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pandevs.pandevs.exceptions.UserNotFoundExceltion;
import com.pandevs.pandevs.model.User;
import com.pandevs.pandevs.repository.UserRepository;

@Service
public class UserService {
	//Mandar a llamar UserRepository
	private  UserRepository userRepository;

	// Inyección de dependencias en el constructor
	@Autowired

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	// Método para obtener todos los usuarios
	public List<User> getAll(){
		return userRepository.findAll();
	}
	
	// Método para crear un nuevo usuario
	public User createUser(User newUser) {
		return userRepository.save(newUser);
	}
	
 // Método para eliminar un usuario mediante id
	public void deleteUser(Long id) {
		//Eliminar
		if(userRepository.existsById(id)) {
			userRepository.deleteById(id);
			
			
		} else {
			// Exception
			throw new UserNotFoundExceltion(id);
			
		}
	}
	
	
	// Método para recuperar usuarios por Id (validar si existe)
		public User getById(Long id) {
			return userRepository.findById(id)
					.orElseThrow(() -> new UserNotFoundExceltion(id));
		}
		
		// Método para recuperar usuario por Id (sin excepción, de tipo Optional)
		/*
		public Optional<User> getById(Long id) {
			return userRepository.findById(id);
		}
		*/
	
	
		// Método para recuperar usuarios por email (con excepciones y de tipo user)
	public User getByEmail(String email) {
		return userRepository.findByEmail(email);
		
	}
	
	
	
	// Metodo para actualizar informacion de usuarios permitiendo modificar el password
			public User updateUser(User user, Long id) {
				return userRepository.findById(id)
						.map(userMap -> {
							userMap.setPassword(user.getPassword());
							return userRepository.save(userMap);
						})
						.orElseThrow(()-> new UserNotFoundExceltion(id));
			}
				
			
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

