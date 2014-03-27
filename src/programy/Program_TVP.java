package programy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public abstract class Program_TVP extends Program {

	public final String baza = "http://www.tvp.pl/shared/cdn/tokenizer.php?object_id=";
	public String ostatnieID;
	public String noweID;
	public String nowaData;

	
	
	public void get_nowe_parametry() throws IOException {
		Document doc = null;

		doc = Jsoup.connect(monitorowana_strona.toString()).get();

		Elements urls = doc.select("a.info[href~=\\d{8}$]");
		for (Element url : urls) {
			System.out.println(url.attr("href").toString());
		}

		Pattern pattern = Pattern.compile("\\d{8}$");
		Matcher matcher = pattern.matcher(urls.get(0).attr("href").toString());

		if (matcher.find()) {
			noweID = matcher.group();
		}
		Pattern datepattern = Pattern.compile("/([^/]*)/\\d{8}$");
		Matcher datematcher = datepattern.matcher(urls.get(0).attr("href")
				.toString());

		if (datematcher.find()) {
			nowaData = datematcher.group(1);
		}
	}

	@Override
	public boolean nowe_nagranie() {
		if (noweID.equals(ostatnieID)) {
			return false;
		} else
			return true;

	}

	private String removeBackslashes(String withBackslashes) {
		StringBuffer ready = new StringBuffer();
		for (int i = 0; i < withBackslashes.length(); i++) {
			if (withBackslashes.charAt(i) != '\\') {
				ready.append(withBackslashes.charAt(i));
			}
		}

		return ready.toString();
	}
	
	@Override
	public URL get_download_link() {
		int counter = 5;
		URL url;
		StringBuffer buffer = new StringBuffer();
		String line = "";
		try {
			url = new URL(baza + noweID);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					url.openStream()));
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			reader.close();

		} catch (IOException e) {
			counter--;
			if (counter > 0) {
				try {
					wait(5000);
					get_download_link();
				} catch (InterruptedException e1) {

					e1.printStackTrace();
				}

			}
			e.printStackTrace();
		}
		Pattern URLPattern = Pattern.compile("\"(http(.*?))\"");
		ArrayList<String> downloadLinks = new ArrayList<>();
		String extension = "";

		Matcher matcher = URLPattern.matcher(buffer.toString());
		while (matcher.find()) {
			String found = matcher.group(1);
			if ((!found.endsWith("manifest")) && (!found.endsWith("m3u8"))) {
				downloadLinks.add(removeBackslashes(found));
				if (found.endsWith("mp4")) {
					extension = ".mp4";
				} else {
					extension = ".wmv";
				}
			}
			matcher.start();
			matcher.end();
		}
		String link = "999999";
		
		if (extension.equals(".mp4")) {
			for (String temp : downloadLinks) {
				if (temp.charAt(temp.length() - 5) < link
						.charAt(link.length() - 5)) {
					link = temp;

				}
			}

		}
		else{
			link = downloadLinks.get(0);
		}
		URL returnLink = null;
		try {
			returnLink = new URL(link);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnLink;
	}

}
