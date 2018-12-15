package com.salesmanager.shop.store.controller.content.facade;

import java.util.List;

import com.salesmanager.core.model.content.ContentType;
import com.salesmanager.core.model.merchant.MerchantStore;
import com.salesmanager.core.model.reference.language.Language;
import com.salesmanager.shop.model.content.ContentFolder;
import com.salesmanager.shop.model.content.ReadableContentBox;
import com.salesmanager.shop.model.content.ReadableContentPage;

/**
 * Images and files management
 *
 * @author carlsamson
 */
public interface ContentFacade {


  ContentFolder getContentFolder(String folder, MerchantStore store) throws Exception;

  /**
   * File pth
   */
  String absolutePath(MerchantStore store, String file);

  /**
   * Deletes a file from CMS
   */
  void delete(MerchantStore store, String fileName, String fileType) throws Exception;


  /**
   * Returns page names and urls configured for a given MerchantStore
   */
  List<ReadableContentPage> pages(MerchantStore store, Language language) throws Exception;


  /**
   * Returns page name by code
   */
  ReadableContentPage page(String code, MerchantStore store, Language language) throws Exception;

  /**
   * Returns a content box for a given code and merchant store
   */
  ReadableContentBox box(String code, MerchantStore store, Language language) throws Exception;


  /**
   * Returns content boxes created with code prefix for example return boxes with code starting with
   * <code>_
   */
  List<ReadableContentBox> boxes(ContentType type, String codePrefix, MerchantStore store,
      Language language) throws Exception;

}
