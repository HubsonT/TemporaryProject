/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.javabrains.lambdas.unit2;

/**
 *
 * @author Hubert
 */
public class ClosuresExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
//        doProcess(a, new Process() {
//            @Override
//            public void process(int i) {
//                //chociaz b jest poza scopem metody process, kompilator wie w momencie
//                //uruchomienia, zeby przypisac b wartosc 20, ale b musi byc finalne 
//                //tzn nie musi tak byc zadeklarowane ale nie moze sie zmieniac, tzn
//                //musi byc tzw. effectively final
//                System.out.println(i+b);
//            }
//        });

        //to samo co powyzej zastapione lambda:
        
       doProcess(a,i->System.out.println(i+b));

    }

    public static void doProcess(int i, Process p) {
        p.process(i);
    }

}

interface Process {

    void process(int i);
}
