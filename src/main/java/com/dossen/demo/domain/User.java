package com.dossen.demo.domain;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private Long  id;
    private String userName;
    private String passWord;
    private String realName;
}
