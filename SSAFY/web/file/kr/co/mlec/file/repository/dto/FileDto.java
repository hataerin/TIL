package kr.co.mlec.file.repository.dto;

public class FileDto {
	private String path;
	private String orgName;
	private String systemName;
	private String contentType;
	private long size;
	public String getPath() {
		return path;
	}
	public FileDto setPath(String path) {
		this.path = path;
		return this;
	}
	public String getOrgName() {
		return orgName;
	}
	public FileDto setOrgName(String orgName) {
		this.orgName = orgName;
		return this;
	}
	public String getSystemName() {
		return systemName;
	}
	public FileDto setSystemName(String systemName) {
		this.systemName = systemName;
		return this;
	}
	public String getContentType() {
		return contentType;
	}
	public FileDto setContentType(String contentType) {
		this.contentType = contentType;
		return this;
	}
	public long getSize() {
		return size;
	}
	public FileDto setSize(long size) {
		this.size = size;
		return this;
	}
	public void copy(FileDto fileDto) {
		fileDto.setContentType(this.contentType)
			   .setOrgName(orgName)
			   .setSystemName(systemName)
			   .setPath(path)
			   .setSize(size);
	}
}