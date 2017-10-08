package io.javabrains.lambdas;

public class Greeter {

	public void greet() {
		System.out.println("Hello World!");
	}

	public static void main(String[] args) {
		Greeter greeter = new Greeter();
		greeter.greet();
	}

}
