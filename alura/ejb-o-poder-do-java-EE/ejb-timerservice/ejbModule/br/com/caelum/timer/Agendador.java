package br.com.caelum.timer;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class Agendador {
	
	// @Schedule(hour = "*", minute="*/2", second="*", persistent=false) 2 minutos
	@Schedule(hour = "*", minute="*", second="*/10", persistent=false) // 10 segundos
	void agendado() {
	    System.out.println("[INFO] Verificando serviço externo periodicamente.");
	}
}
