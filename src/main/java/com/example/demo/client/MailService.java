package com.example.demo.client;
import java.text.DecimalFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	private JavaMailSender eMailSender;

	@Autowired
	public MailService(JavaMailSender eMailSender) {
		this.eMailSender = eMailSender;	
    }

    private static final DecimalFormat df = new DecimalFormat("#.##");
    public void sendMessage(Client client) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("Admin@advancedexteriorservices.com");
        message.setTo(client.getEmail(),"Admin@advancedexteriorservices.com");
		
        message.setSubject("Free Quote!");
        
        double temp = client.getFreeQuote();    
        message.setText(
            "Thank you for contacting Advanced Exterior Services LLC!\n\nBased on the information provided, your free quote is only $"  + df.format(temp) + "!\n\nIf this is a good starting point & you would like to schedule an in-person inspection for final pricing, please respond to this email with a time that is convenient for you.\n\nIf you have any other questions or prefer to contact us via phone, please call (770) 209-2707.\n\nOur team is looking forward to working with you!\n\n\n Advanced Exterior Services LLC\n Admin@Advancedexteriorservices.com\n (770) 209-2707"
        );
        this.eMailSender.send(message);
    }
}

