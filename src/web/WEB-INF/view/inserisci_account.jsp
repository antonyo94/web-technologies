
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
    <head>
        <meta hcharset="UTF-8">
        <title>Account</title>
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
            <h1 class="title"><spring:message code="account.title"/> </h1>

    <c:if test="${not empty errore}">
        <div role="alerr" class="error"> ${errore} </div>
    </c:if>

    <form:form action="inserisci_account" commandName="utente" method="post">
        <table>
            <tr>  
                <td> <label><spring:message code="username"/> </label> </td>
                <td> <input type=text path="username" name="username" id="username"/> </td>
                <td> <form:errors path="username" cssClass="error"/> </td>
            </tr>

            <tr>  

                <td> <label><spring:message code="password"/> </label> </td>
                <td> <input type=password name="password" id="password"/>  </td>
                <td> <form:errors path="password" cssClass="error"/> </td>
            </tr>
            <tr>
                <td>  <label><spring:message code="inserisci_account.ruolo"/></label> </td>
                <td> <select name="name" id="name">
                        <option value="ROLE_ADMIN"> <spring:message code="account.admin"/> </option>
                        <option value="ROLE_PARENT"> <spring:message code="account.genitore"/></option>
                    </select> </td>
            </tr>
        </table>   
        <input type="submit" value=<spring:message code="operazioni.invio"/> />
    </form:form>

            <jsp:include page="/WEB-INF/resources/template/footer.jsp" />         
        </div> 
    </body>
</html>
