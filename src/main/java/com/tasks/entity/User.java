package com.tasks.entity;

import java.util.Date;

import com.tasks.util.Constants;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="User_Table")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
		
	@Column(name="id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	@NotBlank(message = Constants.NAME_REQUIRED_MESSAGE)
	@Column(name="user_name")
	private String name;
	
	
	@NotNull(message = Constants.EMAIL_REQUIRED_MESSAGE)
	@Column(name="email")
	private String email;
	

	@NotBlank(message = Constants.PHONENUM_REQUIRED_MESSAGE)
    @Size(min = Constants.PHONENUM_MIN_LENGTH, max = Constants.PHONENUM_MAX_LENGTH, message = "Phone number must be between 10 and 15 characters") // Example constraints, adjust as needed
    @Column
    private String phnNum;
    

	@Column(name="creation_date")
	private Date creationDate;
}
