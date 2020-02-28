package br.com.caelum.estruturais.bridge;

public class TestaMapa {
	public static void main(String[] args) {
		Mapa googleMaps = new GoogleMaps();
		String mapa = googleMaps.devolveMapa("Rua Vergueiro, 3185");
		System.out.println(mapa);
	}

}
