<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="entities.Project" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Project</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        /* Ajout de styles personnalisés */
        body {
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
        }
        .container {
            margin-top: 50px;
            text-align: center;
        }
        .form-label {
            font-weight: bold;
        }
        .form-control {
            margin-bottom: 10px;
        }
        .submit-btn {
            width: 100%;
        }
    </style>
</head>
<body>
    <% Project project = (Project) request.getAttribute("project"); %>
    <div class="container">
        <h2 class="mb-5">Update your project: <%= project.getCode() %> </h2>
    </div>
    <form method="POST" class="container">
        <div class="row">
            <div class="col-4">
                <label class="form-label">Project Description</label>
                <input class="form-control" value="<%= project.getDescription() %>" type="text" name="description"/>
            </div>
            <div class="col-4">
                <label class="form-label">Start Date</label>
                <input class="form-control" value="<%= project.getStartDate().toString() %>" type="date" name="date"/>
            </div>
            <div class="col-4 mb-4">
                <input class="form-control btn btn-primary submit-btn" value="Update" type="submit" name="Submit"/>
            </div>
        </div>
    </form>
</body>
</html>
