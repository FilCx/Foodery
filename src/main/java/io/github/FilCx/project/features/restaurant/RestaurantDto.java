package io.github.FilCx.project.features.restaurant;

public class RestaurantDto {
	
	private Long id;
	private String name;
	private String address;
	
	public RestaurantDto() {
		
	}

	public RestaurantDto(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
