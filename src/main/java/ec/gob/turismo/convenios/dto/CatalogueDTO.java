package ec.gob.turismo.convenios.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CatalogueDTO {

    @EqualsAndHashCode.Include
    private UUID id;

    private boolean enabled;

    private CatalogueDTO parent;

    private String code;

    private String description;

    private String name;

    private Integer sort;

    private String type;

    private boolean required;
}
