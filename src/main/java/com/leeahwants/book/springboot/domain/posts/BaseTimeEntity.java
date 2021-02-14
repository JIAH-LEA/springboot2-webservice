package com.leeahwants.book.springboot.domain.posts;
//DB layer 접근자 (Dao) JpaRepository<Entity class, pk type>
import com.leeahwants.book.springboot.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;


import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

}