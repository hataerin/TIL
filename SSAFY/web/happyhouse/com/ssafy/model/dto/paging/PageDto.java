package com.ssafy.model.dto.paging;

public class PageDto {
	private int pageNo;
	private int listSize;
	
	public PageDto() {
		this(1, 10);
//		this.pageNo = 1;
//		this.listSize = 10;
	}
	public PageDto(int pageNo) {
		this(pageNo, 10);
//		this.pageNo = pageNo;
//		this.listSize = 10;
	}
	public PageDto(int pageNo, int listSize) {
		this.pageNo = pageNo;
		this.listSize = listSize;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getListSize() {
		return listSize;
	}
	public void setListSize(int listSize) {
		this.listSize = listSize;
	}
	public int getBegin() {
		return listSize * (pageNo - 1);
	}
	
	
}
