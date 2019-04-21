<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Testing Stanford Core Nlp Su Time library</title>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
    <asset:javascript src="updateBirthday.js"/>
</head>

<body>
<div style="margin-left: 40px">
    Enter your birthday: <br>
    <g:textField name="unparsedBirthday" id="getDay"/>
    <input type="button" value="Parse" class="button" style="margin-left: 30px;width: 100px" id="parseDate"/><br><br>
    Parsed Birthday with Sutime: <br>
    <g:textField name="parsedBirthday" id="setDate"/>
</div>
</body>
</html>
