package com.javaspring.taskproject.payload;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {
public  long id;
public String name;
public String email;
public String password;
}
