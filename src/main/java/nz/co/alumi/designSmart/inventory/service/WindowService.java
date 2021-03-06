package nz.co.alumi.designSmart.inventory.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import nz.co.alumi.designSmart.inventory.helper.ProductHelper;
import nz.co.alumi.designSmart.inventory.model.Constants;
import nz.co.alumi.designSmart.inventory.model.ErrorObject;
import nz.co.alumi.designSmart.inventory.model.Product;
import nz.co.alumi.designSmart.inventory.repository.InventoryRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class WindowService {

  @Autowired
  private InventoryRepository inventoryRepository;
  @Autowired
  private ProductHelper productHelper;

  public ResponseEntity create(Product product) {
    product.setType(Constants.ProductType.WINDOW);
    Product dbProduct = inventoryRepository.findByTypeAndSku(product.getType(), product.getSku());
    if (null != dbProduct) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(new ErrorObject("P.401", Constants.WINDOW_MSG_MAP.get("P.401")));
    } else {
      inventoryRepository.save(product);
    }
    return ResponseEntity.ok(product);
  }

  public Product getById(String productId) {
    return inventoryRepository.findById(productId).get();
  }
/*
  public Product updateProduct(Product product){
    Product dbProduct;
    if(product.getSku()!=null)
    dbProduct=inventoryRepository.findBySku(product.getSku());
    return null;
  }*/

  //TODO: rank accordingly.
  public List<Product> searchProductInStock(Integer width, Integer height, String sku,
      boolean inStock,Integer marginW, Integer marginH) {
    List<Product> products = new ArrayList<>();
    if (!StringUtils.isEmpty(sku)) {
      Product dbProduct = inventoryRepository.findBySku(sku);
      if (dbProduct != null) {
        products.add(dbProduct);
      }
    } else {
      List<Product> dbProducts = inventoryRepository.findByType(Constants.ProductType.WINDOW);
      if (CollectionUtils.isNotEmpty(dbProducts)) {
        if (null != width && null != height) {
          List<Product> filterProduct = dbProducts.stream().filter(
              dbProduct -> productHelper.partialMatchWithWidthHeight(width, height, dbProduct))
              .collect(Collectors.toList());
          products.addAll(filterProduct);
        }
        if (null != width) {
          List<Product> filterProducts = dbProducts.stream()
              .filter(dbProduct -> isBetweenMargin(marginW,width,dbProduct.sizeW))
              .collect(Collectors.toList());
          filterProducts.forEach(filterProduct -> {
            if (!products.contains(filterProduct)) {
              products.add(filterProduct);
            }
          });
        }
        if (null != height) {
          List<Product> filterProducts = dbProducts.stream()
              .filter(dbProduct -> isBetweenMargin(marginH,height,dbProduct.sizeH))
              .collect(Collectors.toList());
          filterProducts.forEach(filterProduct -> {
            if (!products.contains(filterProduct)) {
              products.add(filterProduct);
            }
          });
        }
      }
    }
    return products;
  }


  private boolean isBetweenMargin(Integer margin, Integer requestLength, Integer dbLength){
    int lowerLimit=requestLength-margin;
    int upperLimit=requestLength+margin;
    if(dbLength>=lowerLimit && dbLength<=upperLimit)
      return true;
    else
      return false;
  }

}
