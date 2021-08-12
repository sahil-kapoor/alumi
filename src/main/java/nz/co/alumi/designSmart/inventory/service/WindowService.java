package nz.co.alumi.designSmart.inventory.service;

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

import java.util.ArrayList;
import java.util.List;

@Service
public class WindowService {

  @Autowired
  private InventoryRepository inventoryRepository;
  @Autowired
  private ProductHelper productHelper;

  public ResponseEntity create(Product product){
    product.setType(Constants.ProductType.WINDOW);
    Product dbProduct=inventoryRepository.findByTypeAndSku(product.getType(),product.getSku());
    if(null!=dbProduct){
     return ResponseEntity.status(HttpStatus.BAD_REQUEST)
         .body(new ErrorObject("P.401",Constants.WINDOW_MSG_MAP.get("P.401")));
    }else{
      inventoryRepository.save(product);
    }
    return ResponseEntity.ok(product);
 }

  public Product getById(String  productId){
    return inventoryRepository.findById(productId).get();
  }
/*
  public Product updateProduct(Product product){
    Product dbProduct;
    if(product.getSku()!=null)
    dbProduct=inventoryRepository.findBySku(product.getSku());
    return null;
  }*/


  public List<Product> searchProductInStock(Integer width, Integer height,String sku){
    List<Product> products=new ArrayList<>();
    List<Product> dbProducts=inventoryRepository.findByType(Constants.ProductType.WINDOW);
    if(CollectionUtils.isNotEmpty(dbProducts)){

    }
    return products;
  }

}
