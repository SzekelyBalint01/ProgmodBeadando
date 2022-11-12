package pte.progmodbeadando.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;

@Getter
@Setter
public class UpdateUserDto {

    private String email;

    @Min(8)
    private String password;

    private String name;

}
