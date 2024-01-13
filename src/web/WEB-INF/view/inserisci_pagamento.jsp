
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
            <h1 class="title"> <spring:message code="pagamento.title"/> </h1>



            <form:form action="inserisci_pagamento" commandName="pagamento" method="post">
                <table>
                    <tr>
                        <td> <label><spring:message code="pagamento.importo"/>  </label> </td>
                        <td>  <input type="number" step="0.01" name="importo" id="importo" </td>
                        <td> <form:errors path="importo" cssClass="error"/> </td>
                    </tr>
                    <tr>
                        <td> <label><spring:message code="pagamento.numTesserino"/>  </label> </td>
                        <td>  <input type="text" name="numeroTesserino" id="numeroTesserino" </td>
                        <td> 
                            <c:if test="${not empty errore}">
                                    <div role="alert"  class="error">${errore}</div>	
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td> <label><spring:message code="pagamento.data"/>  </label> </td>
                        <td>  <input type="datetime-local" name="dataPagamento" id="dataPagamento" </td>   
                    </tr>

                </table>
                <input type="submit" value=<spring:message code="operazioni.invio"/> />

            </form:form>
            <jsp:include page="/WEB-INF/resources/template/footer.jsp" />    

    </body>
</html>
