package ec.gob.turismo.convenios.dto;

import ec.gob.turismo.convenios.model.Catalogue;
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
    private Catalogue state;

 }
