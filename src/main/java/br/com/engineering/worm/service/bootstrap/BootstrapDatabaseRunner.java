package br.com.engineering.worm.service.bootstrap;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class BootstrapDatabaseRunner implements InitializingBean
{
    @Inject
    private BootstrapDatabase m_bootstrapDatabase;

    @Override public void afterPropertiesSet() throws Exception
    {
        m_bootstrapDatabase.run();
    }
}
