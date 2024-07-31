package ec.gob.turismo.convenios.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class ListAgreementDTO {

    @EqualsAndHashCode.Include
    private UUID id;

    @NotNull
    private String number;

    @NotNull
    private Integer internalNumber;

    @NotNull
    private String name;

//    private AdministratorDTO administrator;
//
//    private List<AdministratorDTO> administrators;
//
//    private AgreementStateDTO agreementState;
//
//    private List<AgreementStateDTO> agreementStates;

    @NotNull
    private LocalDateTime subscribedAt;

    private LocalDateTime endedAt;

    @NotNull
    private Boolean isFinancing;



}
