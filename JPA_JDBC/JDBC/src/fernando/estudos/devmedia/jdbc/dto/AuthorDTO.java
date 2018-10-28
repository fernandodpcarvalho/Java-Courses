package fernando.estudos.devmedia.jdbc.dto;

public class AuthorDTO {
	private Integer authorID;
	private String firstName;
	private String lastname;	
	
	public AuthorDTO() {
		super();
	}

	public AuthorDTO(Integer authorID, String firstName, String lastname) {
		super();
		this.authorID = authorID;
		this.firstName = firstName;
		this.lastname = lastname;
	}

	public Integer getAuthorID() {
		return authorID;
	}
	public void setAuthorID(Integer authorID) {
		this.authorID = authorID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
