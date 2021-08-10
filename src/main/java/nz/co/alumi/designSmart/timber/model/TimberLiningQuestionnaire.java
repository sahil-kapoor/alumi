package nz.co.alumi.designSmart.timber.model;

import lombok.*;

import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TimberLiningQuestionnaire {
    private List<Question> questions;
}
