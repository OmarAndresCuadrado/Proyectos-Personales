package inteligencia.artificial.co.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import inteligencia.artificial.co.entity.CriminalEntity;
import inteligencia.artificial.co.service.criminal.ICriminalService;
import inteligencia.artificial.co.service.face.FaceDetectionBean;
import inteligencia.artificial.co.service.face.FaceVerifyBean;

@RestController
@RequestMapping("face")
@CrossOrigin(origins = "*")
public class FaceVerifyController {

	@Autowired
	private FaceVerifyBean faceVerifyService;

	@PostMapping("/verify")
	private void faceDectection() {
		faceVerifyService.faceVerifyMethod();
	}

}
