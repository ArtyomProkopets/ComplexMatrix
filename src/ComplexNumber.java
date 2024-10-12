public class ComplexNumber {
    private double Re;
    private double Im;

    /*    public ComplexNumber() {
            this.Re = 0;
            this.Im = 0;
        }*/
    public ComplexNumber(double Re, double Im){
        this.Re = Re;
        this.Im = Im;
    }

//    public ComplexNumber(String str){
//        str = str.replaceAll("\\s", "");
//        String[] parts = str.split("\\+");
//        this.Re = Double.parseDouble(parts[0]);
//        this.Im = Double.parseDouble(parts[1].replace("i", ""));
//    }

    public double getRe(){
        return Re;
    }
    public double getIm(){
        return Im;
    }

    public void setRe(double Re){
        this.Re = Re;
    }
    public void setIm(double Im){
        this.Im = Im;
    }

    public String toString(){
        return Re + "+" + Im + "i";
    }

    public ComplexNumber add(ComplexNumber num){
        return new ComplexNumber(this.Re + num.Re, this.Im + num.Im);
    }

    public ComplexNumber sub(ComplexNumber num){
        return new ComplexNumber(this.Re - num.Re, this.Im - num.Im);
    }

/*    public ComplexNumber mult(ComplexNumber num){

    }

    public ComplexNumber div(ComplexNumber num){

    }*/
}
