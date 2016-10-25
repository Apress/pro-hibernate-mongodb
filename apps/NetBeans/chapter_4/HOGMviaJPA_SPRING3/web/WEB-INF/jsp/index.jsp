<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hibernate OGM via Java Persistence API, Spring 3</title>
    </head>

    <body>
        <h1>Hibernate OGM via Java Persistence API, Spring 3</h1>
        <form:form method="GET" commandName="/">         
            <input type="submit" value="Generate Lucky Number" />
        </form:form>
    </body>
</html>
