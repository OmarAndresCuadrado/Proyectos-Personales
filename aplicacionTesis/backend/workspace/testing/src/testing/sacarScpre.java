package testing;

public class sacarScpre {

	public static void main(String[] args) {
	

		String objeto = "{\"documents\":[{\"id\":\"1\",\"score\":0.96196770668029785}";
		String parts [] = objeto.split("\\:");
		String part4 = parts[3];
		String cadenaFinal = part4.substring(0,19);
		double score = Double.parseDouble(cadenaFinal);

		
	}

}
