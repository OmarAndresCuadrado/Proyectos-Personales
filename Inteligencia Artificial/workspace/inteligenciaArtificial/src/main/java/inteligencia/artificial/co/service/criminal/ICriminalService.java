package inteligencia.artificial.co.service.criminal;

import java.util.List;
import java.util.Optional;

import inteligencia.artificial.co.entity.CriminalEntity;

public interface ICriminalService {
	
	
	public List<CriminalEntity> findAll();
	
	public Optional<CriminalEntity> findById(Long id);
	
	public CriminalEntity save(CriminalEntity criminalEntity);
	
	public void delete(Long id);
	
	

}
