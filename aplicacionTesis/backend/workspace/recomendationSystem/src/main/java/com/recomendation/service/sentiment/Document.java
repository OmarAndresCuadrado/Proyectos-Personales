package com.recomendation.service.sentiment;

import java.util.ArrayList;
import java.util.List;

public class Document {
	
	public String id, language, text;
	public Double score;

	public Document(String id, String language, String text , Double score) {
		this.id = id;
		this.language = language;
		this.text = text;
		this.score = score;
	}
}
