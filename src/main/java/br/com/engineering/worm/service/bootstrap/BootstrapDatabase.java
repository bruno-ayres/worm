package br.com.engineering.worm.service.bootstrap;

import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import br.com.engineering.worm.domain.Customer;
import br.com.engineering.worm.repository.CustomerRepository;

/**
 * Atualiza as permissões no banco com base nas constantes cadastradas
 */
@Service
public class BootstrapDatabase
{
    @Inject
    private CustomerRepository m_customerRepository;

    @Transactional
    public void run() throws Exception
    {
        createCustomer();
    }
    
    private void createCustomer()
    {
        if (m_customerRepository.count() == 0)
        {
            for (int v_i = 0; v_i < 1000; v_i++)
            {
                Customer v_customer = new Customer();
                v_customer.setActive(true);
                v_customer.setName("Customer " + (v_i + 1));
                m_customerRepository.save(v_customer);                
            }
        }
    }

}
