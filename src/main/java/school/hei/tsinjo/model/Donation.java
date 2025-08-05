package school.hei.tsinjo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Donation {
    private UUID id;
    private Donor donor;
    private Payment payment;
}
