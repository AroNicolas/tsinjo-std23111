package school.hei.tsinjo.model;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Help {
  private UUID id;
  private Beneficiary beneficiary;
  private Payment payment;
  private String description;
}
