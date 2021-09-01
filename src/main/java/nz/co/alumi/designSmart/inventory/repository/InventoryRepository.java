package nz.co.alumi.designSmart.inventory.repository;

import java.util.List;
import nz.co.alumi.designSmart.inventory.model.Constants;
import nz.co.alumi.designSmart.inventory.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface InventoryRepository extends MongoRepository<Product, String> {

  List<Product> findByType(Constants.ProductType type);

  @Query("{$and :[{type: ?0},{sku: ?1}]}")
  Product findByTypeAndSku(Constants.ProductType type, String sku);

  List<Product> findBySizeH(String sizeH);

  List<Product> findBySizeW(String sizeW);

  List<Product> findByColorKey(String colorKey);

  Product findBySku(String sku);

  List<Product> findByOpenSideKey(String openSideKey);

  @Query("{$and :[{type: ?0},{qty: {$gte : ?1}}] }")
  List<Product> findProductByTypeInStock(Constants.ProductType type, int qty);

}
