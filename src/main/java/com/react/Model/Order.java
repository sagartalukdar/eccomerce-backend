package com.react.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String orderId;
	@ManyToOne
	private User user;
	@OneToMany(mappedBy = "order" ,cascade = CascadeType.ALL)
	private List<OrderItem>orderItems=new ArrayList<>();
	
	private LocalDateTime orderDate;
	
	private LocalDateTime deliveryDate;
	
	@OneToOne
	private Address shippingAddress;
	
	@Embedded
	private PaymentDetails paymentDetails;
	
	private double totalPrice;
	
	private Integer totalDiscountedPrice;
	private Integer discount;
	private String orderStatus;
	private int totalItem;
	private LocalDateTime createdAt;
	
	
	
}
