
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
    <head>
        <meta hcharset="UTF-8">
        <title>Login</title>
        <link href="<c:url value="/resources/css/stile.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/js/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
        <script src="<c:url value="/resources/js//jquery/jquery-1.9.1.js"/>" type="text/javascript"></script> 
        <script src="<c:url value="/resources/js/bootstrap/js/bootstrap.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/jquery/jquery.min.js"/>"  type="text/javascript"></script> 
        <link rel="icon" type="image/png" href="<c:url value="/resources/css/img/logo.png"/>" sizes="32x32">
    </head>
    <body>
        <div class="centrato">
            <jsp:include page="/WEB-INF/resources/template/head_navbar.jsp" />
            
        <h1 class="title">Login</h1>

        <c:if test="${not empty error}">
            <div role="alert" class="error">${error}</div>	
        </c:if>
        <c:if test="${not empty msg}">
            <div  role="alert" class="error">${msg}</div>
        </c:if>

        <form:form name="loginForm" action="login" method="POST" role="form">
            <table>
                <tr>
                    <td>  <label for="user"> <spring:message code="login.utente"/> </label>  </td>
                    <td> <input type="text"  name="user" id="user" placeholder="Inserisci il tuo codice utente">
                </tr>
                <tr>
                    <td>  <label for="password"> <spring:message code="password"/> </label> </td>
                    <td> <input type="password"  name="password" id="password" placeholder="Password"></td>
                </tr>                     
            </table>

            <button type="submit">Login</button>
        </form:form>             
            <jsp:include page="/WEB-INF/resources/template/footer.jsp" />         
        </div> 
    </body>
</html>