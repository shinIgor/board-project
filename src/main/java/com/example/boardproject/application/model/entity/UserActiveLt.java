package com.example.boardproject.application.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "user_active_lt")
public class UserActiveLt extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_active_lt_id")
    BigInteger id;

    @Column(name = "account_ut_id")
    BigInteger accountUtId;

    @Column(name = "access_ip_address",length = 15)
    @Size(max = 15)
    String accessIpAddress;

    @Column(name = "active_type",length = 255)
    @Size(max = 255)
    String activeType;

    @Column(name = "last_processed_at")
    LocalDateTime lastProcessedAt;

}
