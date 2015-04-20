package be.lode.setup;
public class ClearThenSetupTestDBData {
	public static void main(String[] args) {
		run();
	}

	public static void run() {
		ClearDBData.run();
		SetupTestDBData.run();
	}
}
