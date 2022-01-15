package dto;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder

//"registration": true,
//        "status": "string",
//        "token": "string"

public class RegResponceDto {
    boolean registration;
    String status;
    String token;
}
