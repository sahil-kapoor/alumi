package nz.co.alumi.designSmart.inventory.service;

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
    inventoryRepository.findByType(product.getType());
    return inventoryRepository.save(product);
  }

  public Product getById(String  productId){
    return inventoryRepository.findById(productId).get();
  }

}
