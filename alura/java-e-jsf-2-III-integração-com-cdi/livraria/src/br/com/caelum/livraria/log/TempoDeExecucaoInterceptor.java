package br.com.caelum.livraria.log;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Log
@Interceptor
public class TempoDeExecucaoInterceptor implements Serializable {

	private static final long serialVersionUID = 1287204035799280119L;
	
	@AroundInvoke
	public Object executaTX(InvocationContext contexto) throws Exception {
		long antes = System.currentTimeMillis();
		
		Object resultado = contexto.proceed();
		
		long depois = System.currentTimeMillis();
		
		System.out.println("método: " + contexto.getMethod().getName() + " teve o gasto de: " +  (depois - antes));
		
		return resultado;
	}
}
