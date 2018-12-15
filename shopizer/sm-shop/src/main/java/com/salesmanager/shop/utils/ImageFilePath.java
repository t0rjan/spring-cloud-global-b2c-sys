package com.salesmanager.shop.utils;

import com.salesmanager.core.model.catalog.product.Product;
import com.salesmanager.core.model.catalog.product.manufacturer.Manufacturer;
import com.salesmanager.core.model.merchant.MerchantStore;

public interface ImageFilePath {

  /**
   * Context path configured in shopizer-properties.xml
   */
  public String getContextPath();


  public String getBasePath();

  /**
   * Builds a static content image file path that can be used by image servlet utility for getting
   * the physical image
   */
  public String buildStaticImageUtils(MerchantStore store, String imageName);

  /**
   * Builds a static content image file path that can be used by image servlet utility for getting
   * the physical image by specifying the image type
   */
  public String buildStaticImageUtils(MerchantStore store, String type, String imageName);

  /**
   * Builds a manufacturer image file path that can be used by image servlet utility for getting the
   * physical image
   */
  public String buildManufacturerImageUtils(MerchantStore store, Manufacturer manufacturer,
      String imageName);

  /**
   * Builds a product image file path that can be used by image servlet utility for getting the
   * physical image
   */
  public String buildProductImageUtils(MerchantStore store, Product product, String imageName);

  /**
   * Builds a default product image file path that can be used by image servlet utility for getting
   * the physical image
   */
  public String buildProductImageUtils(MerchantStore store, String sku, String imageName);

  /**
   * Builds a large product image file path that can be used by the image servlet
   */
  public String buildLargeProductImageUtils(MerchantStore store, String sku, String imageName);


  /**
   * Builds a merchant store logo path
   */
  public String buildStoreLogoFilePath(MerchantStore store);

  /**
   * Builds product property image url path
   */
  public String buildProductPropertyImageUtils(MerchantStore store, String imageName);


  /**
   * Builds static file path
   */
  public String buildStaticContentFilePath(MerchantStore store, String fileName);


}
