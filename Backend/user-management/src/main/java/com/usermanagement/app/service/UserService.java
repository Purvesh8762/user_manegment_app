package com.usermanagement.app.service;

import com.usermanagement.app.dto.LoginRequestDTO;
import com.usermanagement.app.dto.UserRequestDTO;
import com.usermanagement.app.entity.User;
import com.usermanagement.app.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class UserService {

    private final UserRepository repo;
    private final EmailService emailService;

    public UserService(UserRepository repo, EmailService emailService) {
        this.repo = repo;
        this.emailService = emailService;
    }

    // ---------------- REGISTER ----------------
    public User register(UserRequestDTO dto) {
        if (repo.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        return repo.save(user);
    }

    // ---------------- LOGIN ----------------
    public User login(LoginRequestDTO dto) {
        return repo.findByEmailAndPassword(dto.getEmail(), dto.getPassword())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));
    }

    // ---------------- LIST USERS ----------------
    public List<User> getAll() {
        return repo.findAll();
    }

    // ---------------- DELETE USER ----------------
    public void delete(Long id) {
        repo.deleteById(id);
    }

    // ---------------- SEND OTP ----------------
    public String sendOtp(String email) {

        User user = repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Email not found"));

        String otp = String.valueOf(new Random().nextInt(900000) + 100000);

        user.setOtp(otp);
        user.setOtpExpiry(LocalDateTime.now().plusMinutes(5));
        repo.save(user);

        // ✅ SEND OTP TO EMAIL
        emailService.sendOtp(email, otp);

        return "OTP sent to your email";
    }

    // ---------------- RESET PASSWORD ----------------
    public String resetPassword(String email, String otp, String newPassword) {

        User user = repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Email not found"));

        if (!otp.equals(user.getOtp())) {
            throw new RuntimeException("Invalid OTP");
        }

        if (user.getOtpExpiry().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("OTP expired");
        }

        user.setPassword(newPassword);
        user.setOtp(null);
        user.setOtpExpiry(null);

        repo.save(user);

        return "Password reset successful";
    }
}
