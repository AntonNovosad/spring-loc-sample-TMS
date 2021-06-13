package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @ToString.Exclude private long id;
    private String login;
    private String name;
    @ToString.Exclude private String password;

}
