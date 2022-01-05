package gr.hua.dit.DistributedSystemsAssignment.entity;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="application_files")
public class ApplicationFiles {
	@Id
	@Column(name="id")
	private int id;
	@Column(name="data")
	private File data;
	@Column(name="filename")
	private String fileName;
	@Column(name="filesize")
	private String fileSize;
	@Column(name="filetype")
	private String fileType;
	@Column(name="application_id")
	private String applicationId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public File getData() {
		return data;
	}
	public void setData(File data) {
		this.data = data;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	public ApplicationFiles(int id, File data, String fileName, String fileSize, String fileType,
			String applicationId) {
		super();
		this.id = id;
		this.data = data;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.fileType = fileType;
		this.applicationId = applicationId;
	}
	
	public ApplicationFiles() {
		
	}
	
}
