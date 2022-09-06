package br.edu.ifpb.educad.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginForm {

    private String login;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    public UsernamePasswordAuthenticationToken usernameAndPasswordToToken(){
        return new UsernamePasswordAuthenticationToken(login, password);
    }
}
