package br.com.engineering.worm.service.dto;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;
import br.com.engineering.worm.domain.enumeration.OpportunityStatus;

/**
 * A DTO for the Opportunity entity.
 */
public class OpportunityDTO implements Serializable {

    private Long id;

    @NotNull
    private String title;

    @NotNull
    private OpportunityStatus status;

    @NotNull
    private Integer probability;

    @NotNull
    private Double tcv;

    private Instant closeDate;

    private Long customerId;

    private String customerName;

    private Long accountManagerId;

    private String accountManagerName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public OpportunityStatus getStatus() {
        return status;
    }

    public void setStatus(OpportunityStatus status) {
        this.status = status;
    }

    public Integer getProbability() {
        return probability;
    }

    public void setProbability(Integer probability) {
        this.probability = probability;
    }

    public Double getTcv() {
        return tcv;
    }

    public void setTcv(Double tcv) {
        this.tcv = tcv;
    }

    public Instant getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Instant closeDate) {
        this.closeDate = closeDate;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getAccountManagerId() {
        return accountManagerId;
    }

    public void setAccountManagerId(Long accountManagerId) {
        this.accountManagerId = accountManagerId;
    }

    public String getAccountManagerName() {
        return accountManagerName;
    }

    public void setAccountManagerName(String accountManagerName) {
        this.accountManagerName = accountManagerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OpportunityDTO opportunityDTO = (OpportunityDTO) o;
        if (opportunityDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), opportunityDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "OpportunityDTO{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", status='" + getStatus() + "'" +
            ", probability=" + getProbability() +
            ", tcv=" + getTcv() +
            ", closeDate='" + getCloseDate() + "'" +
            ", customer=" + getCustomerId() +
            ", customer='" + getCustomerName() + "'" +
            ", accountManager=" + getAccountManagerId() +
            ", accountManager='" + getAccountManagerName() + "'" +
            "}";
    }
}
