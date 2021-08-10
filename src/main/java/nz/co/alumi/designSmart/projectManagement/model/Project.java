package nz.co.alumi.designSmart.projectManagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.time.LocalDate;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class Project {

  @Id
  private String id;
  @NotBlank
  private String projectName;
  private String state;
  @NotBlank
  private String clientName;
  @NotBlank
  private String contactPerson;
  @NotBlank
  private String contactEmail;
  @NotBlank
  private String contactNumber;
  private String deliveryOption;
  @JsonFormat(pattern = "dd-MM-yyyy")
  @DateTimeFormat(pattern = "dd-MM-yyyy")
  private LocalDate estimateDeliveryDate;
  private int version;
  private String previousVersionId;
  @CreatedDate
  private Instant createdDate;
  @LastModifiedDate
  private Instant lastModifiedDate;

}
