package com.elsbook.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@OneToMany
	@JoinColumn(name="isbn")
	private List<OrdersItemsAssociation> orderList = new ArrayList<OrdersItemsAssociation>();

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

	public List<OrdersItemsAssociation> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrdersItemsAssociation> orderList) {
		this.orderList = orderList;
	}
	
}
