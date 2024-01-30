<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>App</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        /* Ajout de styles personnalisés */
        body {
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
        }
        .title {
            text-align: center;
            margin-top: 50px;
            padding: 20px;
        }
        .btn-container {
            display: flex;
            justify-content: center;
            margin-top: 30px;
        }
        .custom-btn {
            margin: 0 20px;
            padding: 10px 20px;
            font-size: 18px;
            border-radius: 8px;
        }
        .btn-projects {
            background-color: #007bff;
            color: #fff;
        }
        .btn-tasks {
            background-color: #ffc107;
            color: #000;
        }
    </style>
</head>
<body>
    <div class="title">
        <h2>Task manager project</h2>
    </div>
    <div class="btn-container">
        <a href="/project/project" class="custom-btn btn-projects">Projects</a>
        <a href="/project/task" class="custom-btn btn-tasks">Tasks</a>
    </div>
</body>
</html>
