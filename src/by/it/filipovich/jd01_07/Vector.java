package by.it.filipovich.jd01_07;

public class Vector extends Var{

    private double[] value;

    public Vector(double[] value){
       this.value = new double[value.length];
       System.arraycopy(value, 0, this.value, 0,value.length);
    }

    public Vector(Vector vector){
        this(vector.value);
    }

    public Vector(String strVector){
        String[] a = strVector.replaceAll("}","")
                .replaceAll("\\{","")
                .replaceAll(" ","")
                .split(",");

            double[] arr = new double[a.length];
            for (int i = 0; i < a.length; i++) {
                arr[i] = Double.parseDouble(a[i]);
            }
            this.value = new double[arr.length];
            System.arraycopy(arr, 0, this.value, 0, arr.length);

        }

    public String toString(){

        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for (int i = 0; i<value.length; i++) {
            sb.append(value[i]);
            if(i != value.length-1)
            sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }

}
