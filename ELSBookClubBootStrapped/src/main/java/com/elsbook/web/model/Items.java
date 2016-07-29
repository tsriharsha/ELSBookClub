package com.elsbook.web.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "items")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Items implements Serializable, Comparable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "isbn", nullable = false, unique = true)
	private long isbn;

	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "author", nullable = false)
	private String author;
	
	@Column(name = "genre", nullable = false)
	private String genre;
	
	@Column(name = "price", nullable = false)
	private float price;
	
	@Lob
	@Column(name = "details", nullable = false)
	private String details;
	
	
	
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	public String printDetails(){
		if(this.details.length()>60)
			return this.details.substring(0, 57)+"...";
		else
			return this.details;
		
	}

	@Override
	public String toString() {
		return "Items [isbn=" + isbn + ", name=" + name + ", author=" + author + ", genre=" + genre + ", price=" + price
				+ ", details=" + details + "]";
	}

	@Override
	public int compareTo(Object arg0) {
		if(arg0 instanceof Items){
			if(this.getIsbn()>((Items)arg0).getIsbn())
				return 1;
			else
				return -1;
		}
		else return -1;
	}

	
}
