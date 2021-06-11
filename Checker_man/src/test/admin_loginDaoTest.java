package test;

public class admin_loginDaoTest {

	public static void main(String[] args) {
		testIsLoginOK1();	// ユーザーが見つかる場合のテスト
		testIsLoginOK2();	// ユーザーが見つからない場合のテスト
	}

	// ユーザーが見つかる場合のテスト
	public static void testIsLoginOK1() {
		admin_loginDaoTest dao = new admin_loginDaoTest();
		if (dao.isLoginOK("", "")) {
			System.out.println("testIsLoginOK1：テストが成功しました");
		}
		else {
			System.out.println("testIsLoginOK1：テストが失敗しました");
		}
	}

	// ユーザーが見つからない場合のテスト
	public static void testIsLoginOK2() {
		admin_loginDaoTest dao = new admin_loginDaoTest();
		if (dao.isLoginOK("", "")) {
			System.out.println("testIsLoginOK2：テストが成功しました");
		}
		else {
			System.out.println("testIsLoginOK2：テストが失敗しました");
		}
	}
}
