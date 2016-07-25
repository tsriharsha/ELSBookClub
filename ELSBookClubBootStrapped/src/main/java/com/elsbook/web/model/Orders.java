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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "orders")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Orders implements Serializable {

	public Orders(String address, String shoppingcart, float pricetotal, int orderstatus) {
		this.address = address;
		this.shoppingcart = shoppingcart;
		this.pricetotal = pricetotal;
		this.orderstatus = orderstatus;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "orderid")
	private long orderid;

	@Column(name = "address")
	private String address;
	
	@Column(name = "shoppingcart")
	private String shoppingcart;

	@Column(name = "pricetotal")
	private float pricetotal;

	@Column(name = "orderstatus")
	private int orderstatus;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	
	@OneToMany
	private List<OrdersItemsAssociation> itemList = new ArrayList<OrdersItemsAssociation>();

	public long getOrderid() {
		return orderid;
	}

	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getShoppingcart() {
		return shoppingcart;
	}

	public void setShoppingcart(String shoppingcart) {
		this.shoppingcart = shoppingcart;
	}

	public float getPricetotal() {
		return pricetotal;
	}

	public void setPricetotal(float pricetotal) {
		this.pricetotal = pricetotal;
	}

	public int getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(int orderstatus) {
		this.orderstatus = orderstatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrdersItemsAssociation> getItemList() {
		return itemList;
	}

	public void setItemList(List<OrdersItemsAssociation> itemList) {
		this.itemList = itemList;
	}
	
}
