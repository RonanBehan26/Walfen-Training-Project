package com.walfen.training.api.football;

public class Seat {
	
	private int number;
	private int row;
	private int column;
	
	public Seat(int number, int row, int column) {
		this.number = number;
		this.row = row;
		this.column = column;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	
	

}
