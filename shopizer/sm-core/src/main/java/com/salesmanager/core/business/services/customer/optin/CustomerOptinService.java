package com.salesmanager.core.business.services.customer.optin;

import com.salesmanager.core.business.exception.ServiceException;
import com.salesmanager.core.business.services.common.generic.SalesManagerEntityService;
import com.salesmanager.core.model.merchant.MerchantStore;
import com.salesmanager.core.model.system.optin.CustomerOptin;

/**
 * Used for optin in customers An implementation example is for signin in users
 *
 * @author carlsamson
 */
public interface CustomerOptinService extends SalesManagerEntityService<Long, CustomerOptin> {

  /**
   * Optin a given customer. This has no reference to a specific Customer object but contains only
   * email, first name and lastname
   */
  void optinCumtomer(CustomerOptin optin) throws ServiceException;


  /**
   * Removes a specific CustomerOptin
   */
  void optoutCumtomer(CustomerOptin optin) throws ServiceException;

  /**
   * Find an existing CustomerOptin
   */
  CustomerOptin findByEmailAddress(MerchantStore store, String emailAddress, String code)
      throws ServiceException;


}
