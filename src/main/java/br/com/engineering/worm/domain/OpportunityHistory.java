package br.com.engineering.worm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import br.com.engineering.worm.domain.enumeration.OpportunityStatus;

/**
 * A OpportunityHistory.
 */
@Entity
@Table(name = "opportunity_history")
public class OpportunityHistory extends Domain
{
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OpportunityStatus status;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties("opportunityHistories")
    private Opportunity opportunity;

    public OpportunityStatus getStatus()
    {
        return status;
    }

    public void setStatus(OpportunityStatus p_status)
    {
        status = p_status;
    }

    public Opportunity getOpportunity()
    {
        return opportunity;
    }

    public void setOpportunity(Opportunity p_opportunity)
    {
        opportunity = p_opportunity;
    }

}
