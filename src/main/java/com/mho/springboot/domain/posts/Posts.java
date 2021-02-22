package com.mho.springboot.domain.posts;

import com.mho.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Getter
@NoArgsConstructor // 파라미터가없는 기본 생성자 생성
@Entity // 테이블과 링크될 클래스임을 의미 Entity필드에는 Setter를 절대로 생성하지 않는다.
public class Posts extends BaseTimeEntity {

    @Id // PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성규칙 : 스프링부트2.0에서는 IDENTITY를 추가해야만 auto_increment가 활성화
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 해당클래스의 빌더 패턴 클래스 생성 빌더를 쓰는이유 어느필드에 어떤값을 넣을지 명확하게 명시가능
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
