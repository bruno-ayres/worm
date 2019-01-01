package br.com.engineering.worm.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOpportunityHistory is a Querydsl query type for OpportunityHistory
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOpportunityHistory extends EntityPathBase<OpportunityHistory> {

    private static final long serialVersionUID = -1958808874L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOpportunityHistory opportunityHistory = new QOpportunityHistory("opportunityHistory");

    public final QDomain _super = new QDomain(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.Instant> createdDate = _super.createdDate;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.time.Instant> lastModifiedDate = _super.lastModifiedDate;

    public final QOpportunity opportunity;

    public final EnumPath<br.com.engineering.worm.domain.enumeration.OpportunityStatus> status = createEnum("status", br.com.engineering.worm.domain.enumeration.OpportunityStatus.class);

    public QOpportunityHistory(String variable) {
        this(OpportunityHistory.class, forVariable(variable), INITS);
    }

    public QOpportunityHistory(Path<? extends OpportunityHistory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOpportunityHistory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOpportunityHistory(PathMetadata metadata, PathInits inits) {
        this(OpportunityHistory.class, metadata, inits);
    }

    public QOpportunityHistory(Class<? extends OpportunityHistory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.opportunity = inits.isInitialized("opportunity") ? new QOpportunity(forProperty("opportunity"), inits.get("opportunity")) : null;
    }

}

