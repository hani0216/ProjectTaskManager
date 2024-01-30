<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="entities.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Task</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        /* Styles personnalisés */
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
    <% Task task = (Task) request.getAttribute("task"); %>
    <div class="container">
        <h2 class="mb-5">Update your task: <%= task.getCode() %> </h2>
    </div>
    <form method="POST" class="container">
        <div class="row m-5 p-5">
            <div class="col-3">
                <label class="form-label">Task Description</label>
                <input class="form-control" value="<%= task.getDescription() %>" type="text" name="description"/>
            </div>
            <div class="col-3">
                <label class="form-label">Start Date</label>
                <input class="form-control" value="<%= task.getStartDate().toString() %>" type="date" name="start_date"/>
            </div>
            <div class="col-3">
                <label class="form-label">End Date</label>
                <input class="form-control" value
