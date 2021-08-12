package nz.co.alumi.designSmart.inventory.model;


import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {

  @Id
  public String id;
  public Constants.ProductType type;
  public Integer sizeW;
  public Integer sizeH;
  public String name;
  public String key;
  public String sku;
  public String colorKey;
  public String colorName;
  public String openSideKey;
  public String openSideDescription;
  public int qty;
  public Integer priority;

}
