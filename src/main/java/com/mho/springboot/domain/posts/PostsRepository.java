package com.mho.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// Entity와 Repository클래스는 함께 생성
public interface PostsRepository extends JpaRepository<Posts, Long> { }
