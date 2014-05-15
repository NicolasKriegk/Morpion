package model;

public class Plateau {
	
	private int dim1;
	private int dim2;
	
	public Plateau(int dimlong,int dimlarg) {
		
		this.setDim1(dimlong);
		this.setDim2(dimlarg);
		
	}

	public int getDim2() {
		return dim2;
	}

	public void setDim2(int dim2) {
		this.dim2 = dim2;
	}

	public int getDim1() {
		return dim1;
	}

	public void setDim1(int dim1) {
		this.dim1 = dim1;
	}
	
	

}
