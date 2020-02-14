package bbs;

public class Bbs {
	
	private String bbsID;
	private String bbsTitle;
	private String userID;
	private String bbsDate;
	private String bbsContent;
	private String bbsAvailable;
	
	public Bbs() {
		
	}
	
	public String getBbsID() {
		return bbsID;
	}
	public void setBbsID(String bbsID) {
		this.bbsID = bbsID;
	}
	public String getBbsTitle() {
		return bbsTitle;
	}
	public void setBbsTitle(String bbsTitle) {
		this.bbsTitle = bbsTitle;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getBbsDate() {
		return bbsDate;
	}
	public void setBbsDate(String bbsDate) {
		this.bbsDate = bbsDate;
	}
	public String getBbsContent() {
		return bbsContent;
	}
	public void setBbsContent(String bbsContent) {
		this.bbsContent = bbsContent;
	}
	public String getBbsAvailable() {
		return bbsAvailable;
	}
	public void setBbsAvailable(String bbsAvailable) {
		this.bbsAvailable = bbsAvailable;
	}

}
