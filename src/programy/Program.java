package programy;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Program {
		
	public Medium medium;
	public String nazwa_programu;
	public Wydanie ostatnie_wydanie;
	public URL monitorowana_strona;
	public SimpleDateFormat format_daty = new SimpleDateFormat("yyyy-MM-dd_'godz'_HH_mm_ss");
	
	
	
	public abstract Date get_data_wydania(String data);
	public abstract Wydanie get_najnowsze();
	public abstract boolean nowe_nagranie();
	public abstract String get_nazwa_pliku ();
	public abstract boolean czy_przegladamy(Wydanie wydanie);
	public abstract URL get_download_link();
	
	
}
