package com.test.marketplace.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.test.marketplace.common.data.GenericEntity;
import com.test.marketplace.constants.UtilConstants;

@Entity
@Table(schema=UtilConstants.SCHEMA_DB, name ="order")
public class Order extends GenericEntity{

	private static final long serialVersionUID = 8220397563839246910L;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_product_detail")
	private ProductDetail productDetail;
	
	@Column(name = "date_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTime;
	
	public Order() {
		super();
	}

	public ProductDetail getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(ProductDetail productDetail) {
		this.productDetail = productDetail;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

}
