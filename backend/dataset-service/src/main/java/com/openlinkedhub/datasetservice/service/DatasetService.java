package com.openlinkedhub.datasetservice.service;

import com.openlinkedhub.datasetservice.model.Dataset;
import java.util.List;
import java.util.Optional;

public interface DatasetService {
    List<Dataset> findAll();
    Optional<Dataset> findById(String id);
    Dataset create(String name, String description, List<String> tags, String license, String ownerId);
    Optional<Dataset> update(String id, String name, String description, List<String> tags, String license);
    boolean delete(String id);
}