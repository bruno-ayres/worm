package br.com.engineering.worm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * A AccountManager.
 */
@Entity
@Table(name = "account_manager")
public class AccountManager extends Domain
{

    private static final long serialVersionUID = 1L;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "active", nullable = false)
    private Boolean active;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Boolean getActive()
    {
        return active;
    }

    public void setActive(Boolean p_active)
    {
        active = p_active;
    }
}
