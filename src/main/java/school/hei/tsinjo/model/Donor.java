package school.hei.tsinjo.model;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Donor {
  private UUID id;
  private String email;
  private String fullName;
}
