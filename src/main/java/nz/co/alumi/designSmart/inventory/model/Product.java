package nz.co.alumi.designSmart.inventory.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
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
  @Indexed
  public Integer sizeW;
  @Indexed
  public Integer sizeH;
  public String name;
  public String key;
  @Indexed
  public String sku;
  public String colorKey;
  public String colorName;
  public String openSideKey;
  public String openSideDescription;
  public int qty;
  public Integer priority;

  @Override
  public int hashCode() {
    return sizeH + sizeW + qty;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Product other = (Product) obj;
    if (sku != other.sku) {
      return false;
    }
    return true;
  }

}
