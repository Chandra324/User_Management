package com.javaspring.taskproject.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.javaspring.taskproject.entity.Users;
import com.javaspring.taskproject.payload.UserDto;
import com.javaspring.taskproject.repository.UserRepository;
import com.javaspring.taskproject.service.UserService;
@Service
public class UserServiceImpl implements UserService {
   @Autowired
	private UserRepository userRepository;
   @Autowired
   private PasswordEncoder passwordEncoder;
	@Override
	public UserDto createUser(UserDto userDto) {
		// user dto is not entity of useer
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		Users user = userDtoToEntity(userDto);
		Users saveUser= userRepository.save(user);
		  
		return entityToUserDto(saveUser);
	}
	public Users userDtoToEntity(UserDto userDto) {
		Users users =new Users();
		users.setName(userDto.getName());
		users.setEmail(userDto.getEmail());
		users.setPassword(userDto.getPassword());
		return users;
		
	}
      private UserDto entityToUserDto(Users savedUser) {
    	  UserDto userDto =new UserDto();
    	userDto.setId(savedUser.getId());
    	userDto.setEmail(savedUser.getEmail());
    	userDto.setPassword(savedUser.getPassword());
    	userDto.setName(savedUser.getName());
   return userDto;

    	
      }
}
