package com.usermanagement.app.controller;

import com.usermanagement.app.dto.LoginRequestDTO;
import com.usermanagement.app.dto.UserRequestDTO;
import com.usermanagement.app.entity.User;
import com.usermanagement.app.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    // ---------------- REGISTER ----------------
    @PostMapping("/register")
    public User register(@RequestBody UserRequestDTO dto) {
        return service.register(dto);
    }

    // ---------------- LOGIN ----------------
    @PostMapping("/login")
    public User login(@RequestBody LoginRequestDTO dto) {
        return service.login(dto);
    }

    // ---------------- LIST USERS ----------------
    @GetMapping
    public List<User> list() {
        return service.getAll();
    }

    // ---------------- DELETE USER ----------------
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    // ---------------- FORGOT PASSWORD (SEND OTP) ----------------
    @PostMapping("/forgot-password")
    public String forgotPassword(@RequestParam String email) {
        return service.sendOtp(email);
    }

    // ---------------- RESET PASSWORD ----------------
    @PostMapping("/reset-password")
    public String resetPassword(
            @RequestParam String email,
            @RequestParam String otp,
            @RequestParam String newPassword) {

        return service.resetPassword(email, otp, newPassword);
    }
}
