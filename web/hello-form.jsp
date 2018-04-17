<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Formulaire</title>
    <style>.error { color: red; } .success { color: green; }</style>
    <LINK rel="stylesheet" type="text/css"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
</head>
<body>

    <span class="success">${messages.success}</span>

    <form action="custom-hello.html" method="post">
    <!--<form method="post">-->
        <p>
            <label for="fname">First name : </label>
            <input id="fname" type="text" name="fname">
            <span class="error">${messages.fname}</span><br>
        </p>
        <p>
        <label for="fname">Last name : </label>
        <input id="lname" type="text" name="lname">
        <span class="error">${messages.lname}</span><br>
        </p>
        <p>
            <input type="hidden" name="hour" id="hourInput"><br>
            <input type="submit" value="Submit">
        </p>
    </form>

    <script>
        var d = new Date();
        // var actualHour = d.getHours();
        document.getElementById("hourInput").value = d.getHours();
    </script>
    <script type="text/javascript"
            src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script type="text/javascript"
            src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</body>
</html>
