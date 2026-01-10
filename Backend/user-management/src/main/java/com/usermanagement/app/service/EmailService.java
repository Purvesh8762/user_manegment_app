package com.usermanagement.app.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendOtp(String to, String otp) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Password Reset OTP");
        message.setText(
                "Dear User,\n\n" +
                        "Your OTP for password reset is: " + otp + "\n\n" +
                        "This OTP is valid for 5 minutes.\n\n" +
                        "If you did not request this, please ignore this email.\n\n" +
                        "Regards,\nUser Management System"
        );

        mailSender.send(message);
    }
}
