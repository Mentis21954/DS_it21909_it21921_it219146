package gr.hua.dit.DistributedSystemsAssignment.dto;

public class UserCustomDto {

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

	public UserCustomDto() {
		
	}
	
	public UserCustomDto(String username, String authority) {
		super();
		this.username = username;
		this.authority = authority;
	}
	
	
	
	
}
