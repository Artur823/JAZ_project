package org.example.frontend.frontendControllersWeb;

import org.example.client.contract.UserProfileDTO;
import org.example.frontend.client.UserProfileClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user-profiles")
public class UserProfileWebController {

    private final UserProfileClient userProfileClient;

    @Autowired
    public UserProfileWebController(UserProfileClient userProfileClient) {
        this.userProfileClient = userProfileClient;
    }

    // Отображение списка всех профилей пользователей
    @GetMapping
    public String listUserProfiles(Model model) {
        model.addAttribute("userProfiles", userProfileClient.getAllProfiles()); // Исправлено название метода
        return "user-profiles/list"; // Шаблон для отображения списка профилей
    }

    // Отображение деталей конкретного профиля пользователя по ID
    @GetMapping("/{id}")
    public String viewUserProfileDetails(@PathVariable Long id, Model model) {
        model.addAttribute("userProfile", userProfileClient.getProfileById(id)); // Исправлено название метода
        return "user-profiles/details"; // Шаблон для отображения подробностей профиля
    }

    // Отображение формы для создания нового профиля пользователя
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("userProfile", new UserProfileDTO(null, null, null, null, null)); // Передаем пустой профиль для формы
        return "user-profiles/form"; // Шаблон для формы создания нового профиля
    }

    // Обработка данных формы для сохранения нового профиля
    @PostMapping
    public String saveUserProfile(@ModelAttribute UserProfileDTO userProfileDTO) {
        userProfileClient.saveProfile(userProfileDTO); // Сохраняем профиль через клиент
        return "redirect:/user-profiles"; // Перенаправление на список профилей после сохранения
    }
}
