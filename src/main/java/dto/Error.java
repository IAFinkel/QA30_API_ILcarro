package dto;
//        "code": 0,
//        "details": "string",
//        "message": "string",

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder

public class Error {
    int code;
    String details;
    String message;

}
