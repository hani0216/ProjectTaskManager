<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Failed Update</title>
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
        .shadow-lg {
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
            border-radius: 10px;
            padding: 30px;
        }
        .failed-message {
            font-size: 2em;
            margin-bottom: 30px;
        }
        .view-projects-btn {
            font-size: 1.5em;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="text-center shadow-lg m-5 p-5">
                <h1 class="failed-message my-5">Failed to update project</h1>
                <a href="/project/project" class="btn btn-success view-projects-btn mb-5">View all projects</a>
            </div>
        </div>	
    </div>
</body>
</html>
