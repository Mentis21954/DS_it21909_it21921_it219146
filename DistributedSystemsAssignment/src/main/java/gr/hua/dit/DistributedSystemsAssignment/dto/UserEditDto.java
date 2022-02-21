package gr.hua.dit.DistributedSystemsAssignment.dto;

public class UserEditDto {
	private String username;
	private int authority;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getAuthority() {
		return authority;
	}
	
	public void setAuthority(int authority) {
		this.authority = authority;
	}
	
	public UserEditDto() {
		super();
	}
	
	public UserEditDto(String username, int authority) {
		super();
		this.username = username;
		this.authority = authority;
	}
	
}
