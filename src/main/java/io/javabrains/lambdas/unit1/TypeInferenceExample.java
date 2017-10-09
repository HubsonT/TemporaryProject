/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.javabrains.lambdas.unit1;

/**
 *
 * @author Hubert
 */
public class TypeInferenceExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StringLenghtLambda myLambda = (String s) -> s.length();
        System.out.println(myLambda.getLenght("Hello Lambda"));
        
        printLambda(s-> s.length());
        
    }
    
    public static void printLambda(StringLenghtLambda lambda) {
        System.out.println(lambda.getLenght("Hello Lambda"));
    }
    
    interface StringLenghtLambda {

        int getLenght(String str);
    }
    
}
