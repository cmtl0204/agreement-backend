package ec.gob.turismo.convenios.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import ec.gob.turismo.convenios.model.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AdministratorDTO {

    @EqualsAndHashCode.Include
    private UUID id;

    @NotNull
    private CatalogueDTO unit;

    @NotNull
    private CatalogueDTO position;

    @JsonBackReference
    private AgreementDTO agreement;

}
