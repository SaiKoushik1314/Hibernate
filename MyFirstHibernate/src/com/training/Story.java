package com.training;
// Generated Nov 25, 2015 2:41:38 PM by Hibernate Tools 4.3.1.Final

/**
 * Story generated by hbm2java
 */

public class Story implements java.io.Serializable {

	private int storyId;
	private String storyName;
	private Writer writer;

	public Story() {
	}

	public Story(String storyName, Writer writer) {
		this.storyName = storyName;
		this.writer = writer;
	}

	public int getStoryId() {
		return this.storyId;
	}

	public void setStoryId(int storyId) {
		this.storyId = storyId;
	}

	public String getStoryName() {
		return this.storyName;
	}

	public void setStoryName(String storyName) {
		this.storyName = storyName;
	}

	public Writer getWriter() {
		return this.writer;
	}

	public void setWriter(Writer writer) {
		this.writer = writer;
	}

}
