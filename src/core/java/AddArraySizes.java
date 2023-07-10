package core.java;

public class AddArraySizes {
	public static void main(String[] args) {
		double[] a={1.1,2.2,3.3,4.4,5.5,6.6,7.7,8.8};
		double[] b={1.0,2.0,3.0,4.0};
		double[] c=AddArraySizes.merge(a,b);
		for(double r:c){
			System.out.println(r);
		}
	}
		static double[] merge(double[] x,double[] y){
			double[] d=new double[x.length+y.length];
			int p=0;
			for(int i=0;i<y.length;i++){
				d[p++]=x[i];
				d[p++]=y[i];			
			}
			for(int i=(y.length*2),k=y.length;i<d.length && k<x.length;i++,k++){
				d[i]=x[k];			
			}	
		return d;
		}
	

}
