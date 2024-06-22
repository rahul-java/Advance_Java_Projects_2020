<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Login</title>

<script type="text/javascript">
  function getData()
  {
	 var t= document.getElementById("type").value;
	 alert(t);
	 var xmlhttp;


	 if (window.XMLHttpRequest)
	 {
	 // code for IE7+, Firefox, Chrome, Opera, Safari
	      xmlhttp=new XMLHttpRequest();
	 }
	 else
	 {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	  
	  xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	 {
	 //document.getElementById("fname").value
	 
	      document.getElementById("t1").value=xmlhttp.responseText;
	      
	 
	   
	  }
	 
	 }

	 
	  xmlhttp.open("GET","BotServlet?t="+t,true);
      xmlhttp.send();
	 
	 
	 
	  
  }
  
  
</script>

</head>
<body>


<table border="3" bgcolor="yellow" align="center">

<tr> 
<td>  <input type="button" name="type" id="type" value="BJP"  onclick="getData();">  
</td>   </tr>

<tr> <td>  <input type="button" name="type" id="type" value="Congress" onclick="getData();">   </td>  </tr>

<tr>
 <td> <input type="text" id="t1">  </td>
</td>



</table>











</body>
</html>