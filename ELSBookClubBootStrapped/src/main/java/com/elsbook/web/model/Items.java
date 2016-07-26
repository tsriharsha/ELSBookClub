package com.elsbook.web.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "items")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Items implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "isbn", nullable = false)
	private long isbn;

	@Column(name = "name", nullable = false)
	private String name;
	
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="item", cascade = CascadeType.REMOVE)
	private Set<OrderItems> orderItems = new HashSet<OrderItems>();

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<OrderItems> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}
	
	public void addOrder(OrderItems orderitem){
		this.orderItems.add(orderitem);
	}

	
}
