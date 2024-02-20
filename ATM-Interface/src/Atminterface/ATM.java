package Atminterface;

import java.util.HashMap;
import java.util.Scanner;

public class ATM {

	public static void main(String[] args) {
		ATmap obj = new ATmap();
	}

}

class Data {
	float balance;
}

class ATmap {
	float balance;

	Scanner sc = new Scanner(System.in);
	HashMap<Integer, Data> map = new HashMap<>();

	public ATmap() {
		System.out.println("***************************************************************");
		System.out.println("Welcome To Our ATM");
		op();
	}

	public void op() {
		System.out.println("***************************************************************");
		System.out.println("Enter Your Pincode");
		int pincode = sc.nextInt();

		if (map.containsKey(pincode) == true) {
			Data obj = map.get(pincode);
			menu(obj);
		} else {
			System.out.println("***************************************************************");
			System.out.println("Please Create Account First");
			System.err.println("Set Your PinCode");
			int pin = sc.nextInt();
			Data obj = new Data();
			map.put(pin, obj);
			menu(obj);
		}
	}

	public void menu(Data obj) {

		System.out.println("Please Enter Valid Number");
		System.out.println("1. Check Balance");
		System.out.println("2. Deposit Money");
		System.out.println("3. Withdraw Money");
		System.out.println("4. Check Another Account");
		System.out.println("5. Exit");

		int x = sc.nextInt();

		if (x == 1) {
			check_balance(obj);

		} else if (x == 2) {
			deposit(obj);

		} else if (x == 3) {
			withdraw(obj);

		} else if (x == 4) {
			op();

		} else if (x == 5) {
			System.out.println("THANK YOU!");

		} else {
			System.out.println("Please Enter Valid Number");
			menu(obj);
		}
	}

	public void check_balance(Data obj) {
		System.out.println("***************************************************************");
		System.out.println("Your Balance " + obj.balance);
		System.out.println("***************************************************************");
		menu(obj);

	}

	public void deposit(Data obj) {
		System.out.println("Enter Your Amount");
		float a = sc.nextFloat();
		obj.balance = obj.balance + a;
		System.out.println("Amount Deposited Sucessfully");
		System.out.println("***************************************************************");
		menu(obj);
	}

	public void withdraw(Data obj) {
		System.out.println("Enter Your Amount");
		float a = sc.nextFloat();

		if (obj.balance >= a) {
			obj.balance = obj.balance - a;
			System.out.println("Amount Withdraw Sucessfully");
		} else {
			System.out.println("Insufficent Balance");
		}
		System.out.println("***************************************************************");
		menu(obj);
	}

}
