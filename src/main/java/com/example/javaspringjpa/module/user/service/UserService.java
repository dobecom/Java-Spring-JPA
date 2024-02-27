package com.example.javaspringjpa.module.user.service;

import com.example.javaspringjpa.entity.User;
import com.example.javaspringjpa.model.request.user.CreateUserRequest;
import com.example.javaspringjpa.model.response.user.CreateUserResponse;
import com.example.javaspringjpa.model.response.user.GetUserResponse;
import com.example.javaspringjpa.module.user.repository.UserQuerydslRepository;
import com.example.javaspringjpa.module.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserQuerydslRepository userQuerydslRepository;

    public UserService(UserRepository userRepository, UserQuerydslRepository userQuerydslRepository) {
        this.userRepository = userRepository;
        this.userQuerydslRepository = userQuerydslRepository;
    }

    public CreateUserResponse create(CreateUserRequest request) {
        // TODO: encrypt password
        final User user = userRepository.save(request.toEntity());

        return CreateUserResponse.builder()
                .userId(user.getId())
                .build();
    }

    public List<GetUserResponse> list(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.ASC, "id"));
        Page<User> result = userRepository.findAll(pageable);

        return result.getContent().stream().map(
                user -> GetUserResponse.builder()
                        .email(user.getEmail())
                        .name(user.getName())
                        .build()
        ).toList();
    }

    public GetUserResponse findUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return GetUserResponse.builder()
                    .email(user.get().getEmail())
                    .name(user.get().getName())
                    .build();
        } else {
            throw new IllegalArgumentException("User not found" + id);
        }
    }

//    @Transactional
//    public void deleteUsers(List<Long> listIds) {
//        try {
//            Long count = userQuerydslRepository.deleteByIds(listIds);
//            if (count != listIds.size()) {
//                throw new NoSuchElementException("User not found");
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
}
