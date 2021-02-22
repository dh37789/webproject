package com.mho.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // JPA Entity BaseTimeEntity를 상속 할 경우 (createDate, modifiedDate 필드들을 자동으로 생성해줌)
@EntityListeners(AuditingEntityListener.class) // auditing기능을 추가 한다. 자동으로 시간값을 넣어줌
public class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;


}
