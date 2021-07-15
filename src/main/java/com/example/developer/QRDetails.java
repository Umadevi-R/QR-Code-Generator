package com.example.developer;

public class QRDetails {
	private String text;
	private int width;
	private int height;
	
	public QRDetails() {
	}
	public QRDetails(String text, int width, int height) {
		this.text = text;
		this.width = width;
		this.height = height;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
}
