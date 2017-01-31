package br.com.caelum.livraria.interceptador;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptador {

	@AroundInvoke
	public Object intercepta(InvocationContext invocationContext) throws Exception {
		long millis = System.currentTimeMillis();

		Object object = invocationContext.proceed();

		System.out.println("[INFO] Tempo gasto no acesso ao BD: " + (System.currentTimeMillis() - millis)
				+ "ms, no método:" + invocationContext.getMethod().getName() + " da classe: "
				+ invocationContext.getTarget().getClass().getName());

		return object;
	}

}
