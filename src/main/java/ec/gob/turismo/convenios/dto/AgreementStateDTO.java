package ec.gob.turismo.convenios.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AgreementStateDTO {

    @EqualsAndHashCode.Include
    private UUID id;

    @NotNull
    private LocalDateTime registeredAt;

    @NotNull
    private CatalogueDTO state;


    @JsonBackReference
    private AgreementDTO agreement;

}
