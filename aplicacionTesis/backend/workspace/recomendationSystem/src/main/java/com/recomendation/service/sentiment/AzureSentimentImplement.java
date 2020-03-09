package com.recomendation.service.sentiment;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.recomendation.dao.searchTweet.ISearchTweetDao;
import com.recomendation.dao.sentiment.IAzureSentimentDao;
import com.recomendation.entity.searchTweetEntity.TweetEntity;
import com.recomendation.entity.sentiment.AzureSentimentEntity;

@Service
public class AzureSentimentImplement implements IAzureSentimentService {

	@Autowired
	IAzureSentimentDao azureSentimentDao;

	@Autowired
	ISearchTweetDao searchTweetDao;
	
	// Pro mio
//	 static String accessKey = "a7946e3a8f404d7e9cc62f30c81f781d";
//	 static String host = "https://northcentralus.api.cognitive.microsoft.com";
//	 static String path = "/text/analytics/v2.1/sentiment";
	
	
	// Free
	static String accessKey = "d10b101dd6ed414b80b4df4af24cdfc3";
	static String host = "https://westcentralus.api.cognitive.microsoft.com";
	static String path = "/text/analytics/v2.1/sentiment";

	public List<Documents> GetKeyPhrases(Documents documents) throws Exception {
		AzureSentimentEntity azureSentiment = new AzureSentimentEntity();
		String text = new Gson().toJson(documents);
		byte[] encoded_text = text.getBytes("UTF-8");
		String positivo = "positivo";
		String neutro = "neutro";
		String negativo = "negativo";
		String error = "error";

		List<AzureSentimentEntity> sentiments = new ArrayList<>();
		List<Documents> listDocumentsResponse = new ArrayList<>();

		URL url = new URL(host + path);
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "text/json");
		connection.setRequestProperty("Ocp-Apim-Subscription-Key", accessKey);
		connection.setDoOutput(true);

		DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
		wr.write(encoded_text, 0, encoded_text.length);
		wr.flush();
		wr.close();

		StringBuilder response = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String line;
		while ((line = in.readLine()) != null) {

			Gson g = new Gson();
			Documents p = g.fromJson(line, Documents.class);
			listDocumentsResponse.add(p);
			String str = g.toJson(p);
			response.append(line);
			String sentiment = str;
			String exeptionStringSentiment = "{\"documents\":[]}";
			String solutionStringSentiment = "{\"documents\":[{\"id\":\"null\",\"score\":0.5}]}";

			if (sentiment.equals(exeptionStringSentiment)) {
				sentiment = solutionStringSentiment;

			}

			// azureSentiment.setSentiment(sentiment);
			// System.out.println(sentiments);

			String objeto = sentiment;

			String parts[] = objeto.split("\\:");
			String part4 = parts[3];

			String cadenaFinal = part4.substring(0, 3);
			double score = Double.parseDouble(cadenaFinal);
			System.out.println("String convertida a double" + score);

			if (score >= 0.0 && score <= 0.40) {

				System.out.println("comentario negativo");
				azureSentiment.setSentiment(negativo);

			} else if (score >= 0.60 && score <= 0.99) {

				System.out.println("comentario positivo");
				azureSentiment.setSentiment(positivo);

			} else if (score == 1.0) {

				System.out.println("Comentario positivo");
				azureSentiment.setSentiment(positivo);

			} else {

				System.out.println("Comentario neutro");
				azureSentiment.setSentiment(neutro);
			}

			azureSentimentDao.save(azureSentiment);

		}
		in.close();
		return listDocumentsResponse;
	}

	public static String prettify(String json_text) {
		JsonParser parser = new JsonParser();
		JsonObject json = parser.parse(json_text).getAsJsonObject();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(json);
	}

	@Override
	public List<Documents> GetSentiment(TweetEntity tw) {

		try {
			Documents documents = new Documents();
			documents.add(tw.getId() + "", tw.getLanguage(), tw.getTweetContect(), null);
			List<Documents> response = GetKeyPhrases(documents);
			return response;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

		// ¿

	}

	@Override
	public List<AzureSentimentEntity> findAll() {
		return (List<AzureSentimentEntity>) azureSentimentDao.findAll();
	}

	@Override
	public List<AzureSentimentEntity> saveSentiment(AzureSentimentEntity azureSentimentEntity) {
		return (List<AzureSentimentEntity>) azureSentimentDao.save(azureSentimentEntity);
	}

	@Override
	public AzureSentimentEntity findById(Long id) {
		return azureSentimentDao.getOne(id);
	}

}
