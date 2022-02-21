package gr.hua.dit.DistributedSystemsAssignment.dto;

public class UserEditDto {
	private int id;
	private String username;
	private String authority;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
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
	
	public UserEditDto() {
		super();
	}
	
	public UserEditDto(String username, String authority) {
		super();
		this.username = username;
		this.authority = authority;
	}
	
}
