package inteligencia.artificial.co.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import inteligencia.artificial.co.entity.PeopleEntity;
import inteligencia.artificial.co.service.people.IPeopleService;

@RestController
@RequestMapping("/people")
@CrossOrigin(origins ="*")
public class PeopleController {
	
	@Autowired
	IPeopleService popleService;
	
	@GetMapping("index")
	public List<PeopleEntity> findAll() {
		return popleService.findAll();
	}
	
	@PostMapping("index")
	public PeopleEntity save(@RequestBody PeopleEntity peopleEntity) {
		return popleService.save(peopleEntity);
	}

}
