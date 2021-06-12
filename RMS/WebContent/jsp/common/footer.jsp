<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap css -->
<link href="/RMS/staticContent/css/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap JS -->
<script src="/RMS/staticContent/js/bootstrap.min.js"></script>
<script src="/RMS/staticContent/js/jquery.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<br>
		<div class="row" style="background-color: gray;">
			<h4 align="center">
				<span style="color: white;">&copy Embel Technologies Pvt.
					Ltd. <br>&copy Copyright in 2017
				</span>
			</h4>
		</div>
	</div>
</body>
</html> --%>
<%@page import="java.util.Calendar"%>
<%
		int year = Calendar.getInstance().get(Calendar.YEAR);
	%>

<style>
.footer {
   position: fixed;
   left: 0;
   Z-INDEX: 999; 
   bottom: 0;
   width: 100%;
   /* background-color: #B4041B; */
   background-color: black;
   /* color: white; */
   color: orange;
   font-size: 28px;
   text-align: center;`
}
</style>
</head>
<body>
<div class="footer" >
  <p><b>Copyright © <%=year%> Embel Technology Pvt. Ltd.<br/><a href="http://www.embel.co.in" style="color: orange;"><p style="font-size: 18px">www.embel.co.in</p></a></b></p>
</div>

</body>
</html> 