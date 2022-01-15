package dto;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder

public class RegRequestDto {
    String email;
    String password;

}
