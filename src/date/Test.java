/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package date;

/**
 *
 * @author 2304moantoine
 */
public class Test {
    public static void main(String[] args) {
        Date maDate = new Date(29, 2, 2016);
        System.out.println("Voilà ma Date : ");
        System.out.println(maDate);
        maDate.increment();
        System.out.println("Voilà ma Date incrémentée : ");
        System.out.println(maDate);
        
        Date today = new Date();
        System.out.println("Voilà la Date d'aujourd'hui : ");
        System.out.println(today);
        
        Person moi = new Person("Antoine", "Morgan", 23, 4, 1986);
        System.out.println(moi);
    }
}
