package nz.co.alumi.designSmart.inventory.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import nz.co.alumi.designSmart.inventory.helper.ProductHelper;
import nz.co.alumi.designSmart.inventory.model.Constants;
import nz.co.alumi.designSmart.inventory.model.Constants.ProductType;
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
public class SashesService {

  @Autowired
  private InventoryRepository inventoryRepository;

  @Autowired
  private ProductHelper productHelper;

  public ResponseEntity create(Product product) {
    product.setType(ProductType.SASHES);
    Product dbProduct = inventoryRepository.findByTypeAndSku(product.getType(), product.getSku());
    if (null != dbProduct) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(new ErrorObject("P.401", Constants.WINDOW_MSG_MAP.get("P.401")));
    } else {
      inventoryRepository.save(product);
    }
    return ResponseEntity.ok(product);
  }

  public List<Product> searchProductInStock(Integer width, Integer height, String sku,
      String color) {
    List<Product> products = new ArrayList<>();
    if (!StringUtils.isEmpty(sku)) {
      Product dbProduct = inventoryRepository.findBySku(sku);
      if (dbProduct != null) {
        products.add(dbProduct);
      }
    } else {
      List<Product> dbProducts = inventoryRepository.findByType(ProductType.SASHES);
      if (CollectionUtils.isNotEmpty(dbProducts)) {
        if (null != width && null != height) {
          List<Product> filterProduct = dbProducts.stream().filter(
              dbProduct -> productHelper.partialMatchWithWidthHeightColor(width, height,color,dbProduct))
              .collect(Collectors.toList());
          products.addAll(filterProduct);
        }
      }
    }
    return products;
  }

}
