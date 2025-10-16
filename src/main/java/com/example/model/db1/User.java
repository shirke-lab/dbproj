package com.example.model.db1;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   @NotBlank(message = "Name is required")
   @Column(name= "name", nullable=false)
    private String name;
   @NotNull 
   @NotBlank
   @Size(min=10, max=10, message="mobile no. must be exactly 10 digits")
   private String mobileNo;

   // Getters and Setters
public  String getName() {
	return name;
}
public String getMobileNo() { 
	return mobileNo;
}

}
