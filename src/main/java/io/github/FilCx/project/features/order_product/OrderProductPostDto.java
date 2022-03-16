package io.github.FilCx.project.features.order_product;

import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;

import io.github.FilCx.project.features.product.ProductDto;

public class OrderProductPostDto {
	private Long id;
	private OrderDto order;
	private ProductDto product;
	private int quantity;
	
	public OrderProductPostDto() {
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public OrderDto getOrder() {
		return order;
	}
	
	public void setOrder(OrderDto order) {
		this.order = order;
	}
	
	public ProductDto getProduct() {
		return product;
	}
	
	public void setProduct(ProductDto product) {
		this.product = product;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
