package ec.gob.turismo.convenios.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomErrorResponse {

    private String data;
    private String detail;
    private String message;
}
