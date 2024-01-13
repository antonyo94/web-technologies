<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Pagamenti</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
            <h1 class="title"> <spring:message code="lista_pagamenti_effettuati.title"/> </h1>
            <h2>Utente: ${username}</h2>
            <table class="elenco">

                <tr>
                    <th><label><spring:message code="lista_pagamenti_effettuati.importo"/></label></th>
                    <th><label><spring:message code="lista_pagamenti_effettuati.tesserino"/></label></th>
                    <th><label><spring:message code="lista_pagamenti_effettuati.data"/></label></th>
                </tr>
                <c:forEach items="${listaPagamenti}" var="item">
                    <tr>
                        <td> <c:out value="${item.importo}" /></td>  
                        <td> <c:out value="${item.numTesserino.numeroTesserino}" /></td>  
                        <td> <c:out value="${item.dataPagamento}" /></td>  
                    </tr>

                </c:forEach>
            </table>
            <jsp:include page="/WEB-INF/resources/template/footer.jsp" /> 
        </div>
    </body>
</html>
