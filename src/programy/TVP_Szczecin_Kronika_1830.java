package programy;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TVP_Szczecin_Kronika_1830 extends Program_TVP {

	public TVP_Szczecin_Kronika_1830() {
		this.medium = Medium.TVP_SZCZECIN;
		this.nazwa_programu = "Kronika";
		try {
			this.monitorowana_strona = new URL(
					"http://www.tvp.pl/szczecin/nasze-programy/kronika");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		this.ostatnieID = "14529673";
		
	}

	@Override
	public Wydanie get_najnowsze() {
		// TODO Auto-generated method stub
		Wydanie wydanie = new Wydanie();
		wydanie.setDownload_link(get_download_link());
		wydanie.setNazwa_pliku(this.get_nazwa_pliku());
		wydanie.setProgram(this);
		wydanie.setData(get_data_wydania(nowaData));
		return wydanie;
	}

	@Override
	public String get_nazwa_pliku() {
		// TODO Auto-generated method stub
		
		
		
		String nazwa_pliku = this.medium.ID +"_"+ format_daty.format(get_data_wydania(nowaData)).toString()+"_"+this.nazwa_programu+"_pobrane_automatycznie.mp4";
		return nazwa_pliku;
		
		
		
	}

	@Override
	public boolean czy_przegladamy(Wydanie zonk) {
		if(true){
			return true;
		}
		else return false;
	}

	@Override
	public Date get_data_wydania(String data) {
		
		Date date;	
		SimpleDateFormat format = new SimpleDateFormat("HHmm-ddMMyy");
		try {
			date = format.parse(data);
		} catch (ParseException e) {
			date = new Date(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH, 18, 30);	
		}
		
		
		
		return date;
	}

}
