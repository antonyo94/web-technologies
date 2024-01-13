
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
            <h1 class="title"> <spring:message code="lista_genitori.title"/> </h1>

            <table class="elenco">
                
                    <tr>
                        <th> <spring:message code="lista_genitori.cf"/>  </th>
                        <th> <spring:message code="lista_genitori.nome"/> </th>
                        <th> <spring:message code="lista_genitori.cognome"/> </th>
                        <th> <spring:message code="lista_genitori.email"/> </th>
                        <th> <spring:message code="lista_genitori.telefono" /> </th>
                        <th> <spring:message code="lista_genitori.operazione"/>  </th>
                    </tr>
                    <c:forEach items="${listG}" var="item">
                    <tr>
                        <td><c:out value="${item.cf}" /></td>
                        <td><c:out value="${item.nomeGenitore}" /></td>
                        <td><c:out value="${item.cognomeGenitore}" /></td>
                        <td><c:out value="${item.email}" /></td>
                        <td>
                            <c:forEach items="${listP}" var="phoneList">
                                <c:if test="${phoneList.genitore.cf == item.cf }">
                                    	<c:out value="${phoneList.numeroTelefono} " />
                                </c:if>
                            </c:forEach>
                        </td>


                        <td> 
                            <a href="lista_genitori/delete?cf=${item.cf}" > <spring:message code="operazioni.cancella"/></a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <jsp:include page="/WEB-INF/resources/template/footer.jsp" />         
        </div> 
    </body>
</html>
