package com.example.admin.repository;

import com.example.admin.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    // username으로 사용자 찾기 (로그인용)
    Optional<Users> findByUsername(String username);

    // email로 사용자 찾기
    Optional<Users> findByEmail(String email);

    // username 중복 체크
    boolean existsByUsername(String username);

    // email 중복 체크
    boolean existsByEmail(String email);
}