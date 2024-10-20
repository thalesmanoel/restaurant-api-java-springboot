package com.restaurants.restaurants.entites;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.restaurants.restaurants.enums.OrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime date;
	private OrderStatus status;
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItem = new ArrayList<>();
	
	@OneToOne(mappedBy = "order")
    private Delivery delivery;
	
	public Order() {}

	public Order(Long id, LocalDateTime date, OrderStatus status, Restaurant restaurant, 
			List<OrderItem> orderItem, User user, Delivery delivery) {
		this.id = id;
		this.date = date;
		this.status = status;
		this.restaurant = restaurant;
		this.user = user;
		this.orderItem = orderItem != null ? new ArrayList<>(orderItem) : new ArrayList<>();
		this.setOrderItem(orderItem);
		this.setDelivery(delivery);
		
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Double getTotal() {
		double total = 0.0;

		for (int i = 0; i < orderItem.size(); i++) {
		    total += orderItem.get(i).getSubtotal();
		}

		return total;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List<OrderItem> orderItem) {
	    if (orderItem != null) {
	        this.orderItem.clear();
	        this.orderItem.addAll(orderItem);
	    } else {
	        this.orderItem = new ArrayList<>();
	    }
	}


	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
