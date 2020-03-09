package inteligencia.artificial.co.service.face;

import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.springframework.stereotype.Service;
import inteligencia.artificial.co.entity.PeopleEntity;

// Joel  https://muzikalia.com/wp-content/uploads/2018/11/billyjoel.jpg
// Michael https://okdiario.com/img/2019/09/10/michael-jackson-655x368.jpg
@Service
public class FaceDetectionClientBean {


	private static final String subscriptionKey = "a0254874ae8f4ad4ad134adc5906e4a4";

	private static final String uriBase = "https://westcentralus.api.cognitive.microsoft.com/face/v1.0/detect";

//	 private static final String imageWithFaces =
//	 "{\"url\":\"https://okdiario.com/img/2019/09/10/michael-jackson-655x368.jpg\"}";

	private static final String faceAttributes = "age,gender,headPose,smile,facialHair,glasses,emotion,hair,makeup,occlusion,accessories,blur,exposure,noise";

	// CriminalEntity criminalEntity = new CriminalEntity();
	public String faceDetectionMethod(PeopleEntity peopleEntity) {

		try {
			// CriminalEntity criminalEntity = new CriminalEntity();
			// List<CriminalEntity> arrayCriminal = (List<CriminalEntity>)
			// criminalDao.findAll();
			// System.out.println(arrayCriminal);

			HttpClient httpclient = HttpClientBuilder.create().build();
			URIBuilder builder = new URIBuilder(uriBase);

			// Request parameters. All of them are optional.
			builder.setParameter("returnFaceId", "true");
			builder.setParameter("returnFaceLandmarks", "false");
			builder.setParameter("returnFaceAttributes", faceAttributes);

			// Prepare the URI for the REST API call.
			URI uri = builder.build();
			HttpPost request = new HttpPost(uri);

			// Request headers.
			request.setHeader("Content-Type", "application/json");
			request.setHeader("Ocp-Apim-Subscription-Key", subscriptionKey);

			// Request body.
			String foto = peopleEntity.getFoto();
			String url1 = "{\"url\":\"";
			String url2 = "\"}";
			String fotoD = (url1 + foto + url2 );
		
			
//			System.out.println(foto);
			// "{\"url\":\"https://okdiario.com/img/2019/09/10/michael-jackson-655x368.jpg\"}";
			
			StringEntity reqEntity = new StringEntity(fotoD) ;

			request.setEntity(reqEntity);

			// Execute the REST API call and get the response entity.
			HttpResponse response = httpclient.execute(request);
			HttpEntity entity = response.getEntity();

			if (entity != null) {

				String jsonString = EntityUtils.toString(entity).trim();
				if (jsonString.charAt(0) == '[') {
					JSONArray jsonArray = new JSONArray(jsonString);
					String jsonFinal = jsonArray.toString(2);
					String[] partes = jsonFinal.split("faceId");
					String faceId = partes[1];
					System.out.println(faceId);
					String faceIdFinal = faceId.substring(4, 40);
					peopleEntity.setFoto(foto);
					peopleEntity.setFaceIdPeople(faceIdFinal);

//					return faceIdFinal;

				}
			}

		} catch (

		Exception e) {
			// Display error message.
			System.out.println(e.getMessage());
		}
		System.out.println(peopleEntity.getFoto());
		return peopleEntity.getFaceIdPeople();


//		return "sucess";

	}

}
