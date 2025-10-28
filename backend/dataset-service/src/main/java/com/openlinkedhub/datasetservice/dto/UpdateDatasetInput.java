package com.openlinkedhub.datasetservice.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UpdateDatasetInput {
    private String name;
    private String description;
    private List<String> tags;
    private String license;
}