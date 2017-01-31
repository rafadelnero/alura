package br.com.meetup.livraria.bean;

import java.io.Serializable;

import org.springframework.stereotype.Controller;

@Controller
public class TemaBean implements Serializable {
	
	private static final long serialVersionUID = -2871493857147685220L;
	private String tema = "vader";

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}
	
	public String[] getTemas() {
		return new String[]{"afterdark","afternoon","afterwork","aristo",
			"black-tie","blitzer","bluesky","bootstrap","casablanca",
			"cupertino","cruze","dark-hive","delta","dot-luv","eggplant",
			"excite-bike","flick","glass-x","home","hot-sneaks",
			"humanity","le-frog","midnight","mint-choc","overcast",
			"pepper-grinder","redmond","rocket","sam","smoothness",
			"south-street","start","sunny","swanky-purse","trontastic",
			"ui-darkness","ui-lightness","vader"};
	}
	

}
