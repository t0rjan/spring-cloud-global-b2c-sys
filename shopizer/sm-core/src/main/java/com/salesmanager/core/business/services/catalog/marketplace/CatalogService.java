package com.salesmanager.core.business.services.catalog.marketplace;

import java.util.List;

import com.salesmanager.core.business.exception.ServiceException;
import com.salesmanager.core.business.services.common.generic.SalesManagerEntityService;
import com.salesmanager.core.model.merchant.MerchantStore;

import com.salesmanager.core.model.catalog.marketplace.*;

public interface CatalogService extends SalesManagerEntityService<Long, Catalog> {


  /**
   * Creates a new Catalog
   *
   * @return Catalog
   */
  Catalog create(MerchantStore store, String code) throws ServiceException;

  /**
   * Get a list of Catalog associated with a MarketPlace
   *
   * @return List<Catalog>
   */
  List<Catalog> getCatalogs(MarketPlace marketPlace) throws ServiceException;

  /**
   * Delete a Catalog and related objects
   */
  void delete(Catalog catalog) throws ServiceException;

}
