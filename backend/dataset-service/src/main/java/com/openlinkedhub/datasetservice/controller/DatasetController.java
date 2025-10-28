package com.openlinkedhub.datasetservice.controller;

import com.openlinkedhub.datasetservice.dto.CreateDatasetInput; // Import DTO
import com.openlinkedhub.datasetservice.dto.UpdateDatasetInput; // Import DTO
import com.openlinkedhub.datasetservice.model.Dataset;
import com.openlinkedhub.datasetservice.service.DatasetService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class DatasetController {
    private final DatasetService datasetService;

    @QueryMapping public List<Dataset> allDatasets() { return datasetService.findAll(); }
    @QueryMapping public Dataset datasetById(@Argument String id) { return datasetService.findById(id).orElse(null); }

    @MutationMapping
    public Dataset createDataset(@Argument CreateDatasetInput input) {
        String ownerId = "temp-user";
        return datasetService.create(input.getName(), input.getDescription(), input.getTags(), input.getLicense(), ownerId);
    }

    @MutationMapping
    public Dataset updateDataset(@Argument String id, @Argument UpdateDatasetInput input) {
        return datasetService.update(id, input.getName(), input.getDescription(), input.getTags(), input.getLicense()).orElse(null);
    }

    @MutationMapping
    public boolean deleteDataset(@Argument String id) {
        return datasetService.delete(id);
    }
}