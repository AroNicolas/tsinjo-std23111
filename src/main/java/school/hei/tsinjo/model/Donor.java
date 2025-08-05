package school.hei.tsinjo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Donor {
    private UUID id;
    private String email;
    private String fullName;
}