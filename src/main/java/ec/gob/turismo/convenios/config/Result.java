package ec.gob.turismo.convenios.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result <T>{

    private T data;

    private String message;

    private String detail;

   /* public Result(T data, String message, String detail) {
        this.data = data;
        this.message = message;
        this.detail = detail;
    }*/

}
