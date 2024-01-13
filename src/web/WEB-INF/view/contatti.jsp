
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
            
            <h1 class="title">Sporting Club San Luciano</h1>
            
            <h5 class="title"><spring:message code="contatti.indirizzo"/> </h5> Centro Sportivo San Luciano, Via Don Milani, 81030 Lusciano
            <h5 class="title"> <spring:message code="contatti.presidente"/> </h5>  Alberta Canciello
            <h5 class="title"> <spring:message code="contatti.fondazione"/> </h5>  2012
            <h5 class="title"> <spring:message code="contatti.coloriSociali"/>  </h5> Giallo-blu
            <h5 class="title"><spring:message code="contatti.telefonoSede"/></h5>  0813628092
            <h5 class="title">EMAIL</h5>  maxnugnes@libero.it
            
            
            <jsp:include page="/WEB-INF/resources/template/footer.jsp" />         
        </div> 
    </body>
</html>
