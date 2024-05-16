package com.tasks.bo;


import java.util.Date;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserBO {
	
	 
    private String name;
    private String email;
    private String phnNum;
   
}