package inteligencia.artificial.co.service.people;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inteligencia.artificial.co.dao.IPeopleDao;
import inteligencia.artificial.co.entity.PeopleEntity;
import inteligencia.artificial.co.service.face.FaceDetectionClientBean;

@Service
public class PeopleServiceImp implements IPeopleService {

	
	@Autowired
	IPeopleDao peopleDao;
	
	@Autowired
	FaceDetectionClientBean faceDetection;
	
	
	@Override
	public List<PeopleEntity> findAll() {
		return (List<PeopleEntity>) peopleDao.findAll();
	}



	@Override
	public PeopleEntity save(PeopleEntity peopleEntity) {
		String faceId = faceDetection.faceDetectionMethod(peopleEntity);
		peopleEntity.setFaceIdPeople(faceId);
		return peopleDao.save(peopleEntity);
	}

	

}
