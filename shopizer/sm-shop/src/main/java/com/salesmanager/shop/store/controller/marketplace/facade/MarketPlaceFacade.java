package com.salesmanager.shop.store.controller.marketplace.facade;

import com.salesmanager.core.model.merchant.MerchantStore;
import com.salesmanager.core.model.reference.language.Language;
import com.salesmanager.core.model.system.optin.OptinType;
import com.salesmanager.shop.model.marketplace.ReadableMarketPlace;
import com.salesmanager.shop.model.system.ReadableOptin;

/**
 * Builds market places objects for shop and REST api
 *
 * @author c.samson
 */
public interface MarketPlaceFacade {


  /**
   * Get a MarketPlace from store code
   */
  ReadableMarketPlace get(String store, Language lang) throws Exception;

  /**
   * Finds an optin by merchant and type
   */
  ReadableOptin findByMerchantAndType(MerchantStore store, OptinType type) throws Exception;

}
