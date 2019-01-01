package br.com.engineering.worm.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.hibernate.proxy.HibernateProxyHelper;
import com.querydsl.core.annotations.Config;

//http://www.querydsl.com/static/querydsl/3.6.5/reference/html/ch03s03.html
@Config(entityAccessors=true)
@MappedSuperclass
public abstract class Domain extends AbstractAuditingEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.getId() == null) ? super.hashCode() : this.getId().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (HibernateProxyHelper.getClassWithoutInitializingProxy(this) != HibernateProxyHelper.getClassWithoutInitializingProxy(obj))
        {
            return false;
        }
        Domain other = (Domain) obj;
        if (this.getId() == null)
        {
            if (other.getId() != null)
            {
                return false;
            }
        }
        else if (this.getId().equals(other.getId()))
        {
            return true;
        }
        return false;
    }

    public String getDefaultDescription()
    {
        return "defaultDescription";
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long p_id)
    {
        id = p_id;
    }
}
