public class Polynomial{
	public double[] coefficients;
	
	public Polynomial(){
		this.coefficients = new double[1];
		this.coefficients[0] = 0;
	}

	public Polynomial(double[] coefficients){
		this.coefficients = new double[coefficients.length];
		for(int i = 0; i < coefficients.length; i++){
			this.coefficients[i] = coefficients[i];
		}
		
	}

	public Polynomial add(Polynomial add_poly){
		double[] coefficients;
		int longest;

		if (this.coefficients.length > add_poly.coefficients.length){
			longest = this.coefficients.length;
		}
		else{
			longest = add_poly.coefficients.length;
		}

		coefficients = new double[longest];

		int idx = 0;
		while (idx < longest){
			if (idx >= this.coefficients.length){ //add poly is longer than this.poly
				coefficients[idx] = add_poly.coefficients[idx];
			}
			else if (idx >= add_poly.coefficients.length){ //add poly is shorter than this.poly
				coefficients[idx] = this.coefficients[idx];
			}
			else { //regular case
				coefficients[idx] = add_poly.coefficients[idx] + this.coefficients[idx];
			}
			idx++;
		}

		Polynomial sum = new Polynomial(coefficients);

		return sum;
	}

	public double evaluate(double x){
		int exponent = 0;
		int idx = 0;
		double value = 0;

		while (exponent < this.coefficients.length){
			value += this.coefficients[idx] * (Math.pow(x, exponent));
			exponent++;
			idx++;
		}

		return value;
	}

	public boolean hasRoot(double x){
		return (evaluate(x) == 0);
	}
}