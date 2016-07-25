package com.elsbook.web.model;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "orders_items")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OrdersItemsAssociation implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "orders_items_id")
    private long orders_items_id;
    
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="orderid")
	private Orders order;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="isbn")
	private Items item;
	
	@Column(name = "amount", nullable = false)
	private long amount;

	public long getOrders_items_id() {
		return orders_items_id;
	}

	public void setOrders_items_id(long orders_items_id) {
		this.orders_items_id = orders_items_id;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Items getItem() {
		return item;
	}

	public void setItem(Items item) {
		this.item = item;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	
}
