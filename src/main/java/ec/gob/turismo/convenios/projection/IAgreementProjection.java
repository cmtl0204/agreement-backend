package ec.gob.turismo.convenios.projection;

import java.time.LocalDateTime;
import java.util.UUID;

public interface IAgreementProjection {

    UUID getId();

    String getNumber();

    Integer getInternalNumber();

    String getName();

    LocalDateTime getSubscribedAt();

    LocalDateTime getEndedAt();

    Boolean getIsFinancing();

}
