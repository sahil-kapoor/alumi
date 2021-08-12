package nz.co.alumi.designSmart.inventory.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class ErrorObject {

  private String applicationCode;
  private String message;
}
