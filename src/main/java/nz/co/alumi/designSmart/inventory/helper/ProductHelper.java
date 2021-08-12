package nz.co.alumi.designSmart.inventory.helper;

import nz.co.alumi.designSmart.inventory.model.Constants;
import nz.co.alumi.designSmart.inventory.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductHelper {

  public Product mapProduct(Product product){
    product.setColorName(Constants.WINDOW_COLOR_MAP.get(product.getKey()));
    product.setOpenSideDescription(Constants.WINDOW_SASH_MAP.get(product.getOpenSideKey()));
    return product;
  }
}
