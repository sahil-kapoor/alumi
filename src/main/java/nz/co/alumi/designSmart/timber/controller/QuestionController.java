package nz.co.alumi.designSmart.timber.controller;

import nz.co.alumi.designSmart.timber.model.Question;
import nz.co.alumi.designSmart.timber.model.QuestionOption;
import nz.co.alumi.designSmart.timber.model.TimberLiningQuestionnaire;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/timber/questions")
public class QuestionController {

  @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<TimberLiningQuestionnaire> getQuestionnaire() {
    return ResponseEntity.ok()
        .body(getTimberLiningQuestionnaire());
  }

  @PutMapping(value = "/{projectId}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity saveQuestion(@PathVariable("projectId") String projectId){
    return ResponseEntity.ok().build();
  }

  @PostMapping(value = "/{projectId}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity updateQuestion(@PathVariable("projectId") String projectId){
    return ResponseEntity.ok().build();
  }

  @GetMapping(value = "/{projectId}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity getQuestion(@PathVariable("projectId") String projectId){
    return ResponseEntity.ok().build();
  }


  private TimberLiningQuestionnaire getTimberLiningQuestionnaire() {
    List<Question> questions = new ArrayList<Question>(){{
      add(getQuestion1());
      add(getQuestion2());
      add(getQuestion3());
      add(getQuestion4());
      add(getQuestion5());
    }};
    return TimberLiningQuestionnaire.builder().questions(questions).build();
  }

  private Question getQuestion1(){
    QuestionOption questionOption1= QuestionOption.builder().id(1).description("Bavel Back Brick").value("Bavel Back Brick").build();
    QuestionOption questionOption2= QuestionOption.builder().id(2).description("Block").value("Block").build();
    QuestionOption questionOption3= QuestionOption.builder().id(3).description("Shiplap").value("Shiplap").build();
    List<QuestionOption> questionOptions=new ArrayList<QuestionOption>() {{
      add(questionOption1);
      add(questionOption2);
      add(questionOption3);
    }};
    return Question.builder()
        .id(1)
        .question("What is the mostly used cladding type?")
        .type("radio")
        .questionOptions(questionOptions)
        .build();
  }

  private Question getQuestion2(){
    QuestionOption questionOption1= QuestionOption.builder().id(1).description("20mm").value("20mm").build();
    QuestionOption questionOption2= QuestionOption.builder().id(2).description("50mm").value("50mm").build();
    List<QuestionOption> questionOptions=new ArrayList<QuestionOption>() {{
      add(questionOption1);
      add(questionOption2);
    }};
    return Question.builder()
        .id(2)
        .question("What is the mostly used cavity space?")
        .type("radio")
        .questionOptions(questionOptions)
        .build();
  }

  private Question getQuestion3(){
    QuestionOption questionOption1= QuestionOption.builder().id(1).description("90mm").value("90mm").build();
    QuestionOption questionOption2= QuestionOption.builder().id(2).description("140mm").value("140mm").build();
    QuestionOption questionOption3= QuestionOption.builder().id(3).description("180mm").value("180mm").build();
    List<QuestionOption> questionOptions=new ArrayList<QuestionOption>() {{
      add(questionOption1);
      add(questionOption2);
      add(questionOption3);
    }};
    return Question.builder()
        .id(3)
        .question("What is the framing width?")
        .type("radio")
        .questionOptions(questionOptions)
        .build();
  }

  private Question getQuestion4(){
    QuestionOption questionOption1= QuestionOption.builder().id(1).description("Yes").value("Yes").build();
    QuestionOption questionOption2= QuestionOption.builder().id(2).description("No").value("No").build();
    List<QuestionOption> questionOptions=new ArrayList<QuestionOption>() {{
      add(questionOption1);
      add(questionOption2);
    }};
    return Question.builder()
        .id(4)
        .question("Does the project use GIB?")
        .type("radio")
        .questionOptions(questionOptions)
        .build();
  }

  private Question getQuestion5(){
    QuestionOption questionOption1= QuestionOption.builder().id(1).description("Grooved").value("Grooved").build();
    QuestionOption questionOption2= QuestionOption.builder().id(2).description("Architrave").value("Architrave").build();
    List<QuestionOption> questionOptions=new ArrayList<QuestionOption>() {{
      add(questionOption1);
      add(questionOption2);
    }};
    return Question.builder()
        .id(5)
        .question("What is the liner type?")
        .type("radio")
        .questionOptions(questionOptions)
        .build();

  }
}
