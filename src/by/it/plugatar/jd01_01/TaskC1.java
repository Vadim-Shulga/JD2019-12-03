package by.it.Plugatar.jd01_01;

import java.util.Scanner;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и выводит их сумму на экран в виде

Ввод (это вы вводите с клавиатуры):
34 26

Вывод (это должна появится в консоли, обратите внимание на пробелы и слово Sum:
Sum = 60

*/
class TaskC1 {
    public static void main(String[] args) {
    /*    Scanner sc1=new Scanner(System.in);
        Scanner sc2=new Scanner(System.in);
        int i=sc1.nextInt();
        int j=sc2.nextInt();
        System.out.println(i+j);
     */

        Scanner sc1 = new Scanner(System.in);

        int i = sc1.nextInt();
        int j = sc1.nextInt();
        int k = i + j;
        System.out.println("Sum = " + k);
    }


}
