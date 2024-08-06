package ec.gob.turismo.convenios.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import ec.gob.turismo.convenios.model.MyFile;
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

    private Integer yearTerm;

    private Integer monthTerm;

    private Integer dayTerm;

    @NotNull
    private String objective;

    @NotNull
    private CatalogueDTO origin;

    @NotNull
    private CatalogueDTO type;

    private CatalogueDTO specialType;

    @NotNull
    private Boolean isFinancing;

    @NotNull
    @JsonManagedReference
    private AdministratorDTO administrator;

    @NotNull
    @JsonManagedReference
    private AgreementStateDTO agreementState;

    @NotNull
    @JsonManagedReference
    private List<InternalInstitutionDTO> internalInstitutions;

    @NotNull
    @JsonManagedReference
    private List<ExternalInstitutionDTO> externalInstitutions;

    @NotNull
    @JsonManagedReference
    private List<ObligationDTO> obligations;

    @JsonManagedReference
    private List<FinancingDTO> financings;

    private List<MyFile> files;

}
