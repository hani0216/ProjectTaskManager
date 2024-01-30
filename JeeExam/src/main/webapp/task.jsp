<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>This is the page of creating a task</h1>
	<table class="table">
					  <thead class="thead-light">
					    <tr>
					      <th scope="col">Id</th>
					      <th scope="col">Designation</th>
					      <th scope="col">Prix</th>
					      <th scope="col">Quantite</th>
					      <th></th>
					      <th></th>
					    </tr>
					  </thead>
					  <tbody>
					  <!-- Boucler sur les produits réquperer dans le model on utilisant jstl -->
					  <c:forEach items="${model.tasks}" var="task">
					  	<tr>
					      <th scope="row">${task.code}</th>
					      <td>${task.description }</td>
					      <td>${task.startDate().toString() }</td>
					      <td>${task.endDate().toString() }</td>
					      <td>
					      <a class="font-weight-bolder text-danger text-decoration-none" onclick="return confirm('Vous voulez vraiment supprimer se produit?')" href="supprimer.p?id=${task.id}">Supprimer</a></td>
					      <td><a class="font-weight-bolder text-warning text-decoration-none" href="editer.p?id=${task.id}">Editer</a></td>
					    </tr>
					  </c:forEach>
					    	
					  </tbody>
					</table>	
</body>
</html>