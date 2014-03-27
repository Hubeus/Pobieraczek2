package programy;

import java.net.URL;
import java.util.Date;

public class Wydanie {

	private URL download_link;
	private Date data;
	private String nazwa_pliku;
	private Program program;
	
	
	public URL getDownload_link() {
		return download_link;
	}
	public void setDownload_link(URL download_link) {
		this.download_link = download_link;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getNazwa_pliku() {
		return nazwa_pliku;
	}
	public void setNazwa_pliku(String nazwa_pliku) {
		this.nazwa_pliku = nazwa_pliku;
	}
	public Program getProgram() {
		return program;
	}
	public void setProgram(Program program) {
		this.program = program;
	}

	
	
}
