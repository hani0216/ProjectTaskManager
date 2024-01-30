<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import ="entities.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="text-center m-5">
			<h2>List of all tasks </h2>
			<div class="text-end">
			<a href="/project/project" class="btn btn-dark"> View Projects</a>	
			</div>
	<table class="table">
					  <thead class="thead-light">
					    <tr>
					      <th scope="col">Code</th>
					      <th scope="col">Description</th>
					      <th scope="col">End At</th>
					      <th scope="col">Start At</th>
						  <th scope="col">Project Associé</th>
					      <th></th>
					      <th></th>
					    </tr>
					  </thead>
					  <tbody>
					    		<%
    // Retrieve the list from the request
    List<Task> list = (ArrayList) request.getAttribute("model");
	
    // Check if the list is not null and not empty
    if (list != null && !list.isEmpty()) {
        // Iterate over the list using a for loop
        for (Task item : list) {
            // Access properties of each object and render them
            %>
           	<tr>
           		<td><%= item.getCode() %></td>
           		<td><%= item.getDescription() %></td>
           		<td><%= item.getEndDate().toString() %></td>
           		<td><%= item.getStartDate().toString() %></td>
           		<td><%= item.getProjectName() %></td>
           		<td> <a class="btn btn-danger" href="/project/task-delete?code=<%=item.getCode() %>">Supprimer</a>
           		<td> <a class="btn btn-info" href="/project/task-edit?code=<%=item.getCode() %>">Edit</a>
           		
           	</tr>
            <%
        }
    } else {
        %>
 	       <p>No items in the list.</p>
        <%
    }
%>
</tbody>
</table>	
	</div>
		<form method = "GET">
		<div class="m-5 p-5 row">
			<div class="col-3">
				<label >Task Code </label>
				<input class="form-control" type="text" name="code" />
			</div>
			<div class="col-2">
				<label> Task Description</label>
				<input class="form-control" type="text" name="description"/>
			</div>
			<div class="col-2">
				<label> Projet associé</label>
				<select class="form-control" type="text" name="project_code">
					<%
				    // Retrieve the list from the request
    				List<Project> projects = (ArrayList) request.getAttribute("projects");
	
				    // Check if the list is not null and not empty
				    if (list != null && !list.isEmpty()) {
       				 // Iterate over the list using a for loop
        			for (Project p : projects) {
		            // Access properties of each object and render them
            		%>
    			        <option code="<%=p.getCode() %>"> <%= p.getDescription() %></option>
    		        <% 
    		        } 
				    }
    		        %>
				</select>
			</div>
			<div class="col-2">
				<label> Task Start Date </label>
				<input class="form-control" type="date" name="start_date"/>
			</div>
			<div class="col-2">
				<label> Task End Date </label>
				<input class="form-control" type="date" name="end_date"/>
			</div>
			<div class="col-2 mt-3">
				<input class="form-control btn btn-success" value="ajouter" type="submit" name="Submit"/>
			</div>
		</div>
	</form>
	</div>
</body>
</html>