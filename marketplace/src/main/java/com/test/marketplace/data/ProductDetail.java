package com.test.marketplace.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.test.marketplace.common.data.GenericEntity;
import com.test.marketplace.constants.UtilConstants;

@Entity
@Table(schema=UtilConstants.SCHEMA_DB, name ="product_detail")
public class ProductDetail extends GenericEntity {

	private static final long serialVersionUID = -7321372148343663458L;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_product")
	private Product idProduct;
	
	@Column(name = "color")
	private String color;
	
	@Column(name = "cost")
	private Integer cost;
	
	@Column(name = "stock")
	private Integer stock;
	
	@Column(name = "description", columnDefinition = "TEXT")
	private String description;
	
	public ProductDetail() {
		super();
	}
	
	public Product getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Product idProduct) {
		this.idProduct = idProduct;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
