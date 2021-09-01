package nz.co.alumi.designSmart.timber.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TimberLiningQuestionnaire {

  private List<Question> questions;
}
