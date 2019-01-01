package br.com.engineering.worm.service.mapper;

import br.com.engineering.worm.domain.*;
import br.com.engineering.worm.service.dto.AccountManagerDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity AccountManager and its DTO AccountManagerDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AccountManagerMapper extends EntityMapper<AccountManagerDTO, AccountManager> {



    default AccountManager fromId(Long id) {
        if (id == null) {
            return null;
        }
        AccountManager accountManager = new AccountManager();
        accountManager.setId(id);
        return accountManager;
    }
}
