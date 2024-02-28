package com.example.javaspringjpa.module.user.service;

import com.example.javaspringjpa.entity.User;
import com.example.javaspringjpa.model.request.user.CreateUserRequest;
import com.example.javaspringjpa.model.response.user.CreateUserResponse;
import com.example.javaspringjpa.model.response.user.GetUserResponse;
import com.example.javaspringjpa.module.user.repository.UserQuerydslRepository;
import com.example.javaspringjpa.module.user.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

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

    public GetUserResponse getUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            return GetUserResponse.builder()
                    .email(user.get().getEmail())
                    .name(user.get().getName())
                    .build();
        } else {
            throw new IllegalArgumentException("User not found" + email);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
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
