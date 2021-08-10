package nz.co.alumi.designSmart.inventory.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
@Document(collection = "product")
public class Product {

  @Id
  public String id;
  public Constants.Type type;
  public String sizeW;
  public String sizeH;
  public String name;
  public String sku;
  public String colorKey;
  public String colorName;
  public String openSideKey;
  public String openSideDescription;
  public int qty;

}
