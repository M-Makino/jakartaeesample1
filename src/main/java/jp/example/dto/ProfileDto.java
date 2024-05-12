package jp.example.dto;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProfileDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	@NotNull
	private String name;

	private LocalDate birthDay;

}
