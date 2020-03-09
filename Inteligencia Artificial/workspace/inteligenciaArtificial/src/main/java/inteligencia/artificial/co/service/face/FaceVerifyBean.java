package inteligencia.artificial.co.service.face;

import java.net.URI;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import inteligencia.artificial.co.entity.CriminalEntity;
import inteligencia.artificial.co.entity.PeopleEntity;
import inteligencia.artificial.co.service.criminal.ICriminalService;
import inteligencia.artificial.co.service.message.MessageImp;
import inteligencia.artificial.co.service.people.IPeopleService;

// 65147773a65c43c5b5e170df5e5ba8f3
// https://westcentralus.api.cognitive.microsoft.com/face/v1.0

// Face id
// ca156e22-fc74-4380-b072-f2cf9260301c
// f3dfa968-0dd3-4da1-8d3f-e20da6e1c6c2
// bf9e7396-52ef-4748-afcf-8674471f65cd

@Service
public class FaceVerifyBean {

	@Autowired
	private ICriminalService criminalService;

	@Autowired
	private IPeopleService peopleService;

	@Autowired
	private MessageImp mensajeService;

	private static final String subscriptionKey = "a0254874ae8f4ad4ad134adc5906e4a4";
	private static final String uriBase = "https://westcentralus.api.cognitive.microsoft.com/face/v1.0/verify";

	public void faceVerifyMethod() {
		List<CriminalEntity> criminalArray = criminalService.findAll();
		List<PeopleEntity> peopleArray = peopleService.findAll();

		try {

			HttpClient httpclient = HttpClientBuilder.create().build();
			URIBuilder builder = new URIBuilder(uriBase);

			// Prepare the URI for the REST API call.
			URI uri = builder.build();
			HttpPost request = new HttpPost(uri);

			// Request headers.
			request.setHeader("Content-Type", "application/json");
			request.setHeader("Ocp-Apim-Subscription-Key", subscriptionKey);

			for (CriminalEntity criminalEntity : criminalArray) {
				for (PeopleEntity peopleEntity : peopleArray) {

					String faceIdCriminal = criminalEntity.getFaceId();
					String faceIdPeople = peopleEntity.getFaceIdPeople();

					System.out.println("Analizando Caras...");
					System.out.println("Criminal ID:" + " " + faceIdCriminal);
					System.out.println("Pople ID:" + " " + faceIdPeople);
					System.out.println(" ");

					String requestFinal = "{" + "\r\n" + " " + " " + "\"" + "faceId1" + "\"" + ":" + " \""
							+ faceIdCriminal + "\"" + "," + "\r\n" + " " + " " + "\"" + "faceId2" + "\"" + ":" + " \""
							+ faceIdPeople + "\"" + "\r\n" + "}";


					System.out.println(requestFinal);
					StringEntity reqEntity = new StringEntity(requestFinal);
					request.setEntity(reqEntity);

					// Execute the REST API call and get the response entity.
					HttpResponse response = httpclient.execute(request);
					HttpEntity entity = response.getEntity();

					if (entity != null) {
						String responseValue = EntityUtils.toString(entity);
						JSONObject jsonObject = new JSONObject(responseValue);
						 System.out.println("JSON" + " " +jsonObject);
						double confidence = jsonObject.getDouble("confidence");
						System.out.println("valor confidence" + " " + confidence);
						System.out.println(responseValue);
	
						if (confidence >= 0.5) {
							System.out.println("Criminal Encontrado ...");
							System.out.println("Enviando Mensaje De Alerta ...");
							 mensajeService.criminalIdentificado(criminalEntity.getNombre());
						}

					}

				}

			}

		} catch (Exception e) {
			// Display error message.
			System.out.println(e.getMessage());
		}

	}
}
