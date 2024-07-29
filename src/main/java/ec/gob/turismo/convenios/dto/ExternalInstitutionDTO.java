package ec.gob.turismo.convenios.dto;

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
public class ExternalInstitutionDTO {

    @EqualsAndHashCode.Include
    private UUID id;

    @NotNull
    private String name;

    @NotNull
    private String position;

    @NotNull
    private String unit;

    @NotNull
    private CatalogueDTO personType;

}
