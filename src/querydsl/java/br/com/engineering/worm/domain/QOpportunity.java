package br.com.engineering.worm.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOpportunity is a Querydsl query type for Opportunity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOpportunity extends EntityPathBase<Opportunity> {

    private static final long serialVersionUID = -1552739362L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOpportunity opportunity = new QOpportunity("opportunity");

    public final QDomain _super = new QDomain(this);

    public final QAccountManager accountManager;

    public final DateTimePath<java.time.Instant> closeDate = createDateTime("closeDate", java.time.Instant.class);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.Instant> createdDate = _super.createdDate;

    public final QCustomer customer;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.time.Instant> lastModifiedDate = _super.lastModifiedDate;

    public final SetPath<OpportunityHistory, QOpportunityHistory> opportunityHistories = this.<OpportunityHistory, QOpportunityHistory>createSet("opportunityHistories", OpportunityHistory.class, QOpportunityHistory.class, PathInits.DIRECT2);

    public final NumberPath<Integer> probability = createNumber("probability", Integer.class);

    public final EnumPath<br.com.engineering.worm.domain.enumeration.OpportunityStatus> status = createEnum("status", br.com.engineering.worm.domain.enumeration.OpportunityStatus.class);

    public final NumberPath<Double> tcv = createNumber("tcv", Double.class);

    public final StringPath title = createString("title");

    public QOpportunity(String variable) {
        this(Opportunity.class, forVariable(variable), INITS);
    }

    public QOpportunity(Path<? extends Opportunity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOpportunity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOpportunity(PathMetadata metadata, PathInits inits) {
        this(Opportunity.class, metadata, inits);
    }

    public QOpportunity(Class<? extends Opportunity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.accountManager = inits.isInitialized("accountManager") ? new QAccountManager(forProperty("accountManager")) : null;
        this.customer = inits.isInitialized("customer") ? new QCustomer(forProperty("customer")) : null;
    }

}

