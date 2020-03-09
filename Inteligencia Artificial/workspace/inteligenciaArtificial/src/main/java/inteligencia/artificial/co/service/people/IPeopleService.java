package inteligencia.artificial.co.service.people;

import java.util.List;


import inteligencia.artificial.co.entity.PeopleEntity;

public interface IPeopleService{

	
	List<PeopleEntity> findAll(); 
	
	PeopleEntity save(PeopleEntity peopleEntity);
}
