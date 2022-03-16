package io.github.FilCx.project.features.order_product;

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

import io.github.FilCx.project.features.order.Order;
import io.github.FilCx.project.features.order.OrderRepository;
import io.github.FilCx.project.features.product.Product;
import io.github.FilCx.project.features.product.ProductRepository;

@Controller
@RequestMapping(path = "/order_product")
public class OrderProductController {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderProductRepository orderProductRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping(path = "/add")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public OrderProductPostDto addNewOrder(@RequestBody OrderProductGetDto orderProductGetDto) throws Exception {

		Optional<Order> optionalOrder = orderRepository.findById(orderProductGetDto.getOrderId());

		if (optionalOrder.isEmpty()) {
			throw new Exception("Order not found.");
		}

		Optional<Product> optionalProduct = productRepository.findById(orderProductGetDto.getProductId());
		
		if (optionalProduct.isEmpty()) {
			throw new Exception("Product not found.");
		}
		
		Order order = optionalOrder.get();
		Product product = optionalProduct.get();
		
		OrderProduct orderProduct = new OrderProduct(order, product, orderProductGetDto.getQuantity());
		
		OrderProduct savedOrderProduct = orderProductRepository.save(orderProduct);

		return convertToDto(savedOrderProduct);
	}

	private OrderProductPostDto convertToDto(OrderProduct orderProduct) {
		return modelMapper.map(orderProduct, OrderProductPostDto.class);
	}
}
