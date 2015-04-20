package be.lode.setup;
public class ResetDBSetupTestData {
	public static void main(String[] args) {
		run();
	}

	public static void run() {
		ResetDB.run();
		SetupData.run();
	}
}
