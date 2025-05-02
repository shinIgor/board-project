package com.example.boardproject.application.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAccountLt is a Querydsl query type for AccountLt
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAccountLt extends EntityPathBase<AccountLt> {

    private static final long serialVersionUID = -1924435177L;

    public static final QAccountLt accountLt = new QAccountLt("accountLt");

    public final NumberPath<java.math.BigInteger> accountUtId = createNumber("accountUtId", java.math.BigInteger.class);

    public final StringPath beforeData = createString("beforeData");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<java.math.BigInteger> id = createNumber("id", java.math.BigInteger.class);

    public QAccountLt(String variable) {
        super(AccountLt.class, forVariable(variable));
    }

    public QAccountLt(Path<? extends AccountLt> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAccountLt(PathMetadata metadata) {
        super(AccountLt.class, metadata);
    }

}

