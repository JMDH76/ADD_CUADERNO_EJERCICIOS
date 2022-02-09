package es.florida.cuaderno05;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class ClienteCorreo {

	public static void envioMail(String mensaje, String asunto, String email_remitente, String email_remitente_pass,
			String host_email, String[] email_destino, String port_email, String[] anexo)
			throws MessagingException, UnsupportedEncodingException {

		System.out.println("\nEnvio de correo");
		System.out.println("\n > Remitente: " + email_remitente + "\n");
		for (int i = 0; i < email_destino.length; i++) {
			System.out.println(" > Destino " + (i + 1) + ": " + email_destino[i]);
		}
		System.out.println("\n > Asunto: " + asunto);

		int cont = 0;
		for (int i = 0; i < anexo.length; i++) {
			cont++;
		}
		System.out.println(" > Ficheros adjuntos: " + cont);
		System.out.println(" > Mensaje:   \n\n	" + mensaje);

		/*
		 * Propiedades necesarias para la conexión al servidor: servidor de correo,
		 * puerto, e-mail remitente, password remitente, tipo de autenticación y tipo de
		 * cifrado.
		 */
		Properties props = System.getProperties();
		props.put("mail.smtp.host", host_email);
		props.put("mail.smtp.user", email_remitente);
		props.put("mail.smtp.clave", email_remitente_pass);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", port_email);

		// Creamos una sesión:
		Session session = Session.getDefaultInstance(props);

		// Creamos un objeto "mens" y lo completamos con los campos mínimos
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(email_remitente));

		// Para añadir varios destinatarios creamos un bucle
		for (int i = 0; i < email_destino.length; i++) {
			message.addRecipients(Message.RecipientType.TO, email_destino[i]);
		}
		message.setSubject(asunto);

		// Creamos las partes que deseemos para el texto del mensaje y los anexos
		// (BodyPart)
		// Mensaje:
		BodyPart messageBodyPart1 = new MimeBodyPart();
		messageBodyPart1.setText(mensaje);

		// Datos adjuntos:
		// Un sólo adjunto:
		/*
		 * DataSource src = new FileDataSource(anexo[0]);
		 * messageBodyPart2.setDataHandler(new DataHandler(src));
		 * messageBodyPart2.setFileName(anexo[0]);
		 */

		// Varios adjuntos: creamos una lista de objetos BodyPart y añadimos tantaas
		// partes como adjuntos haya
		// Cuando los agrupemos los extraeremos de la lista leyéndola
		ArrayList<BodyPart> adjuntos = new ArrayList<BodyPart>();
		for (int i = 0; i < anexo.length; i++) {

			BodyPart messageBodyPart = new MimeBodyPart();

			DataSource src = new FileDataSource(anexo[i]);
			messageBodyPart.setDataHandler(new DataHandler(src));
			messageBodyPart.setFileName(anexo[i]);
			adjuntos.add(messageBodyPart);
		}

		// Agrupamos todas las BodyPart en un objeto 'Multipart'
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart1);
		for (BodyPart adjunto : adjuntos) { // Recorre la lista de adjuntos para agruparlos todos
			multipart.addBodyPart(adjunto);
		}

		// Añadimos el objeto Multipart al mensaje
		message.setContent(multipart);

		// Envío del mensaje mediante un objeto tipo Transport sobre la sesión creada.
		Transport transport = session.getTransport("smtp");
		transport.connect(host_email, email_remitente, email_remitente_pass);
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
	}

	public static void main(String[] args) {

		System.out.println("ClienteCorreo.java");

		String strMensaje = "Esto en un mensaje de prueba desde java";
		String strAsunto = "Prueba de correo";
		String emailRemitente = "jmdh.dam@gmail.com";
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce tu contrseña: ");
		String emailRemitentePass = teclado.nextLine();
		String hostEmail = "smtp.gmail.com";
		String portEmail = "587"; // puerto TLS
		String[] emailDestino = { "jodohe@floridauniversitaria.es", "josem.dominguez@hotmail.com",
				"jmdominguezhernandez@gmail.com" };

		String[] anexo = { "./ficheros_adjuntos/foto.jpg", "./ficheros_adjuntos/25.gif",
				"./ficheros_adjuntos/Prueba email.txt" };

		try {
			envioMail(strMensaje, strAsunto, emailRemitente, emailRemitentePass, hostEmail, emailDestino, portEmail,
					anexo);
		} catch (UnsupportedEncodingException | MessagingException e) {
			e.printStackTrace();
		}
		teclado.close();
	}

}
