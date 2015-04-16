package be.lode.setup;
public class ClearThenSetupDBData {
	public static void main(String[] args) {
		run();
	}

	public static void run() {
		ClearDBData.run();
		SetupDBData.run();
	}
}
