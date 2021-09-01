package nz.co.alumi.designSmart.timber.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class Question {

  private int id;
  private String question;
  private String type;
  private List<QuestionOption> questionOptions;
  private String selectedValue;
}
