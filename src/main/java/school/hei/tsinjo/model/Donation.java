package school.hei.tsinjo.model;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Donation {
  private UUID id;
  private Donor donor;
  private Payment payment;
}
