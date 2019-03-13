<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.util.*,br.edu.insper.*" %>
<table border = '1'>
	<%DAO dao = new DAO(); %>
	<%Cria cria = new Cria(); %>
	<%Integer hour = Integer.valueOf(request.getParameter("hora")); %>
	<%Integer min = Integer.valueOf(request.getParameter("minuto")); %>
	<%Integer segundo = Integer.valueOf(request.getParameter("segundo"));%>
	
		<span id="countdown" class="timer"></span>
			<script type="text/javascript">
			
				var seconds = segundo;
				var minutes = min
				var hours = hour
				var changeMin = minutes % 60;
				
				function TimePassed(){		
						var remainingSeconds = seconds % 60;
						var remainingMinutes = minutes % 60	
						
						
						if (remainingMinutes < 10){
							remainingMinutes = "0" + remainingMinutes;
						}
						if (remainingSeconds < 10){
							remainingSeconds = "0" + remainingSeconds;
						}
						while (minutes >60){
							minutes = minutes - 60;
						}
						if(changeMin < 0 ){
							changeMin = 0;
						}
						document.getElementById('countdown').innerHTML = hours+ ':' + changeMin + ':' + remainingSeconds;
						
						if(remainingSeconds == 0 ){
							if(changeMin == 0){
								if (hours != 0){
									changeMin = changeMin + 59;
									remainingSeconds = remainingSeconds + 59
									hours --;	
								}	
									
							}
							
						}	
						
						if(remainingSeconds == 0 ){
							changeMin --;
						}	

						else if(seconds >= 0){
							seconds --;	
						}
						else{
							pass;
						}
						
						
	
					}
				var countdownTimer = setInterval('TimePassed()',1000);
			</script>
</table>
</body>
</html>