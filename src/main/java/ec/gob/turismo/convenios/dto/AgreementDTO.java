package ec.gob.turismo.convenios.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    private Boolean isFinishDate;

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
    private CatalogueDTO origin;

    @NotNull
    private CatalogueDTO type;

    private CatalogueDTO specialType;

    @NotNull
    private AdministratorDTO administrator;

    @NotNull
    private AgreementStateDTO agreementState;

    @NotNull
    @JsonManagedReference
    private Set<InternalInstitutionDTO> internalInstitutions;

    @NotNull
    private List<ExternalInstitutionDTO> externalInstitutions;

}
