package jp.example.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserDto implements Serializable {

	private static final long serialVersionUID = 12L;

	private String name;

}
