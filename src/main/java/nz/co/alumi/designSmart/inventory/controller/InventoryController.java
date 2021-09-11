package nz.co.alumi.designSmart.inventory.controller;

import java.util.List;
import nz.co.alumi.designSmart.inventory.model.Product;
import nz.co.alumi.designSmart.inventory.service.SashesService;
import nz.co.alumi.designSmart.inventory.service.WindowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/inventory", produces = {MediaType.APPLICATION_JSON_VALUE})
public class InventoryController {

  @Autowired
  private WindowService windowService;

  @Autowired
  private SashesService sashesService;

  @PutMapping(value = "/window", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity createProduct(@RequestBody Product product) {
    return windowService.create(product);
  }

  @GetMapping(value = "/window", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Product>> searchProduct(@RequestParam(name = "sizeW") Integer sizeW,
      @RequestParam(name = "sizeH") Integer sizeH,
      @RequestParam(name = "sku") String sku,
      @RequestParam(name = "inStock", defaultValue = "true") Boolean inStock,
      @RequestParam(name = "inStock", defaultValue = "true") Boolean suggestion,
      @RequestParam(name = "marginWidth", defaultValue = "100") Integer marginWidth,
      @RequestParam(name = "marginHeight", defaultValue = "100") Integer marginHeight) {
    return ResponseEntity.ok(windowService.searchProductInStock(sizeW, sizeH, sku, inStock,marginWidth, marginHeight));
  }

  @GetMapping(value = "/sashes", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Product>> searchProduct(@RequestParam(name = "sizeW") Integer sizeW,
      @RequestParam(name = "sizeH") Integer sizeH,
      @RequestParam(name = "sku") String sku,
      @RequestParam(name = "color") String color
      ) {
    return ResponseEntity.ok(sashesService.searchProductInStock(sizeW, sizeH, sku, color));
  }

  @PutMapping(value = "/sashes", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity createSashes(@RequestBody Product product) {
    return sashesService.create(product);
  }

}
