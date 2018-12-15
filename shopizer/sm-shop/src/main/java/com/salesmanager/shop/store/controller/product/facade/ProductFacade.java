package com.salesmanager.shop.store.controller.product.facade;

import java.util.List;

import com.salesmanager.core.model.catalog.category.Category;
import com.salesmanager.core.model.catalog.product.Product;
import com.salesmanager.core.model.catalog.product.ProductCriteria;
import com.salesmanager.core.model.catalog.product.manufacturer.Manufacturer;
import com.salesmanager.core.model.catalog.product.review.ProductReview;
import com.salesmanager.core.model.merchant.MerchantStore;
import com.salesmanager.core.model.reference.language.Language;
import com.salesmanager.shop.model.catalog.manufacturer.PersistableManufacturer;
import com.salesmanager.shop.model.catalog.manufacturer.ReadableManufacturer;
import com.salesmanager.shop.model.catalog.product.PersistableProduct;
import com.salesmanager.shop.model.catalog.product.PersistableProductReview;
import com.salesmanager.shop.model.catalog.product.ProductPriceEntity;
import com.salesmanager.shop.model.catalog.product.ReadableProduct;
import com.salesmanager.shop.model.catalog.product.ReadableProductList;
import com.salesmanager.shop.model.catalog.product.ReadableProductReview;

public interface ProductFacade {

  PersistableProduct saveProduct(MerchantStore store, PersistableProduct product, Language language)
      throws Exception;

  /**
   * Get a Product by id and store
   */
  ReadableProduct getProduct(MerchantStore store, Long id, Language language) throws Exception;


  /**
   * Reads a product by code
   */
  ReadableProduct getProductByCode(MerchantStore store, String uniqueCode, Language language)
      throws Exception;

  /**
   * Get a product by sku and store
   */
  ReadableProduct getProduct(MerchantStore store, String sku, Language language) throws Exception;

  /**
   * Sets a new price to an existing product
   */
  ReadableProduct updateProductPrice(ReadableProduct product, ProductPriceEntity price,
      Language language) throws Exception;

  /**
   * Sets a new price to an existing product
   */
  ReadableProduct updateProductQuantity(ReadableProduct product, int quantity, Language language)
      throws Exception;

  /**
   * Deletes a product for a given product id
   */
  void deleteProduct(Product product) throws Exception;


  /**
   * Filters a list of product based on criteria
   */
  ReadableProductList getProductListsByCriterias(MerchantStore store, Language language,
      ProductCriteria criterias) throws Exception;


  /**
   * Adds a product to a category
   */
  ReadableProduct addProductToCategory(Category category, Product product, Language language)
      throws Exception;

  /**
   * Removes item from a category
   */
  ReadableProduct removeProductFromCategory(Category category, Product product, Language language)
      throws Exception;


  /**
   * Saves or updates a Product review
   */
  void saveOrUpdateReview(PersistableProductReview review, MerchantStore store, Language language)
      throws Exception;

  /**
   * Deletes a product review
   */
  void deleteReview(ProductReview review, MerchantStore store, Language language) throws Exception;

  /**
   * Get reviews for a given product
   */
  List<ReadableProductReview> getProductReviews(Product product, MerchantStore store,
      Language language) throws Exception;

  /**
   * Creates or saves a manufacturer
   */
  void saveOrUpdateManufacturer(PersistableManufacturer manufacturer, MerchantStore store,
      Language language) throws Exception;

  /**
   * Deletes a manufacturer
   */
  void deleteManufacturer(Manufacturer manufacturer, MerchantStore store, Language language)
      throws Exception;

  /**
   * Get a Manufacturer by id
   */
  ReadableManufacturer getManufacturer(Long id, MerchantStore store, Language language)
      throws Exception;

  /**
   * Get all Manufacturer
   */
  List<ReadableManufacturer> getAllManufacturers(MerchantStore store, Language language)
      throws Exception;

  /**
   * Get related items
   */
  List<ReadableProduct> relatedItems(MerchantStore store, Product product, Language language)
      throws Exception;

}
