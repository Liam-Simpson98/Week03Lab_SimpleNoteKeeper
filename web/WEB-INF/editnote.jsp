<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <form method="post" action="note">
            <h1>Simple Note Keeper</h1>
            <h2>Edit Note</h2>
            <p>Title: <input type="text" name="title" value="${note.title}"></p>
            <p>Contents: <textarea name="contents">${note.contents}</textarea></p>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
