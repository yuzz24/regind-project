<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>登陆成功</title>
</head>
<body>
    用户${acc}</br></br>
    <#list user as u>
    账号:${u.acc},密码:${u.password}</br>
    </#list>
</body>
</html>