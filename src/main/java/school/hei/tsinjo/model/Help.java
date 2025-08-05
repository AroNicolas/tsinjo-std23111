package school.hei.tsinjo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Help {
    private UUID id;
    private Beneficiary beneficiary;
    private Payment payment;
    private String description;
}
