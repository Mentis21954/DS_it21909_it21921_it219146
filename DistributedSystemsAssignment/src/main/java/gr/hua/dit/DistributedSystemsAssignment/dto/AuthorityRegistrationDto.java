package gr.hua.dit.DistributedSystemsAssignment.dto;

public class AuthorityRegistrationDto {
	
	private String username;
	private String authority;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getAuthority() {
		return authority;
	}
	
	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public AuthorityRegistrationDto(String username, String authority) {
		super();
		this.username = username;
		this.authority = authority;
	}
	
}
