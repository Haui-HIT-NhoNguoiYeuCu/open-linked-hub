package com.openlinkedhub.datasetservice.service.impl;

import com.openlinkedhub.datasetservice.model.Dataset;
import com.openlinkedhub.datasetservice.repository.DatasetRepository;
import com.openlinkedhub.datasetservice.service.DatasetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DatasetServiceImpl implements DatasetService {
    private final DatasetRepository datasetRepository;

    @Override public List<Dataset> findAll() { return datasetRepository.findAll(); }
    @Override public Optional<Dataset> findById(String id) { return datasetRepository.findById(id); }

    @Override
    public Dataset create(String name, String description, List<String> tags, String license, String ownerId) {
        Dataset dataset = new Dataset();
        dataset.setName(name); dataset.setDescription(description); dataset.setTags(tags);
        dataset.setLicense(license); dataset.setOwnerId(ownerId); // Tạm thời
        dataset.setCreatedAt(Instant.now()); dataset.setUpdatedAt(Instant.now());
        return datasetRepository.save(dataset);
    }

    @Override
    public Optional<Dataset> update(String id, String name, String description, List<String> tags, String license) {
        return datasetRepository.findById(id).map(existing -> {
            if (name != null) existing.setName(name);
            if (description != null) existing.setDescription(description);
            if (tags != null) existing.setTags(tags);
            if (license != null) existing.setLicense(license);
            existing.setUpdatedAt(Instant.now());
            return datasetRepository.save(existing);
        });
    }

    @Override
    public boolean delete(String id) {
        if (datasetRepository.existsById(id)) {
            datasetRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Dataset> incrementViewCount(String id) {
        return datasetRepository.findById(id).map(dataset -> {
            dataset.setViewCount(dataset.getViewCount() + 1);
            dataset.setUpdatedAt(Instant.now());
            return datasetRepository.save(dataset);
        });
    }

    @Override
    public Optional<Dataset> incrementDownloadCount(String id) {
        return datasetRepository.findById(id).map(dataset -> {
            dataset.setDownloadCount(dataset.getDownloadCount() + 1);
            dataset.setUpdatedAt(Instant.now()); // Cập nhật cả thời gian update
            return datasetRepository.save(dataset);
        });
    }
}