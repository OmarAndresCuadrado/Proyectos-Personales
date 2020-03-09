package inteligencia.artificial.co.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import inteligencia.artificial.co.entity.CriminalEntity;
import inteligencia.artificial.co.service.criminal.ICriminalService;

@RestController
@RequestMapping("/criminal")
@CrossOrigin(origins ="*")
public class CriminalController {

	@Autowired
	ICriminalService criminalService;

	@GetMapping("/index")
	private List<CriminalEntity> findAll() {
		return criminalService.findAll();
	}

	@GetMapping("/index/{id}")
	private Optional<CriminalEntity> findById(@PathVariable Long id) {
		return criminalService.findById(id);
	}

	@DeleteMapping("/index/{id}")
	private void Delete(@PathVariable Long id) {
		criminalService.delete(id);
	}

	@PostMapping("/index")
	private CriminalEntity save(@RequestBody CriminalEntity criminalEntity) {
		return criminalService.save(criminalEntity);
	}

	@PutMapping("/index/{id}")
	private CriminalEntity update(@PathVariable Long id, @RequestBody CriminalEntity criminalEntity) {

		// CriminalEntity criminalDatabase = criminalService.findById(id);
		//
		// criminalDatabase.get().setNombre(criminalEntity.getNombre());
		// criminalDatabase.get().setDescription(criminalEntity.getDescription());
		// criminalDatabase.get().setFoto(criminalEntity.getFoto());
		// return criminalService.save(criminalDatabase);

		return null;

	}

}
