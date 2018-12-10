<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import ="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
    
    <script type="text/javascript">
    
    function notShowBox() {
	    document.getElementById("box").style.display='none';
    }

    </script>
  
    </head>
    <body>
         <form method="post" action="selection">
         	<select name="selectActions" onChange="if (this.selectedIndex == 0){notshowBox();}">
         		<option value="timeline">Timeline</option>
         		<option value="post">Post</option>
         		<option value="showUser">showUser</option>
         		<option value="createFriendship">createFriendship</option>
         		<option value="createMute">createMute</option>
         		<option value="createBlock">createBlock</option>
         		<option value="getUserID">getUserID</option>
         		<option value="destroyBlock">destroyBlock</option>
         	</select>
         	<input type="submit">
         	<input type="text" id="box" name="inputBox">
         </form>
         
         <p>${message}</p>
         
         <%
			ArrayList s = (ArrayList) request.getAttribute("array");
         	if(s != null) {
         		for(int i = 0; i < s.size(); i++) {
         			out.println(s.get(i));	
         			out.println("\n");
             	}
         	}
		%>
    </body>
</html>