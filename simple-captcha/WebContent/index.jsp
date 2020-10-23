<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
       <title>Validacion Capcha</title>
        <script type="text/javascript">
        function imagen(){
         var a;
         a = document.getElementById("myImg").src;
         b = document.getElementById("cargar");
         b.innerHTML = "<img id='myImg' src='simpleImg.jpg' border='0' align='middle'/>";
       //  alert("funcionando");
            }
         </script>
       <style>
           .errorMessage {
               color: red;
               font-size: 0.8em;
           }
           .label {
               color:#000000;
           }
       </style>
   </head>
   <body>
       <table align="center" border="1">
           <tr>
               <td>
                   <h1>Validacion CAPTCHA</h1>
                   <s:form action="validar" namespace="/" method="POST">                   
                       <s:textfield label="Usuario" name="usuario" size="20" maxlength="10"/>
                       <s:password label="Password" name="password" size="20" maxlength="10" />                  
                       <s:textfield label="Captcha" name="captcha" size="8" maxlength="5"/>
                      
                   <table>
                <tr>
                    <td><div id="cargar" align="center"><img id="myImg" src="simpleImg.jpg" border="0" align="middle"/> </div></td> 
                     <td><button type="button" onclick="imagen()">Refresh</button></td>  
                    </tr>
                  </table>
                
                        <s:actionerror />
                        
                         <s:submit value="Ingresar" align="center" />
                                
                          
                   </s:form>
               
                   
               </td>
           </tr>
       </table>
       <p style="color: red" align="center">usuario: captcha / password: clave</p>
   </body>
</html>