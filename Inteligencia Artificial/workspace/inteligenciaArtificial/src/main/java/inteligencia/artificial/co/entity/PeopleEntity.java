package inteligencia.artificial.co.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "people")
public class PeopleEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String faceIdPeople;

	private String foto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFaceIdPeople() {
		return faceIdPeople;
	}

	public void setFaceIdPeople(String faceIdPeople) {
		this.faceIdPeople = faceIdPeople;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
