package com.elsbook.web.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "orders")
public class Orders  implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderid")
	private long orderid;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "email", referencedColumnName = "email")
	private User user;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="order", cascade = CascadeType.REMOVE)
	private Set<OrderItems> orderItems = new HashSet<OrderItems>();
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@Column(name = "price", nullable = false)
	private float price;	
	
	@Column(name = "status")
	private int status;
	
	
	
	public long getOrderid() {
		return orderid;
	}

	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<OrderItems> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}
	
	public void addItems(OrderItems item){
		this.orderItems.add(item);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Orders [orderid=" + orderid + ", address=" + address + ", price=" + price + ", status=" + status + "]";
	}

	
}
