package es.florida.cuaderno05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class GestorHTTP implements HttpHandler { // implementamos la interfaz

	@Override
	public void handle(HttpExchange httpExchange) throws IOException {

		String requestParamValue = null;

		if ("GET".equals(httpExchange.getRequestMethod())) { // si la peticion es GET
			requestParamValue = handleGetRequest(httpExchange);
			handleGETResponse(httpExchange, requestParamValue); // devuelve respuesta al cliente

		} else if ("POST".equals(httpExchange.getRequestMethod())) { // si la peticion es POST
			requestParamValue = handlePostRequest(httpExchange);
			handlePOSTResponse(httpExchange, requestParamValue);
		}
	}

	private String handleGetRequest(HttpExchange httpExchange) { // Obtenemos la informacion que nos envian por el GET
		System.out.println("Recibida URI tipo GET: " + httpExchange.getRequestURI().toString());
		return httpExchange.getRequestURI().toString().split("\\?")[1].split("=")[1]; // trocea la peticion
	}

	// Procesa la informacion que le llega, lo lee y lo almacena en un string
	private String handlePostRequest(HttpExchange httpExchange) {
		System.out.println("Recibida URI tipo POST: " + httpExchange.getRequestBody().toString());

		InputStream is = httpExchange.getRequestBody();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		String line;
		try {
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// return httpExchange.getRequestBody().toString();
		return sb.toString();
	}

	// Genera respuesta cuando se usa GET
	private void handleGETResponse(HttpExchange httpExchange, String requestParamValue) throws IOException {
		OutputStream outputStream = httpExchange.getResponseBody(); // punto de partida para implementar otras cosas
																	// como recepcion de JSON, etc...
		String htmlResponse = "<html><body><h1>Hola " + requestParamValue + "</h1></body></html>";
		httpExchange.sendResponseHeaders(200, htmlResponse.length());
		outputStream.write(htmlResponse.getBytes());
		outputStream.flush();
		outputStream.close();
		System.out.println("Devuelve respuesta HTML: " + htmlResponse);
	}

	private void handlePOSTResponse(HttpExchange httpExchange, String requestParamValue) throws IOException {
		OutputStream outputStream = httpExchange.getResponseBody(); // Ok de que se ha recibido
		String htmlResponse = "Parametros POST: " + requestParamValue + " -> Se procesara por parte del servidor";
		httpExchange.sendResponseHeaders(200, htmlResponse.length());
		outputStream.write(htmlResponse.getBytes());
		outputStream.flush();
		outputStream.close();
		System.out.println("Devuelve respuesta HTML: " + htmlResponse);
		
		String getJsonPost = requestParamValue;
		convertJasonToJavaObj(getJsonPost);
	}
	
	private void convertJasonToJavaObj(String json) {
		Gson gson = new Gson();
		carDetails user = gson.fromJson(json, carDetails.class);
		System.out.println(user.toString());
	}
	
	class carDetails{
		
		private String marca;
		private String modelo;
		private String cilindrada;
		private String color;
		
		public String toString() {
			String info = "\nMarca: " + marca + "\nModelo: " + modelo + "\nCilindrada: " + cilindrada + "\nColor: " + color;
			return info;
		}
	}
}




