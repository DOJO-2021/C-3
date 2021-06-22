package test;

import java.util.List;

import dao.User_loginDao;
import dao.s_resultDao;
import model.User_login;


public class User_loginDaoTest {

	public static void main(String[] args) {
		testIsLoginOK1();	// ユーザーが見つかる場合のテスト
		testIsLoginOK2();	// ユーザーが見つからない場合のテスト

		//insert()のテスト
		User_loginDao dao = new User_loginDao();

		System.out.println("---------- insert()のテスト ----------");
		User_login insRec = new User_login(0,"Tanaka_Kana", "4567");
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");
			List<User_login> signList3 = dao.select(insRec);
			for (User_login sign : signList3) {
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
		User_loginDao dao = new User_loginDao();
		if (dao.isLoginOK("hoshi","nh1234")) {
			System.out.println("testIsLoginOK1：テストが成功しました");
		}
		else {
			System.out.println("testIsLoginOK1：テストが失敗しました");
		}
	}

	// ユーザーが見つからない場合のテスト
	public static void testIsLoginOK2() {
		User_loginDao dao = new User_loginDao();
		if (!dao.isLoginOK("hoshi","nh1234")) {
			System.out.println("testIsLoginOK2：テストが成功しました");
		}
		else {
			System.out.println("testIsLoginOK2：テストが失敗しました");
		}

		//ユーザー名を表示させるテスト
		s_resultDao rDao2 = new s_resultDao();
		User_login result = rDao2.select_username(new User_login(1, "", "" ));
		System.out.println("名前は、" + result.getUser_name());


	}
}
