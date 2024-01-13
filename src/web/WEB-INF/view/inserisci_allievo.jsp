
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

            <h1 class="title"> <spring:message code="inserisci_allievo.title"/> </h1>
            <form:form method="post" commandName="allievo" action="inserisci_allievo"  >

                <table>
                    <!--Genitore-->
                    <tr>
                        <td><label> <spring:message code="genitore.nome"/> </label> </td>
                        <td><input  type="text" name="nomeGenitore" id="nomeGenitore" /></td>
                        <td>
                            <c:if test="${not empty erroreCf}">
                                <div role="alert" class="error">${erroreCf}</div>	
                            </c:if>
                        </td>

                    </tr>
                    <tr>
                        <td><label> <spring:message code="genitore.cognome"/> </label> </td>
                        <td><input type="text" name="cognomeGenitore" id="cognomeGenitore"/></td>

                    </tr>
                    <tr>
                        <td><label> <spring:message code="genitore.cdf"/> </label> </td>
                        <td><input type="text" name="cf" id="codiceFiscale" value="${genitore.cf}"/></td>
                    </tr>
                    <tr>
                        <td><label> Email </label> </td>
                        <td><input type="email" name="email" id="email"  /></td>
                        <td>
                            <c:if test="${not empty erroreEmail}">
                                <div role="alert" class="error">${erroreEmail}</div>	
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td><label> Password </label> </td>
                        <td><input type="password" name="password" id="password"  /></td>
                    </tr>
                    <tr>
                        <td><label> <spring:message code="genitore.telefono"/> </label> </td>
                        <td><input type="tel" name="numeroTelefono" id="numeroTelefono" /></td>
                    </tr>



                    <tr>
                        <td><label> <spring:message code="inserisci_allievo.numTesserino"/> </label> </td>
                        <td><input type="text" name="numeroTesserino" id="numeroTesserino" /></td>
                        <td> <form:errors path="numeroTesserino" cssClass="error"/> </td>                 
                    </tr>
                    <tr>
                        <td><label> <spring:message code="inserisci_allievo.nome"/> </label> </td>
                        <td><input type="text" name="nomeAllievo" id="nomeAllievo" /></td>
                        <td> <form:errors path="nomeAllievo" cssClass="error"/> </td>   

                    </tr>
                    <tr>
                        <td><label> <spring:message code="inserisci_allievo.cognome"/> </label> </td>
                        <td><input type="text" name="cognomeAllievo" id="cognomeAllievo" /></td>
                        <td> <form:errors path="cognomeAllievo" cssClass="error"/> </td>  
                    </tr>
                    <tr>
                        <td><label> <spring:message code="inserisci_allievo.dataNascita"/> </label> </td>
                        <td><input type="datetime-local" name="dataNascita" id="dataNascita" /></td>
                        <td> <form:errors path="dataNascita" cssClass="error"/> </td>  
                    </tr>
                    <tr>
                        <td><label> <spring:message code="inserisci_allievo.luogoNascita"/> </label> </td>
                        <td><input type="text" name="luogoNascita" id="luogoNascita" /></td>
                    </tr>
                    <tr>
                        <td><label> <spring:message code="inserisci_allievo.via"/> </label> </td>
                        <td><input type="text" name="via" id="via" /></td>
                        <td> <form:errors path="via" cssClass="error"/> </td>   
                    </tr>
                    <tr>
                        <td><label> <spring:message code="inserisci_allievo.cap"/> </label> </td>
                        <td><input type="text" name="cap" id="cap" /></td>
                        <td> <form:errors path="cap" cssClass="error"/> </td>   
                    </tr>
                    <tr>
                        <td><label> <spring:message code="inserisci_allievo.citta"/> </label> </td>
                        <td><input type="text" name="citta" id="citta" /></td>
                        <td> <form:errors path="citta" cssClass="error"/> </td>   
                    </tr>

                </table>


                <input type="submit" value=<spring:message code="operazioni.invio"/> />


            </form:form>
            <jsp:include page="/WEB-INF/resources/template/footer.jsp" />         
        </div> 
    </body>
</html>