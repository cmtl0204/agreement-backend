package ec.gob.turismo.convenios.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import ec.gob.turismo.convenios.model.InternalInstitution;
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
public class InternalInstitutionDetailDTO {

    @EqualsAndHashCode.Include
    private UUID id;

    private CatalogueDTO unit;

    @NotNull
    private CatalogueDTO position;

    @JsonBackReference
    private InternalInstitutionDTO internalInstitution;


}
