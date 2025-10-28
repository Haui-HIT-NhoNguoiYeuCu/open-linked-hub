package com.openlinkedhub.datasetservice.repository;

import com.openlinkedhub.datasetservice.model.Dataset;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatasetRepository extends MongoRepository<Dataset, String> {}