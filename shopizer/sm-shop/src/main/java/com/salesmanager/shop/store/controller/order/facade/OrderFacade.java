package com.salesmanager.shop.store.controller.order.facade;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.validation.BindingResult;

import com.salesmanager.core.business.exception.ServiceException;
import com.salesmanager.core.model.customer.Customer;
import com.salesmanager.core.model.merchant.MerchantStore;
import com.salesmanager.core.model.order.Order;
import com.salesmanager.core.model.order.OrderTotalSummary;
import com.salesmanager.core.model.payments.Transaction;
import com.salesmanager.core.model.reference.country.Country;
import com.salesmanager.core.model.reference.language.Language;
import com.salesmanager.core.model.shipping.ShippingQuote;
import com.salesmanager.core.model.shipping.ShippingSummary;
import com.salesmanager.core.model.shoppingcart.ShoppingCart;
import com.salesmanager.shop.model.customer.PersistableCustomer;
import com.salesmanager.shop.model.order.PersistableOrder;
import com.salesmanager.shop.model.order.PersistableOrderApi;
import com.salesmanager.shop.model.order.ReadableOrder;
import com.salesmanager.shop.model.order.ReadableOrderList;
import com.salesmanager.shop.model.order.ShopOrder;
import com.salesmanager.shop.model.order.transaction.ReadableTransaction;


public interface OrderFacade {

  ShopOrder initializeOrder(MerchantStore store, Customer customer, ShoppingCart shoppingCart,
      Language language) throws Exception;

  void refreshOrder(ShopOrder order, MerchantStore store, Customer customer,
      ShoppingCart shoppingCart, Language language) throws Exception;

  /**
   * used in website
   **/
  OrderTotalSummary calculateOrderTotal(MerchantStore store, ShopOrder order, Language language)
      throws Exception;

  /**
   * used in the API
   **/
  OrderTotalSummary calculateOrderTotal(MerchantStore store, PersistableOrder order,
      Language language) throws Exception;

  /**
   * process a valid order
   **/
  Order processOrder(ShopOrder order, Customer customer, MerchantStore store, Language language)
      throws ServiceException;

  /**
   * process a valid order against an initial transaction
   **/
  Order processOrder(ShopOrder order, Customer customer, Transaction transaction,
      MerchantStore store, Language language) throws ServiceException;

  /**
   * process a valid order submitted from the API
   **/
  Order processOrder(PersistableOrderApi order, Customer customer, MerchantStore store,
      Language language, Locale locale) throws ServiceException;


  /**
   * creates a working copy of customer when the user is anonymous
   **/
  Customer initEmptyCustomer(MerchantStore store);

  List<Country> getShipToCountry(MerchantStore store, Language language)
      throws Exception;

  /**
   * Get a ShippingQuote based on merchant configuration and items to be shipped
   */
  ShippingQuote getShippingQuote(PersistableCustomer customer, ShoppingCart cart, ShopOrder order,
      MerchantStore store, Language language) throws Exception;

  ShippingQuote getShippingQuote(Customer customer, ShoppingCart cart, PersistableOrder order,
      MerchantStore store, Language language) throws Exception;

  ShippingQuote getShippingQuote(Customer customer, ShoppingCart cart,
      MerchantStore store, Language language) throws Exception;

  /**
   * Creates a ShippingSummary object for OrderTotal calculation based on a ShippingQuote
   */
  ShippingSummary getShippingSummary(ShippingQuote quote, MerchantStore store, Language language);

  /**
   * Validates an order submitted from the web application
   */
  void validateOrder(ShopOrder order, BindingResult bindingResult,
      Map<String, String> messagesResult, MerchantStore store,
      Locale locale) throws ServiceException;

  /**
   * Creates a ReadableOrder object from an orderId
   */
  ReadableOrder getReadableOrder(Long orderId, MerchantStore store, Language language)
      throws Exception;


  /**
   * <p>Method used to fetch all orders associated with customer customer.
   * It will used current customer ID to fetch all orders which has been placed by customer for
   * current store.</p>
   *
   * @param customer currently logged in customer
   * @param store store associated with current customer
   * @return ReadableOrderList
   */

  ReadableOrderList getReadableOrderList(MerchantStore store, Customer customer, int start,
      int maxCount, Language language) throws Exception;


  /**
   * Get a list of Order on which payment capture must be done
   */
  ReadableOrderList getCapturableOrderList(MerchantStore store, Date startDate, Date endDate,
      Language language) throws Exception;

  /**
   * Capture a pre-authorized transaction. Candidate order ids can be obtained from
   * getCapturableOrderList
   */
  ReadableTransaction captureOrder(MerchantStore store, Order order, Customer customer,
      Language language) throws Exception;


  /**
   * Get orders for a given store
   */
  ReadableOrderList getReadableOrderList(MerchantStore store, int start,
      int maxCount, Language language) throws Exception;
}
