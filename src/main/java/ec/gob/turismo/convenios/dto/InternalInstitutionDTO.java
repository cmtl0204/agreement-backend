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
public class InternalInstitutionDTO {

    @EqualsAndHashCode.Include
    private UUID id;

    @NotNull
    private String name;

    @NotNull
    private CatalogueDTO position;


    private CatalogueDTO unit;

    @NotNull
    private CatalogueDTO personType;

    @JsonBackReference
    private AgreementDTO agreement;

}
