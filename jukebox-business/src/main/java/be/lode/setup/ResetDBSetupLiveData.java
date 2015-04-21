package be.lode.setup;

public class ResetDBSetupLiveData {
	public static void main(String[] args) {
		run();
	}

	public static void run() {
		ResetDB.run();
		SetupLiveData.run();
	}
}
