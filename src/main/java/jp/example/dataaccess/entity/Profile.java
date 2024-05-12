package jp.example.dataaccess.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

//@Data
@Entity
@Table(name="profile")
public class Profile implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy  =GenerationType.IDENTITY)
	private int id;

	@NotNull
	private String name;

	private LocalDate birthDay;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	@Override
	public int hashCode() {
		return Objects.hash(birthDay, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profile other = (Profile) obj;
		return Objects.equals(birthDay, other.birthDay) && id == other.id && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", name=" + name + ", birthDay=" + birthDay + "]";
	}

	
}
