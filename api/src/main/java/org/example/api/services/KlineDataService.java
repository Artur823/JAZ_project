package org.example.api.services;

import org.example.client.contract.KlineDataDTO;
import org.example.client.mappers.KlineDataMapper;
import org.example.core.model.KlineData;
import org.example.core.repository.IKlineDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KlineDataService {

    private final IKlineDataRepository IKlineDataRepository;

    public KlineDataService(IKlineDataRepository IKlineDataRepository) {
        this.IKlineDataRepository = IKlineDataRepository;
    }

    public void saveKlineData(KlineDataDTO klineDataDTO) {
        KlineData klineData = KlineDataMapper.toEntity(klineDataDTO);
        IKlineDataRepository.save(klineData);
    }

    public KlineDataDTO getKlineDataById(Long id) {
        return IKlineDataRepository.findById(id)
                .map(KlineDataMapper::toDTO)
                .orElseThrow(() -> new IllegalArgumentException("KlineData not found with id: " + id));
    }

    public List<KlineDataDTO> getAllKlineData() {
        return IKlineDataRepository.findAll().stream()
                .map(KlineDataMapper::toDTO)
                .collect(Collectors.toList());
    }
}
