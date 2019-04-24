<%--
  Created by IntelliJ IDEA.
  User: Dawit
  Date: 4/20/2019
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html>
<head>
    <title>Login Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%--===============================================================================================--%>
    <link rel="icon" type="image/png" href="view/Login/loginimages/images/icons/favicon.ico"/>
  <%--===============================================================================================--%>

<link rel="stylesheet" type="text/css" href="view/Login/loginfonts/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<%--===============================================================================================--%>
<link rel="stylesheet" type="text/css" href="view/Login/loginfonts/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<%--===============================================================================================--%>

<link rel="stylesheet" type="text/css" href="view/Login/logincss/css/util.css">
<link rel="stylesheet" type="text/css" href="view/Login/logincss/css/main.css">
<%--===============================================================================================--%>


</head>
<body>

<%
    HttpSession s = request.getSession(false);
    if(s == null){
        response.sendRedirect("/TaskManagementApp_war_exploded/login.jsp");
    }else{
        s = null;
        //out.println("<h2>session not null</h2>");
    }
%>

<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">
            <div class="login100-form-title" style="background-image: url(view/Login/loginimages/images/bg-01.jpg)">
					<span class="login100-form-title-1">
						Sign In
					</span>
            </div>

            <form action="LoginServlet" method="POST" class="login100-form validate-form">
                <div class="wrap-input100 validate-input m-b-26" data-validate="Username is required">
                    <span class="label-input100">Username</span>
                    <input class="input100" type="text" name="username" placeholder="Enter username" required>
                    <span class="focus-input100"></span>
                </div>

                <div class="wrap-input100 validate-input m-b-18" data-validate = "Password is required" required>
                    <span class="label-input100">Password</span>
                    <input class="input100" type="password" name="pass" placeholder="Enter password" required>
                    <span class="focus-input100"></span>
                </div>

                <!--div class="flex-sb-m w-full p-b-30">
                    <div class="contact100-form-checkbox">
                        <input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">
                        <label class="label-checkbox100" for="ckb1">
                            Remember me
                        </label>
                    </div>

                    <div>
                        <a href="#" class="txt1">
                            Forgot Password?
                        </a>
                    </div>
                </div-->

                <div class="container-login100-form-btn">
                    <button id="loginBtn" class="login100-form-btn">
                        Login
                    </button>
                </div>
            </form>

            <div id="errorMessage"></div>
        </div>
    </div>
</div>

<%--===============================================================================================--%>
<script src="view/Login/loginjs/js/jquery-3.2.1.min.js"></script>

<!--script src="view/Login/loginjs/js/main.js"></script-->


<script type="text/javascript">

    $(document).ready(function(){

        console.log(window.location.toString());
        $('#errorMessage').empty().append($('<p/>').text(getQueryVariable('msg1') + " " +
                                                         getQueryVariable('msg2') + " " +
                                                         getQueryVariable('msg3'))
                                                    .css({"color":"red"}));

        function getQueryVariable(variable) {
            var query = window.location.search.substring(1);
            var vars = query.split('&');

            for(var i=0; i < vars.length; i++){
                var pair = vars[i].split('=');
                if(decodeURIComponent(pair[0]) == variable){
                    return decodeURIComponent(pair[1]);
                }
            }
            return "";
        }

    });

</script>
</body>
</html>
