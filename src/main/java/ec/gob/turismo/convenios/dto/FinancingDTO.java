package ec.gob.turismo.convenios.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FinancingDTO {

    @EqualsAndHashCode.Include
    private UUID id;

   @NotNull
   private String institutionName;

   @NotNull
   private double budget;

   @NotNull
   private String paymentMethod;

   @NotNull
   private String source;

    @JsonBackReference
    private AgreementDTO agreement;

}
