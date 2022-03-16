package io.github.FilCx.project.features.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.modelmapper.ModelMapper;

@Controller
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping(path = "/add")
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody UserDto addNewUser(@RequestBody UserDto userDto) {
		User user = convertToEntity(userDto);
		User savedUser = userRepository.save(user);
		
		return convertToDto(savedUser);
	}
	
	private UserDto convertToDto(User user) {
		return modelMapper.map(user, UserDto.class);
	}
	
	private User convertToEntity(UserDto userDto) {
		return modelMapper.map(userDto, User.class);
	}
}