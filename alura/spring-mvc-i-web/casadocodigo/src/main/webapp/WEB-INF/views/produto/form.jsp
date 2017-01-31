<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Livros de java, Android, Iphone, PHP, Ruby e muito mais -
	Casa do código</title>
</head>
<body>
	<f:form action="${s:mvcUrl('PC#grava').build()}" method="POST" commandName="produto" enctype="multipart/form-data">
		<div>  
			<label>Título</label> 
			<f:input path="titulo" />
			<f:errors path="titulo"/>
		</div>
		<div>
			<label>Descrição</label>
			<f:textarea rows="10" cols="20" path="descricao"/>
			<f:errors path="descricao"/>
		</div>
		
		<c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
			<div>
				<label>${tipoPreco}</label> 
				<f:input path="precos[${status.index}].valor"/>  
				<f:input type="hidden" path="precos[${status.index}].tipoPreco" value="${tipoPreco}"/> 
			</div>
		</c:forEach>
		
		<div>
            <label>Data de lançamento</label>
            <f:input path="dataLancamento"  />
            <f:errors path="dataLancamento" />
        </div>
        
		<div>
			<label>Páginas</label> 
			<f:input path="paginas" />
			<f:errors path="paginas"/>
		</div>
		
		<div>
			<input name="sumario" type="file"/>
		
		</div>
		
		<button type="submit">Cadastrar</button>
	</f:form>
</body>
</html>