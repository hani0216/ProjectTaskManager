<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import ="entities.Project" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Projects</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        /* Ajout de styles personnalisés */
        body {
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
        }
        .container {
            margin-top: 50px;
        }
        .table th {
            text-align: center;
        }
        .btn-actions {
            display: flex;
            justify-content: space-around;
        }
        .form-control {
            margin-bottom: 10px;
        }
        .add-project-btn {
            width: 100%;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="text-center m-5">
            <h1 class="mb-5">List of all projects</h1>
            <div class="text-end mb-3">
                <a href="/project/task" class="btn btn-dark">View Tasks</a>
            </div>
            <table class="table">
                <thead class="thead-light">
                    <tr>
                        <th scope="col">Code</th>
                        <th scope="col">Description</th>
                        <th scope="col">Start At</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Project> list = (ArrayList) request.getAttribute("model");
                        if (list != null && !list.isEmpty()) {
                            for (Project item : list) {
                    %>
                    <tr>
                        <td><%= item.getCode() %></td>
                        <td><%= item.getDescription() %></td>
                        <td><%= item.getStartDate().toString() %></td>
                        <td>
                            <div class="btn-actions">
                                <a class="btn btn-danger" href="/project/project-delete?code=<%=item.getCode() %>">Supprimer</a>
                                <a class="btn btn-info" href="/project/project-edit?code=<%=item.getCode() %>">Edit</a>
                            </div>
                        </td>
                    </tr>
                    <%
                            }
                        } else {
                    %>
                    <tr>
                        <td colspan="5" class="text-center">No items in the list.</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
        <form action="/project/project-create" method="GET">
            <div class="m-5 p-5">
                <div class="row">
                    <div class="col-3">
                        <label>Project Code</label>
                        <input class="form-control" type="text" name="identifiant" required/>
                    </div>
                    <div class="col-3">
                        <label>Project Description</label>
                        <input class="form-control" type="text" name="description" required/>
                    </div>
                    <div class="col-3">
                        <label>Start Date</label>
                        <input class="form-control" type="date" name="date" required/>
                    </div>
                    <div class="col-3 mt-3">
                        <input class="btn btn-success add-project-btn" value="Ajouter" type="submit" name="Submit"/>
                    </div>
                </div>
            </div>
        </form>
    </div>
</body>
</html>
