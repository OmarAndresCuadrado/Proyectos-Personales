package inteligencia.artificial.co.dao;


import org.springframework.data.repository.CrudRepository;

import inteligencia.artificial.co.entity.CriminalEntity;

public interface ICriminalDao extends CrudRepository<CriminalEntity, Long> {

	

}
