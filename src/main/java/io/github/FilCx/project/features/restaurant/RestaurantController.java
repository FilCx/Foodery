package io.github.FilCx.project.features.restaurant;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.github.FilCx.project.features.product.Product;
import io.github.FilCx.project.features.product.ProductDto;

@Controller
@RequestMapping(path = "/restaurant")
public class RestaurantController {

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<RestaurantDto> getAllRestaurant() {
		// This returns a JSON or XML with the users
		Iterable<Restaurant> restaurants = restaurantRepository.findAll();
		
		return StreamSupport.stream(restaurants.spliterator(), false).map(this::convertToDto).collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public @ResponseBody RestaurantDto getRestaurant(@PathVariable Long id) {
		// This returns a JSON or XML with the users
		Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
		
		if (optionalRestaurant.isEmpty()) {
			return null;
		}
		
		return convertToDto(optionalRestaurant.get());
	}

	@GetMapping("/{id}/products")
	public @ResponseBody Iterable<ProductDto> getRestaurantProducts(@PathVariable Long id) {
		// This returns a JSON or XML with the users
		Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
		
		if (optionalRestaurant.isEmpty()) {
			return null;
		}
		
		Restaurant restaurant = optionalRestaurant.get();
		Iterable<Product> products = restaurant.getProducts();

		return StreamSupport.stream(products.spliterator(), false).map(this::convertToDto).collect(Collectors.toList());
	}

	private RestaurantDto convertToDto(Restaurant restaurant) {
		return modelMapper.map(restaurant, RestaurantDto.class);
	}

	private ProductDto convertToDto(Product product) {
		return modelMapper.map(product, ProductDto.class);
	}
}