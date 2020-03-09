package com.serviguadanas.backend.entity.product;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Product")
public class ProductEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String name;
	
	@Column
	private String photo;


	@Column
	private String type;

	@Column
	private Long cost;

	@Column
	private Boolean avaliable;

	@Column
	private String description;

	@Column
	private String quantity;

	@Column
	private String provider;

	@Column(name = "machine_brand")
	private String machinebrand;

	@Column(name = "register_date")
	@Temporal(TemporalType.DATE) // trasnformar la fecha de java a la fecha del mysql
	private Date createat;

	@PrePersist
	public void prePersist() {
		createat = new Date();

	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getCost() {
		return cost;
	}

	public void setCost(Long cost) {
		this.cost = cost;
	}

	public Boolean getAvaliable() {
		return avaliable;
	}

	public void setAvaliable(Boolean avaliable) {
		this.avaliable = avaliable;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getMachinebrand() {
		return machinebrand;
	}

	public void setMachinebrand(String machinebrand) {
		this.machinebrand = machinebrand;
	}

	public Date getCreateat() {
		return createat;
	}

	public void setCreateat(Date createat) {
		this.createat = createat;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
