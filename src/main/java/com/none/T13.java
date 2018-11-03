package com.none;

import java.util.Scanner;

public class T13 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		String str_temp = scan.nextLine();

		// System.out.println(str.indexOf(str_temp,(str.indexOf(str_temp)+str_temp.length())));
		if (str.contains(str_temp)) {
			for (int i = 0; i < str.length();) {
				int t = str.indexOf(str_temp, i);
				System.out.println(t);
				i += t + str_temp.length() - 1;

			}
		} else {
			System.out.println("over");
		}

	}
}
