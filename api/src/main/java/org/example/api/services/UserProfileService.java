package org.example.api.services;

import org.example.client.contract.UserProfileDTO;
import org.example.client.mappers.UserProfileMapper;
import org.example.core.model.UserProfile;
import org.example.core.repository.IUserProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserProfileService {

    private final IUserProfileRepository IUserProfileRepository;

    public UserProfileService(IUserProfileRepository IUserProfileRepository) {
        this.IUserProfileRepository = IUserProfileRepository;
    }

    public void saveUserProfile(UserProfileDTO userProfileDTO) {
        UserProfile userProfile = UserProfileMapper.toEntity(userProfileDTO);
        IUserProfileRepository.save(userProfile);
    }

    public UserProfileDTO getUserProfileById(Long id) {
        return IUserProfileRepository.findById(id)
                .map(UserProfileMapper::toDTO)
                .orElseThrow(() -> new IllegalArgumentException("User profile not found with id: " + id));
    }

    public List<UserProfileDTO> getAllUserProfiles() {
        return IUserProfileRepository.findAll().stream()
                .map(UserProfileMapper::toDTO)
                .collect(Collectors.toList());
    }
}