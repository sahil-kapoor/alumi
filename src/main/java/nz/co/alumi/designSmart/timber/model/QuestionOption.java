package nz.co.alumi.designSmart.timber.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class QuestionOption {

  private int id;
  private String description;
  private String value;
}
