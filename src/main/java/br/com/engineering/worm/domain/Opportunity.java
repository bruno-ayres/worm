package br.com.engineering.worm.domain;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import br.com.engineering.worm.domain.enumeration.OpportunityStatus;

/**
 * A Opportunity.
 */
@Entity
@Table(name = "opportunity")
public class Opportunity extends Domain
{
    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OpportunityStatus status;

    @NotNull
    @Column(name = "probability", nullable = false)
    private Integer probability;

    @NotNull
    @Column(name = "tcv", nullable = false)
    private Double tcv;

    @Column(name = "close_date")
    private Instant closeDate;

    @OneToMany(mappedBy = "opportunity")
    private Set<OpportunityHistory> opportunityHistories = new HashSet<>();

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties("")
    private Customer customer;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties("")
    private AccountManager accountManager;

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String p_title)
    {
        title = p_title;
    }

    public OpportunityStatus getStatus()
    {
        return status;
    }

    public void setStatus(OpportunityStatus p_status)
    {
        status = p_status;
    }

    public Integer getProbability()
    {
        return probability;
    }

    public void setProbability(Integer p_probability)
    {
        probability = p_probability;
    }

    public Double getTcv()
    {
        return tcv;
    }

    public void setTcv(Double p_tcv)
    {
        tcv = p_tcv;
    }

    public Instant getCloseDate()
    {
        return closeDate;
    }

    public void setCloseDate(Instant p_closeDate)
    {
        closeDate = p_closeDate;
    }

    public Set<OpportunityHistory> getOpportunityHistories()
    {
        return opportunityHistories;
    }

    public void setOpportunityHistories(Set<OpportunityHistory> p_opportunityHistories)
    {
        opportunityHistories = p_opportunityHistories;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer p_customer)
    {
        customer = p_customer;
    }

    public AccountManager getAccountManager()
    {
        return accountManager;
    }

    public void setAccountManager(AccountManager p_accountManager)
    {
        accountManager = p_accountManager;
    }
 }
