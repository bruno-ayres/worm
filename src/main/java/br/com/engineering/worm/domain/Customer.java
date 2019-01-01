package br.com.engineering.worm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * A Customer.
 */
@Entity
@Table(name = "customer")
public class Customer extends Domain
{
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "active", nullable = false)
    private Boolean active;

    public String getName()
    {
        return name;
    }

    public void setName(String p_name)
    {
        name = p_name;
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
