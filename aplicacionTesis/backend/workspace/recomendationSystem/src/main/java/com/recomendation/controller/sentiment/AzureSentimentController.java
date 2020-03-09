package com.recomendation.controller.sentiment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recomendation.entity.sentiment.AzureSentimentEntity;
import com.recomendation.service.sentiment.IAzureSentimentService;

@RestController
//@Secured({"ROLE_ADMIN"})
@RequestMapping("/dashboard")
@CrossOrigin(origins ="*")
public class AzureSentimentController {

	@Autowired
	IAzureSentimentService azureSentimentService;

	@GetMapping("/sentiment")
	public List<AzureSentimentEntity> sentimentJson() {
		return azureSentimentService.findAll();
	}
	

	//Trabajar en guardar el sentimiento
	@PostMapping("/sentiment")
	public List<AzureSentimentEntity> sentimentJson(AzureSentimentEntity azureSentimentEntity) {
		return azureSentimentService.saveSentiment(azureSentimentEntity);
	}
}


