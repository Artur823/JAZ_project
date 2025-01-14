package org.example.client.mappers;

import org.example.client.contract.UserProfileDTO;
import org.example.core.model.UserProfile;

public class UserProfileMapper {

    public static UserProfile toEntity(UserProfileDTO dto) {
        UserProfile userProfile = new UserProfile();
        userProfile.setUsername(dto.username());
        userProfile.setEmail(dto.email());
        userProfile.setPreferredCurrency(dto.preferredCurrency());
        userProfile.setBalance(dto.balance());
        userProfile.setLastLogin(dto.lastLogin());
        return userProfile;
    }

    public static UserProfileDTO toDTO(UserProfile entity) {
        return new UserProfileDTO(
                entity.getUsername(),
                entity.getEmail(),
                entity.getPreferredCurrency(),
                entity.getBalance(),
                entity.getLastLogin()
        );
    }
}
