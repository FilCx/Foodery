package io.github.FilCx.project.features.order;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.github.FilCx.project.features.restaurant.Restaurant;
import io.github.FilCx.project.features.restaurant.RestaurantRepository;
import io.github.FilCx.project.features.user.User;
import io.github.FilCx.project.features.user.UserRepository;

@Controller
@RequestMapping(path = "/order")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping(path = "/add")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public OrderPostDto addNewOrder(@RequestBody OrderGetDto orderGetDto) throws Exception {

		Optional<User> optionalUser = userRepository.findById(orderGetDto.getUserId());

		if (optionalUser.isEmpty()) {
			throw new Exception("User not found.");
		}

		Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(orderGetDto.getRestaurantId());
		
		if (optionalRestaurant.isEmpty()) {
			throw new Exception("Restaurant not found.");
		}
		
		Order savedOrder = orderRepository.save(new Order(optionalUser.get(), optionalRestaurant.get()));
		
		return convertToDto(savedOrder);
	}
	
	private OrderPostDto convertToDto(Order order) {
		return modelMapper.map(order, OrderPostDto.class);
	}
}
