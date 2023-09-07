package MatrixCalculator;

import java.util.Scanner;

public class Matrix {
	
	private int rows;
	private int columns;
	private int numbers[][]=new int[1000][1000];
	
	public int getRows() {
		return rows;
	}
	
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	public int getColumns() {
		return columns;
	}
	
	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	public int[][] getNumbers() {
		return this.numbers;
	}
	
	public void setNumbers(){
		
		Scanner scan=new Scanner(System.in);
		
		for(int i=0; i<this.rows; i++) {
			for(int j=0; j<this.columns; j++) {
				System.out.println("Digit the number at row: " + (i+1) + " Column: " + (j+1));
				this.numbers[i][j]=scan.nextInt();
			}
		}
	}
	
	public void showNumbers() {
		
		for(int i=0; i<this.rows; i++) {
			for(int j=0; j<this.columns; j++) {
				System.out.printf("%d ", this.numbers[i][j]);
			}
			System.out.println();
		}
	}
	
	public void matrixSum(int[][] matrix1, int[][] matrix2) {
		for(int i=0; i<this.rows; i++) {
			for(int j=0; j<this.columns; j++) {
				this.numbers[i][j]=matrix1[i][j]+matrix2[i][j];
			}
		}
	}
	
	public void matrixSub(int[][] matrix1, int[][] matrix2) {
		for(int i=0; i<this.rows; i++) {
			for(int j=0; j<this.columns; j++) {
				this.numbers[i][j]=matrix1[i][j]-matrix2[i][j];
			}
		}
	}
	
	public void matricesMult(int[][] matrix1, int[][] matrix2) {
		int sum=0;
		for(int k=0; k<this.rows; k++) {
			for(int i=0; i<this.rows; i++) {
				sum=0;
				for(int j=0; j<this.columns; j++) {
					sum=sum+(matrix1[k][j]*matrix2[j][i]);
				}
				this.numbers[k][i]=sum;
			}
		}
		
	}
}
