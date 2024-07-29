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
public class AgreementDTO {

    @EqualsAndHashCode.Include
    private UUID id;

    @NotNull
    private String number;

    @NotNull
    private Integer internalNumber;

    @NotNull
    private String name;

    @NotNull
    private LocalDateTime subscribedAt;

    @NotNull
    private LocalDateTime startedAt;

    @NotNull
    private boolean isFinishDate;

    private LocalDateTime endedAt;

    private String endedReason;

    @NotNull
    private Integer yearTerm;

    @NotNull
    private Integer monthTerm;

    @NotNull
    private Integer dayTerm;

    @NotNull
    private String objective;

    @NotNull
    private boolean isFinancing;

    @NotNull
    private boolean isAddendum;

    private CatalogueDTO origin;

    private CatalogueDTO type;

}
