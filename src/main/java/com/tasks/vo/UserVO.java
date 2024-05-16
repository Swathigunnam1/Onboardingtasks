package com.tasks.vo;

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
public class UserVO {
	
	private long id;
    private String name;
    private String email;
    private String phnNum;
    private Date creationDate;


}
