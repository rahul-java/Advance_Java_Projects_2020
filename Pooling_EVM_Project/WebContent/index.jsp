<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<style>
.container {
  position: relative;
  width: 100%;
  max-width: 400px;
}

.container img {
  width: 100%;
  height: auto;
}

.container .btn {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  -ms-transform: translate(-50%, -50%);
  background-color: #555;
  color: white;
  font-size: 16px;
  padding: 12px 24px;
  border: none;
  cursor: pointer;
  border-radius: 5px;
  text-align: center;
}

.container .btn:hover {
  background-color: black;
}
</style>
<script type="text/javascript">
  function getBJP()
  {
	 var t= document.getElementById("bjp").value;
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
  
  
  function getCongress()
  {
	 var t= document.getElementById("congress").value;
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

<tr> <td>

<div class="container">
  <img src="imges/bjp.jpg" alt="Snow" style="width:100%">
  <input type="button" name="bjp" id="bjp" value="1"  class="btn" onclick="getBJP();"></button>
</div>
</td>


<td>
<div class="container">
  <img src="imges/congress.jpg" alt="Snow" style="width:100%">
  <input type="button" name="congress" id="congress" value="2"  class="btn" onclick="getCongress();"></button>
</div>
</td>
</tr>





<tr>
 <td> <input type="text" id="t1">  </td>
</td>



</table>











</body>
</html>