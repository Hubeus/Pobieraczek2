package programy;

public enum Medium {
	
	
	TVP_BIA£YSTOK("[6000132]TVP_Bialystok"),
	TVP_BYDGOSZCZ("[6000124]TVP_Bydgoszcz"),
	TVP_GDA—SK("[6000139]TVP_Gdansk"),
	TVP_GORZ”W("[6000108]TVP_Gorzow_Wielkopolski"),
	TVP_KATOWICE("[6000051]TVP_Katowice"),
	TVP_KIELCE("[6000183]TVP_Kielce"),
	TVP_KRAK”W("[6000053]TVP_Krakow"),
	TVP_LUBLIN("[6000107]TVP_Lublin"),
	TVP_£”Dè("[6000093]TVP_Lodz"),
	TVP_OLSZTYN("[6000186]TVP_Olszyn"),
	TVP_OPOLE("[6000191]TVP_Opole"),
	TVP_POZNA—("[6000050]TVP_Poznan"),
	TVP_RZESZ”W("[6000103]TVP_Rzeszow"),
	TVP_SZCZECIN("[6000143]TVP_Szczecin"),
	TVP_WARSZAWA("[6000052]TVP_Warszawa"),
	TVP_WROC£AW("[6000056]TVP_Wroclaw");
	
	
	public String ID;
	
	
	private Medium(String ID){
		this.ID = ID;
	}
}
