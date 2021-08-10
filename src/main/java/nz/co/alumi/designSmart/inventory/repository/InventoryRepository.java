package nz.co.alumi.designSmart.inventory.repository;

import nz.co.alumi.designSmart.inventory.model.Constants;
import nz.co.alumi.designSmart.inventory.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface InventoryRepository extends MongoRepository<Product, String> {
  public List<Product> findByType(Constants.Type type);
  public List<Product> findBySizeH(String sizeH);
  public List<Product> findBySizeW(String sizeW);
  public List<Product> findByColorKey(String colorKey);
  public Product findBySku(String sku);
  public List<Product> findByOpenSideKey(String openSideKey);
}
