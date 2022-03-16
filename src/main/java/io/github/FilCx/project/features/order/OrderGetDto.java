package io.github.FilCx.project.features.order;

public class OrderGetDto {
	
	private Long userId;
	private Long restaurantId;
	
	public OrderGetDto() {
		
	}
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public Long getRestaurantId() {
		return restaurantId;
	}
	
	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}
}
