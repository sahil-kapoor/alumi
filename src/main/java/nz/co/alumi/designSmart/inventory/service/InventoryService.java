package nz.co.alumi.designSmart.inventory.service;

import java.util.List;
import java.util.Optional;
import nz.co.alumi.designSmart.inventory.model.Constants;
import nz.co.alumi.designSmart.inventory.model.Product;
import nz.co.alumi.designSmart.inventory.repository.InventoryRepository;
import nz.co.alumi.designSmart.projectManagement.model.Project;
import nz.co.alumi.designSmart.projectManagement.repository.ProjectRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

  @Autowired
  private InventoryRepository inventoryRepository;

  public Product create(Product product){
    List<Product> products=inventoryRepository.findByType(product.getType());
    if(CollectionUtils.isNotEmpty(products) && products.
            stream()
            .filter(dbProduct->dbProduct.getName().equalsIgnoreCase(product.getName()))
            .findAny().isPresent()){
      return null;
    }else{
      inventoryRepository.save(product);
    }
    return product;
 }

  public Product getById(String  productId){
    return inventoryRepository.findById(productId).get();
  }

  public Product updateProduct(Product product){
    Product dbProduct;
    if(product.getSku()!=null)
    dbProduct=inventoryRepository.findBySku(product.getSku());
    return null;
  }
  

}
