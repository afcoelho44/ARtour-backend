package com.br.artour.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String name;

    private String phone;

    private String email;

    private String password;

    private boolean isAdmin;

}
