package org.example.frontend.client;

import org.example.client.contract.UserProfileDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UserProfileClient {
    private final RestTemplate restTemplate;

    public UserProfileClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private static final String API_BASE_URL = "http://localhost:8080/api/user-profiles";

    // Получение всех профилей
    public List<UserProfileDTO> getAllProfiles() {
        UserProfileDTO[] response = restTemplate.getForObject(API_BASE_URL, UserProfileDTO[].class);
        return Arrays.asList(response);
    }

    // Получение профиля по ID
    public UserProfileDTO getProfileById(Long id) {
        return restTemplate.getForObject(API_BASE_URL + "/" + id, UserProfileDTO.class);
    }

    // Сохранение нового профиля
    public void saveProfile(UserProfileDTO profileDTO) {
        restTemplate.postForObject(API_BASE_URL, profileDTO, UserProfileDTO.class);
    }
}
