package jp.example.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class MessageDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;

	private String message;

}
