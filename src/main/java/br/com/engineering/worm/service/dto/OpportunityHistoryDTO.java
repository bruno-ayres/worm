package br.com.engineering.worm.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;
import br.com.engineering.worm.domain.enumeration.OpportunityStatus;

/**
 * A DTO for the OpportunityHistory entity.
 */
public class OpportunityHistoryDTO implements Serializable {

    private Long id;

    @NotNull
    private OpportunityStatus status;

    private Long opportunityId;

    private String opportunityTitle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OpportunityStatus getStatus() {
        return status;
    }

    public void setStatus(OpportunityStatus status) {
        this.status = status;
    }

    public Long getOpportunityId() {
        return opportunityId;
    }

    public void setOpportunityId(Long opportunityId) {
        this.opportunityId = opportunityId;
    }

    public String getOpportunityTitle() {
        return opportunityTitle;
    }

    public void setOpportunityTitle(String opportunityTitle) {
        this.opportunityTitle = opportunityTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OpportunityHistoryDTO opportunityHistoryDTO = (OpportunityHistoryDTO) o;
        if (opportunityHistoryDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), opportunityHistoryDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "OpportunityHistoryDTO{" +
            "id=" + getId() +
            ", status='" + getStatus() + "'" +
            ", opportunity=" + getOpportunityId() +
            ", opportunity='" + getOpportunityTitle() + "'" +
            "}";
    }
}
