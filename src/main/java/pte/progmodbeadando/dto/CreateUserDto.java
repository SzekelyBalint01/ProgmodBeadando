package pte.progmodbeadando.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreateUserDto {

    private String email;

    private String password;

    private String name;

}
