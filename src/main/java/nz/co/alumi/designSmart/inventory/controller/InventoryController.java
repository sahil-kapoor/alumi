package nz.co.alumi.designSmart.inventory.controller;

import nz.co.alumi.designSmart.inventory.model.Constants;
import nz.co.alumi.designSmart.inventory.model.Product;
import nz.co.alumi.designSmart.inventory.service.WindowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/inventory",produces = {MediaType.APPLICATION_JSON_VALUE})
public class InventoryController {

  @Autowired
  private WindowService windowService;

  @PutMapping(value = "/window",produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity createProduct(@RequestBody Product product) {
    return windowService.create(product);
  }

  @GetMapping(value = "/window",produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Product>> searchProduct(@RequestParam (name = "sizeW") Integer sizeW,
                                                     @RequestParam (name = "sizeH") Integer sizeH,
                                                     @RequestParam (name = "sku") String sku,
                                                     @RequestParam (name = "inStock", defaultValue = "true") Boolean inStock,
                                                     @RequestParam (name = "inStock", defaultValue = "true") Boolean suggestion,
                                                     @RequestParam (name = "marginWidth", defaultValue = "20") Integer marginWidth,
                                                     @RequestParam (name = "marginHeight", defaultValue = "20") Integer marginHeight) {
    return ResponseEntity.ok(windowService.searchProductInStock(sizeW,sizeH,sku,inStock));
  }
}
