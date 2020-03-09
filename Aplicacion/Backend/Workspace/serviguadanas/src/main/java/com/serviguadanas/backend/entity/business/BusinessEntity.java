package com.serviguadanas.backend.entity.business;

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
@Table(name = "Business")
public class BusinessEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String name;
	
	@Column
	private String photo;

	@Column
	private String phone;

	@Column
	private String address;
	
	@Column
	private String schedule;

	@Column(name = "Registerdate")
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
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
