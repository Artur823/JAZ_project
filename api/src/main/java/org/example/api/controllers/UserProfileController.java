package org.example.api.controllers;

import org.example.api.services.UserProfileService;
import org.example.client.contract.UserProfileDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-profiles")
public class UserProfileController {

    private final UserProfileService userProfileService;

    @Autowired
    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    // Получение всех профилей пользователей
    @GetMapping
    public ResponseEntity<List<UserProfileDTO>> getAllUserProfiles() {
        List<UserProfileDTO> userProfiles = userProfileService.getAllUserProfiles();
        return ResponseEntity.ok(userProfiles);
    }

    // Получение профиля пользователя по его ID
    @GetMapping("/{id}")
    public ResponseEntity<UserProfileDTO> getUserProfileById(@PathVariable Long id) {
        UserProfileDTO userProfile = userProfileService.getUserProfileById(id);
        return ResponseEntity.ok(userProfile);
    }

    // Сохранение нового профиля пользователя
    @PostMapping
    public ResponseEntity<Void> saveUserProfile(@RequestBody UserProfileDTO userProfileDTO) {
        userProfileService.saveUserProfile(userProfileDTO);
        return ResponseEntity.ok().build(); // Используем OK, так как метод saveUserProfile не возвращает тело ответа
    }
}