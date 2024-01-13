
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
    <head>
        <meta hcharset="UTF-8">
        <title>Lista Account</title>
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
            <h1 class="title"> <spring:message code="lista_allievi.title"/> </h1>

            <table class="elenco">

                <tr>
                    <th> <spring:message code="inserisci_allievo.numTesserino"/> </th>
                    <th> <spring:message code="inserisci_allievo.nome"/> </th>
                    <th> <spring:message code="inserisci_allievo.cognome"/> </th>
                    <th> <spring:message code="inserisci_allievo.dataNascita"/> </th>
                    <th> <spring:message code="inserisci_allievo.luogoNascita"/> </th>
                    <th> <spring:message code="inserisci_allievo.via"/> </th>
                    <th> <spring:message code="inserisci_allievo.cap"/> </th>
                    <th> <spring:message code="inserisci_allievo.citta"/> </th>
                    <th><label><spring:message code="lista_genitori.operazione"/></label></th>
                </tr>
                <c:forEach items="${listaA}" var="item">
                    <tr>
                        <td><c:out value="${item.numeroTesserino}" /></td>
                        <td><c:out value="${item.nomeAllievo}" /></td>
                        <td><c:out value="${item.cognomeAllievo}" /></td>
                        <td><c:out value="${item.dataNascita}" /></td>
                        <td><c:out value="${item.luogoNascita}" /></td>
                        <td><c:out value="${item.via}" /></td>
                        <td><c:out value="${item.cap}" /></td>
                        <td><c:out value="${item.citta}" /></td>
                        <td> <a href="lista_allievi/delete?numTesserino=${item.numeroTesserino}" > <spring:message code="operazioni.cancella"/></a> </td>

                    </tr>
                </c:forEach>
            </table>
            <jsp:include page="/WEB-INF/resources/template/footer.jsp" />         
        </div> 
    </body>
</html>> <spring:message code="lista_genitori.title"/> </h1>