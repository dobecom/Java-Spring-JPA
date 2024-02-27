package com.example.javaspringjpa.model.request.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.util.List;

@Schema(description = "List")
@Getter
public class ListIdRequest {
    @Schema(description = "list Id", example = "[1,2,3]", required = true)
    private List<Long> listIds;
}
