package MatrixCalculator;

import java.util.Scanner;

public class MatrixCalculator {
	
	static Matrix matrix1=new Matrix();
	static Matrix matrix2=new Matrix();
	static Matrix matrixR=new Matrix();
		
	public static boolean sizeCheck(int Size) {
		if(Size<=0) {
			System.out.println("The numbers of rows or columns can't be negative or equal to zero");
			return false;
		}else {
			return true;
		}
	}
	
	public static void matricesSizesGet() {
		
		Scanner scan=new Scanner(System.in);
		boolean check=false;
		do {
			System.out.println("Enter the number of rows of the first matrix:");
			matrix1.setRows(scan.nextInt());
			check=sizeCheck(matrix1.getRows());
		}while(check==false);
		do {
			System.out.println("Enter the number of columns of the first matrix:");
			matrix1.setColumns(scan.nextInt());
			check=sizeCheck(matrix1.getColumns());
		}while(check==false);
		do {
			System.out.println("Enter the number of rows of the second matrix:");
			matrix2.setRows(scan.nextInt());
			check=sizeCheck(matrix2.getRows());
		}while(check==false);
		do {
			System.out.println("Enter the number of columns of the second matrix:");
			matrix2.setColumns(scan.nextInt());
			check=sizeCheck(matrix1.getColumns());
		}while(check==false);
	}
	
	public static void matricesSetMult() {
		
		System.out.println("Pay attention! In orde to multiply two matrices, the first matrix must have the same number of columns as the second matrix has rows");
		
		matricesSizesGet();
		
		if(matrix1.getColumns()!=matrix2.getRows()) {
			System.out.println("You can't do the multiplication of this two matrices, returning to the menu");
			return;
		}
		
		System.out.println("Enter the numbers of the first matrix:");
		matrix1.setNumbers();
		System.out.println("Enter the numbers of the second matrix:");
		matrix2.setNumbers();
		
		matrixR.setRows(matrix1.getRows());
		matrixR.setColumns(matrix2.getColumns());
	}
	
	public static void matricesSet() {
		
		System.out.println("Pay attention! In order to do the sum or sub of two matrices, is necessary to both have the same numbers of columns and rows");

		matricesSizesGet();
		
		if(matrix1.getRows()!=matrix2.getRows() || matrix1.getColumns()!= matrix2.getColumns()) {
			System.out.println("You can't do the sum of this two matrices, returning to the menu");
			return;
		}
		
		System.out.println("Enter the numbers of the first matrix:");
		matrix1.setNumbers();
		System.out.println("Enter the numbers of the second matrix:");
		matrix2.setNumbers();
		
		matrixR.setRows(matrix1.getRows());
		matrixR.setColumns(matrix2.getColumns());
	}
	
	public static void menu() {
		
		Scanner scan=new Scanner(System.in);
		int op;
		
		System.out.println("Welcome to the matrices calculator");
		
		do {
			System.out.println("Chose your option:\n1-Sum 2-Subtract 3-multiply 4-Exit");
			op=scan.nextInt();
			
			if(op!=1 && op!=2 && op!=3 && op!=4) {
				System.out.println("Invalid option, please try again");
			}
			
			if(op==1) {
				matricesSet();
				matrixR.matrixSum(matrix1.getNumbers(), matrix2.getNumbers());
				matrixR.showNumbers();
			}
			if(op==2) {
				matricesSet();
				matrixR.matrixSub(matrix1.getNumbers(), matrix2.getNumbers());
				matrixR.showNumbers();
			}
			if(op==3) {
				matricesSetMult();
				matrixR.matricesMult(matrix1.getNumbers(), matrix2.getNumbers());
				matrixR.showNumbers();
			}
			
		}while(op!=4);
		
		scan.close();
	}
	
	public static void main(String[] args) {
		menu();
		System.out.println("------END------");
	}

}
