package jp.example.dto;

import java.util.Objects;

public class Sample {
	
	private String q;
	
	private String q2;
	
	private String id;
	
	private String trailingString;
	
	private String userAgentString;
	
	private String jssessionId;
	
	private String matrix;

	
	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	public String getQ2() {
		return q2;
	}

	public void setQ2(String q2) {
		this.q2 = q2;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTrailingString() {
		return trailingString;
	}

	public void setTrailingString(String trailingString) {
		this.trailingString = trailingString;
	}

	public String getUserAgentString() {
		return userAgentString;
	}

	public void setUserAgentString(String userAgentString) {
		this.userAgentString = userAgentString;
	}

	public String getJssessionId() {
		return jssessionId;
	}

	public void setJssessionId(String jssessionId) {
		this.jssessionId = jssessionId;
	}

	public String getMatrix() {
		return matrix;
	}

	public void setMatrix(String matrix) {
		this.matrix = matrix;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, jssessionId, matrix, q, q2, trailingString, userAgentString);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sample other = (Sample) obj;
		return Objects.equals(id, other.id) && Objects.equals(jssessionId, other.jssessionId)
				&& Objects.equals(matrix, other.matrix) && Objects.equals(q, other.q) && Objects.equals(q2, other.q2)
				&& Objects.equals(trailingString, other.trailingString)
				&& Objects.equals(userAgentString, other.userAgentString);
	}

	@Override
	public String toString() {
		return "Sample [q=" + q + ", q2=" + q2 + ", id=" + id + ", trailingString=" + trailingString
				+ ", userAgentString=" + userAgentString + ", jssessionId=" + jssessionId + ", matrix=" + matrix + "]";
	}
	
	

}
