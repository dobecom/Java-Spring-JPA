package com.example.javaspringjpa.module.user.controller;

import com.example.javaspringjpa.model.request.user.AddUserRequest;
import com.example.javaspringjpa.model.response.user.CreateUserResponse;
import com.example.javaspringjpa.model.response.user.GetUserResponse;
import com.example.javaspringjpa.module.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "user", description = "user api")
@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Create the user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success to create the user",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CreateUserResponse.class))
            )
    })
    @PostMapping
    public ResponseEntity<?> add(@RequestBody @Valid AddUserRequest request) {
        CreateUserResponse response = userService.add(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @Operation(summary = "Get user list")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success to get the user list",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(
                                    schema = @Schema(implementation = GetUserResponse.class)
                            ))
            ),
            @ApiResponse(responseCode = "400", description = "Bad Request the user list",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "{\"message\": \"reason\"}"
                            ))
            ),
            @ApiResponse(responseCode = "404", description = "Not found the user list",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "{\"message\": \"Not found\"}"
                            ))
            ),
    })
    @GetMapping
    public ResponseEntity<?> list(@RequestParam(required = false, defaultValue = "0", value = "page") int page,
                                  @RequestParam(required = false, defaultValue = "20", value = "pageSize") int pageSize) {
        List<GetUserResponse> list = userService.list(page, pageSize);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(list);
    }

    @Operation(summary = "Get the user by email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success to get the user",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GetUserResponse.class))
            ),
            @ApiResponse(responseCode = "400", description = "Bad Request the user",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "{\"message\": \"reason\"}"
                            ))
            ),
            @ApiResponse(responseCode = "404", description = "Not found the user",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "{\"message\": \"Not found\"}"
                            ))
            ),
    })
    @GetMapping("{email}")
    public ResponseEntity<?> getUser(@PathVariable String email) {
        GetUserResponse user = userService.getUserByEmail(email);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(user);
    }

//    @Operation(summary = "Delete users")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Success to delete users"),
//            @ApiResponse(responseCode = "404", description = "User not found",
//                    content = @Content(mediaType = "application/json",
//                            examples = @ExampleObject(
//                                    value = "{\"message\": \"Not found\"}"
//                            ))
//            ),
//    })
//    @DeleteMapping()
//    public ResponseEntity<?> deleteUsers(@RequestBody ListIdRequest request) {
//        userService.deleteUsers(request.getListIds());
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .build();
//    }
}
