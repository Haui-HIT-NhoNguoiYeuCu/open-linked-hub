package com.openlinkedhub.datasetservice.controller;

import com.openlinkedhub.datasetservice.dto.CreateDatasetInput;
import com.openlinkedhub.datasetservice.dto.UpdateDatasetInput;
import com.openlinkedhub.datasetservice.model.Dataset;
import com.openlinkedhub.datasetservice.service.DatasetService;
// 💡 Import annotations cho Swagger (OpenAPI)
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
// import org.springframework.security.core.Authentication;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/datasets")
@RequiredArgsConstructor
@Tag(name = "Dataset Metadata", description = "API quản lý siêu dữ liệu (metadata) của Dataset") // 💡 Nhóm các API lại
public class DatasetController {

    private final DatasetService datasetService;

    // --- READ OPERATIONS ---

    @GetMapping
    @Operation(summary = "Lấy danh sách tất cả Dataset", description = "Trả về một mảng chứa tất cả siêu dữ liệu Dataset.")
    public ResponseEntity<List<Dataset>> getAllDatasets() {
        List<Dataset> datasets = datasetService.findAll();
        return ResponseEntity.ok(datasets);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Lấy Dataset theo ID", description = "Trả về chi tiết một Dataset dựa trên ID. Tự động tăng view count.")
    @ApiResponses(value = { // 💡 Mô tả các response có thể xảy ra
            @ApiResponse(responseCode = "200", description = "Tìm thấy Dataset"),
            @ApiResponse(responseCode = "404", description = "Không tìm thấy Dataset với ID cung cấp")
    })
    public ResponseEntity<Dataset> getDatasetById(
            @Parameter(description = "ID của Dataset cần lấy") @PathVariable String id) { // 💡 Mô tả parameter
        Optional<Dataset> datasetOpt = datasetService.incrementViewCount(id);
        return datasetOpt
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // --- CREATE OPERATION ---

    @PostMapping
    @Operation(summary = "Tạo Dataset mới", description = "Tạo bản ghi siêu dữ liệu cho một Dataset mới. Yêu cầu xác thực.")
    @ApiResponse(responseCode = "201", description = "Dataset được tạo thành công")
    public ResponseEntity<Dataset> createDataset(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Thông tin Dataset cần tạo") // 💡 Mô tả request body
            @RequestBody CreateDatasetInput input /*, Authentication authentication */) {
        String ownerId = "temp-user";
        Dataset createdDataset = datasetService.create(
                input.getName(),
                input.getDescription(),
                input.getTags(),
                input.getLicense(),
                ownerId
        );
        return ResponseEntity.created(URI.create("/api/v1/datasets/" + createdDataset.getId())).body(createdDataset);
    }

    // --- UPDATE OPERATION ---

    @PutMapping("/{id}")
    @Operation(summary = "Cập nhật Dataset", description = "Cập nhật thông tin siêu dữ liệu cho một Dataset đã tồn tại. Yêu cầu xác thực và quyền sở hữu.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dataset được cập nhật thành công"),
            @ApiResponse(responseCode = "404", description = "Không tìm thấy Dataset với ID cung cấp")
    })
    public ResponseEntity<Dataset> updateDataset(
            @Parameter(description = "ID của Dataset cần cập nhật") @PathVariable String id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Thông tin cần cập nhật")
            @RequestBody UpdateDatasetInput input /*, Authentication authentication */) {
        Optional<Dataset> updatedDatasetOpt = datasetService.update(
                id,
                input.getName(),
                input.getDescription(),
                input.getTags(),
                input.getLicense()
        );
        return updatedDatasetOpt
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // --- DELETE OPERATION ---

    @DeleteMapping("/{id}")
    @Operation(summary = "Xóa Dataset", description = "Xóa bản ghi siêu dữ liệu của một Dataset. Yêu cầu xác thực và quyền sở hữu/admin.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Dataset được xóa thành công"),
            @ApiResponse(responseCode = "404", description = "Không tìm thấy Dataset với ID cung cấp")
    })
    public ResponseEntity<Void> deleteDataset(
            @Parameter(description = "ID của Dataset cần xóa") @PathVariable String id /*, Authentication authentication */) {
        boolean deleted = datasetService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}