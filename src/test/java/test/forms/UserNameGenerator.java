package test.forms;

public class UserNameGenerator {
	
	public String generateNewLogin() {
		StringBuffer buffer = new StringBuffer();
		String characters = "abcdefghijklmnopqrstuvwxyz1234567890";
		int charactersLength = characters.length();
		int length = 10;

		for (int i = 0; i < length; i++) {
			double index = Math.random() * charactersLength;
			buffer.append(characters.charAt((int) index));
		}
		String newLogin = buffer.toString();
		return newLogin;
	}
}
