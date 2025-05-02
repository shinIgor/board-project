package com.example.boardproject.application.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "board_ut")
public class BoardUt extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_ut_id")
    BigInteger id;

    @Column(name = "owner_user_id")
    BigInteger ownerUserId;

    @Size(max = 200)
    @Column(name = "board_name", length = 200)
    String boardName;

    @Column(name = "board_post")
    String boardPost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "owner_user_id", referencedColumnName = "account_ut_id", insertable = false , updatable = false)
    AccountUt owner;

}
