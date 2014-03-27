package programy;

import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String authUser = "khoffmann";
		final String authPassword = "GA5msBa";
		final String proxyHost = "10.0.0.1";
		final String proxyPort = "8080";

		System.setProperty("http.proxyHost", proxyHost);
		System.setProperty("http.proxyPort", proxyPort);
		System.setProperty("http.proxyUser", authUser);
		System.setProperty("http.proxyPassword", authPassword);

		Authenticator.setDefault(new Authenticator() {
			@Override
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(authUser, authPassword
						.toCharArray());
			}
		});

		TVP_Szczecin_Kronika_1830 kronika = new TVP_Szczecin_Kronika_1830();
		try {
			kronika.get_nowe_parametry();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Wydanie premiera = kronika.get_najnowsze();
		System.out.println(premiera.getDownload_link().toString());
		if(kronika.czy_przegladamy(premiera) && !premiera.equals(kronika.ostatnie_wydanie)){
		try {
			Files.copy(premiera.getDownload_link().openStream(), Paths.get("C:\\Documents and Settings\\khoffmann\\Pulpit\\" + premiera.getNazwa_pliku()), StandardCopyOption.REPLACE_EXISTING );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else{
			System.out.println("Nie pobieramy tego wydania");
		}
	}

}
