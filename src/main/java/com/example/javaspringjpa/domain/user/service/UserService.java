package com.example.javaspringjpa.domain.user.service;

import com.example.javaspringjpa.domain.user.presentation.request.SignInRequest;
import com.example.javaspringjpa.entity.User;
import com.example.javaspringjpa.domain.user.presentation.request.SignUpRequest;
import com.example.javaspringjpa.domain.user.presentation.response.CreateUserResponse;
import com.example.javaspringjpa.domain.user.presentation.response.GetUserResponse;
import com.example.javaspringjpa.domain.user.repository.UserQuerydslRepository;
import com.example.javaspringjpa.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserQuerydslRepository userQuerydslRepository;


    public CreateUserResponse add(SignUpRequest request) {
        try {
            final User user = userRepository.save(
                    User.builder()
                            .email(request.getEmail())
                            .password(bCryptPasswordEncoder.encode(request.getPassword()))
                            .name(request.getName())
                            .build()
            );

            return CreateUserResponse.builder()
                    .userId(user.getId())
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    public String signIn(SignInRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        if (!bCryptPasswordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Password not matched");
        }
        // TODO:
        return "success";
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
