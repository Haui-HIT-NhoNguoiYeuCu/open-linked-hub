package com.openlinkedhub.datasetservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;
import java.util.List;

@Document(collection = "datasets")
@Data
public class Dataset {
    @Id private String id;
    private String name;
    private String description;
    private List<String> tags;
    private String license;
    private String ownerId;
    private Instant createdAt;
    private Instant updatedAt;

    private Long viewCount = 0L;
    private Long downloadCount = 0L;
}