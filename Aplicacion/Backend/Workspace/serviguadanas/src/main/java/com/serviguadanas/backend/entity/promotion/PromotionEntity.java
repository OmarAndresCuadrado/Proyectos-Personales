package com.serviguadanas.backend.entity.promotion;

import java.io.Serializable;
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
@Table(name = "Promotion")
public class PromotionEntity implements Serializable {

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
	private String description;

	@Column
	private String percent;

	@Column(name = "initial_date")
	private String initialDate;

	@Column(name = "end_date")
	private String endDate;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPercent() {
		return percent;
	}

	public void setPercent(String percent) {
		this.percent = percent;
	}

	public String getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(String initialDate) {
		this.initialDate = initialDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
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
