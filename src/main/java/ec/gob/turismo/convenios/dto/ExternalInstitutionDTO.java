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
public class ExternalInstitutionDTO {

    @EqualsAndHashCode.Include
    private UUID id;

    @NotNull
    private String name;

    @NotNull
    private CatalogueDTO personType;

    @JsonBackReference
    private AgreementDTO agreement;

    @JsonManagedReference
    private List<ExternalInstitutionDetailDTO> externalInstitutionDetails;

}
