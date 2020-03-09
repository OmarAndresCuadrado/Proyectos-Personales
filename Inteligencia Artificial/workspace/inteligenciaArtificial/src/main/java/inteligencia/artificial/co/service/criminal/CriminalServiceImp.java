package inteligencia.artificial.co.service.criminal;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inteligencia.artificial.co.dao.ICriminalDao;
import inteligencia.artificial.co.entity.CriminalEntity;
import inteligencia.artificial.co.service.face.FaceDetectionBean;

@Service
public class CriminalServiceImp implements ICriminalService {

	@Autowired
	private ICriminalDao criminalDao;
	
	@Autowired
	FaceDetectionBean faceDetection;

	@Override
	public List<CriminalEntity> findAll() {
		return (List<CriminalEntity>) criminalDao.findAll();
	}

	@Override
	public Optional<CriminalEntity> findById(Long id) {
		return criminalDao.findById(id);
	}

	@Override
	public void delete(Long id) {
		criminalDao.deleteById(id);
	}

	@Override
	public CriminalEntity save(CriminalEntity criminalEntity) {
		String faceId = faceDetection.faceDetectionMethod(criminalEntity);
		criminalEntity.setFaceId(faceId);
		return criminalDao.save(criminalEntity);
	}

}
