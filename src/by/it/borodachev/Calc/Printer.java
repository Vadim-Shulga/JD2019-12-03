package by.it.borodachev.Calc;

class Printer {

    void print(Var var) {
        if (var != null)
            System.out.println(var);
        else
            System.out.println("Unknown ERROR!!!");
    }

}
