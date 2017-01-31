package br.com.caelum.estoque.modelo.adapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date> {
	private String pattern = "dd/MM/yyyy";

	public String marshal(Date date) {
		return new SimpleDateFormat(pattern).format(date);
	}
	
	public Date unmarshal(String dataString) throws ParseException {
		return new SimpleDateFormat(pattern).parse(dataString);
	}
}
