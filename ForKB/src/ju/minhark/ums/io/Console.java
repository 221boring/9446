package ju.minhark.ums.io;

import java.util.Scanner;

public interface Console{ 
	Scanner sc = new Scanner(System.in);

	//숫자값을 입력한다.
	public static int inNum(String msg){
		System.out.print(msg);
		int num = sc.nextInt(); sc.nextLine();
		return num;
	}

	//문자값을 입력한다.
	public static String inString(String msg){
		System.out.print(msg);
		return sc.nextLine();
	}

	//정보 문구를 출력한다.
	public static void info(String msg){
		System.out.println(msg);
	}

	//객체 정보를 출력한다.
	public static void info(Object obj){
		System.out.println(obj);
	}
}