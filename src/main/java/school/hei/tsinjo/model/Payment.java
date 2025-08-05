package school.hei.tsinjo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private UUID id;
    private LocalDateTime date;
    private BigDecimal amount;
    private String method;
}
