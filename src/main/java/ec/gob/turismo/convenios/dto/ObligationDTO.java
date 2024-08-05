package ec.gob.turismo.convenios.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ObligationDTO {

    @EqualsAndHashCode.Include
    private UUID id;

   @NotNull
   private String institutionName;

    @JsonBackReference
    private AgreementDTO agreement;

    @NotNull
    private CatalogueDTO type;

    @JsonManagedReference
    private List<ObligationDetailDTO> obligationDetails;

}
