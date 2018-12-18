package in.com.prestige.dto;

import java.io.Serializable;

public class HomePageDTO  implements Serializable{
   
	public int getPicid() {
		return picid;
	}
	public void setPicid(int picid) {
		this.picid = picid;
	}
	private static final long serialVersionUID = 1L;
	private int picid = 0;
	private String filename = null;
    private String path = null;
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
