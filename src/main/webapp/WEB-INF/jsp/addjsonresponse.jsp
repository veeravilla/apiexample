
<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>
	<H1> Data Feed File</H1>
	<form method="POST" action="savejson">
		Name : <input type ="text" name="filename"> <br/><br/><br/>
		Json Data: <textarea name="jsondata" cols="80" rows="40"></textarea>
		<input type="submit" name="save" value="AddJson"/>
	</form>
</body>

</html>