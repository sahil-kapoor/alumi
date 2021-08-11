package nz.co.alumi.designSmart.inventory.controller;

import nz.co.alumi.designSmart.inventory.model.Constants;
import nz.co.alumi.designSmart.inventory.model.Product;
import nz.co.alumi.designSmart.inventory.service.InventoryService;
import nz.co.alumi.designSmart.projectManagement.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/inventory",produces = {MediaType.APPLICATION_JSON_VALUE})
public class InventoryController {

  @Autowired
  private InventoryService inventoryService;

  @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Product> createProduct(@RequestParam (required = true, name = "type") Constants.Type type,
                                               @RequestBody Product product) {
    return ResponseEntity.ok(inventoryService.create(product));
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Product> getProduct(@RequestParam (required = false) Product product) {
    return ResponseEntity.ok().build();
  }
}
