package nz.co.alumi.designSmart.timber.model;

import lombok.*;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class QuestionOption {
    private int id;
    private String description;
    private String value;
}
