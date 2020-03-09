package inteligencia.artificial.co.dao;

import org.springframework.data.repository.CrudRepository;

import inteligencia.artificial.co.entity.PeopleEntity;

public interface IPeopleDao extends CrudRepository<PeopleEntity, Long>{

}
