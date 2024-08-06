package ec.gob.turismo.convenios.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
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
public class UserDTO {

    @EqualsAndHashCode.Include
    private UUID id;

    @NotNull
    private String username;

    @NotNull
    private String email;

    @NotNull
    private String name;

    @NotNull
    private String lastname;

 }
