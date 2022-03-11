package io.github.FilCx.project.features.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long user_id;
	private String user_name;
	private String user_address;

	protected User() {
	}

	public User(String name, String address) {
		this.user_name = name;
		this.user_address = address;
	}

	@Override
	public String toString() {
		return String.format("User[id=%d, name='%s', address='%s']", user_id, user_name, user_address);
	}

	public Long getId() {
		return user_id;
	}

	public String getName() {
		return user_name;
	}

	public String getAddress() {
		return user_address;
	}

	public void setName(String name) {
		this.user_name = name;
		
	}

	public void setAddress(String address) {
		this.user_address = address;
	}
}
