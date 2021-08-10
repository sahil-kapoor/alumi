package nz.co.alumi.designSmart.timber.model;

import lombok.*;

import java.util.List;

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
