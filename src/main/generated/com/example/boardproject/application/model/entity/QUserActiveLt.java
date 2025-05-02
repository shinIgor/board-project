package com.example.boardproject.application.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserActiveLt is a Querydsl query type for UserActiveLt
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserActiveLt extends EntityPathBase<UserActiveLt> {

    private static final long serialVersionUID = -827599273L;

    public static final QUserActiveLt userActiveLt = new QUserActiveLt("userActiveLt");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath accessIpAddress = createString("accessIpAddress");

    public final NumberPath<java.math.BigInteger> accountUtId = createNumber("accountUtId", java.math.BigInteger.class);

    public final StringPath activeType = createString("activeType");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<java.math.BigInteger> id = createNumber("id", java.math.BigInteger.class);

    public final DateTimePath<java.time.LocalDateTime> lastProcessedAt = createDateTime("lastProcessedAt", java.time.LocalDateTime.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QUserActiveLt(String variable) {
        super(UserActiveLt.class, forVariable(variable));
    }

    public QUserActiveLt(Path<? extends UserActiveLt> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserActiveLt(PathMetadata metadata) {
        super(UserActiveLt.class, metadata);
    }

}

