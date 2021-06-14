package test;

import java.util.List;

import dao.user_loginDao;
import model.user_login;


public class user_loginDaoTest {

	public static void main(String[] args) {
		testIsLoginOK1();	// ユーザーが見つかる場合のテスト
		testIsLoginOK2();	// ユーザーが見つからない場合のテスト

		//insert()のテスト
		user_loginDao dao = new user_loginDao();

		System.out.println("---------- insert()のテスト ----------");
		user_login insRec = new user_login(2, "Tanaka_Kana", "4567");
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");
			List<user_login> signList3 = dao.select(insRec);
			for (user_login sign : signList3) {
				System.out.println("user_id" + sign.getUser_id());
				System.out.println("user_name" + sign.getUser_name());
				System.out.println("user_pw" + sign.getUser_pw());

				System.out.println();
			}
		}else {
			System.out.println("登録失敗！");
		}
	}

	// ユーザーが見つかる場合のテスト
	public static void testIsLoginOK1() {
		user_loginDao dao = new user_loginDao();
		if (dao.isLoginOK(1, "hoshi","nh1234")) {
			System.out.println("testIsLoginOK1：テストが成功しました");
		}
		else {
			System.out.println("testIsLoginOK1：テストが失敗しました");
		}
	}

	// ユーザーが見つからない場合のテスト
	public static void testIsLoginOK2() {
		user_loginDao dao = new user_loginDao();
		if (!dao.isLoginOK(1, "hoshi","nh1234")) {
			System.out.println("testIsLoginOK2：テストが成功しました");
		}
		else {
			System.out.println("testIsLoginOK2：テストが失敗しました");
		}
	}
}
