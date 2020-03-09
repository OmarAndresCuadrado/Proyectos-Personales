package inteligencia.artificial.co.service.message;

import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class MessageImp {

	public void criminalIdentificado(String criminalNombre) {
		String ACCOUNT_SID = "ACf08f1d7c0dd53f15d8dfacc2d3c28f9b";
		String AUTH_ID = "f2582dc6dae4be48e3c31f6a4b5203b8";
		Twilio.init(ACCOUNT_SID, AUTH_ID);
		Message message = Message.creator(new PhoneNumber("+573105800497"), new PhoneNumber("+12055263105"),
				"\n" + "Criminal" + " " + criminalNombre +  " " + "Encontrado en la Universidad Piloto De Colombia" + " ").create();

	}
}
	