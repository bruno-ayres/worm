package br.com.engineering.worm.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDomain is a Querydsl query type for Domain
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QDomain extends EntityPathBase<Domain> {

    private static final long serialVersionUID = -764384039L;

    public static final QDomain domain = new QDomain("domain");

    public final QAbstractAuditingEntity _super = new QAbstractAuditingEntity(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.Instant> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.time.Instant> lastModifiedDate = _super.lastModifiedDate;

    public QDomain(String variable) {
        super(Domain.class, forVariable(variable));
    }

    public QDomain(Path<? extends Domain> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDomain(PathMetadata metadata) {
        super(Domain.class, metadata);
    }

}

