/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.javabrains.lambdas.unit3;

/**
 *
 * @author Hubert
 */
public class MethodReferenceExample1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        Thread t = new Thread(()->printMessage());
        Thread t = new Thread(MethodReferenceExample1::printMessage);
        t.start();

    }
    
    public static void printMessage() {
        System.out.println("Hello");
    }
    
}
