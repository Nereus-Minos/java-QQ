package QQCommon;

import java.io.Serializable;

//¶ÔÏóÁ÷
public class User implements Serializable{
	private String name;
	private String passage;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassage() {
		return passage;
	}
	public void setPassage(String passage) {
		this.passage = passage;
	}
	
}
