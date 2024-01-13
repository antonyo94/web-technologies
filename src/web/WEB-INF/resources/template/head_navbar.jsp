<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>


<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="<c:url value="/resources/css/stileHome.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/js/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
        <script src="<c:url value="/resources/js//jquery/jquery-1.9.1.js"/>" type="text/javascript"></script> 
        <script src="<c:url value="/resources/js/bootstrap/js/bootstrap.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/jquery/jquery.min.js"/>"  type="text/javascript"></script> 
        <link rel="icon" type="image/png" href="<c:url value="/resources/css/img/logo.png"/>" sizes="32x32">
    </head>

    <body>
        <header id="intestazioneSito" >
            <h1 id="titoloSito">Scuola Calcio San Luciano</h1>
            <img class="logo" src="<c:url value="/resources/css/img/logo.png"/>" alt="Logo San Luciano"width=150 height=100 />
            <div class="collegamenti">
                <div class="top-right">
                    <a class="fb" href="https://www.facebook.com/S.C.SANLUCIANO"><img  src="<c:url value="/resources/css/img/fb-icon.png"/>" alt="logo-fb" width="20" height="20"></a>
                </div>
                <div class="bottom-right">
                    <a class="translate" href="?local=it"><img  src="<c:url value="/resources/css/img/Italy-Flag.png"/>" alt="Italy" width="20" height="20"></a>
                    <a class="translate" href="?local=en"><img  src="<c:url value="/resources/css/img/British-Flag.png"/>" alt="British" width="20" height="20"></a>
                </div>

            </div>

        </header> 

        <!--
        
        
        
        -->

        <nav class="navbar navbar-default" id="barraNavigazione" role="navigation">

            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Espandi barra di navigazione</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>

            </div>

            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav " >
                      <li><a href="home"><spring:message code="navbar.home"/></a></li>
                        <li><a href="news"><spring:message code="navbar.news"/></a></li>
                        <li><a href="login"><spring:message code="navbar.login"/></a></li>

                    <sec:authorize access="hasRole('ROLE_PARENT')">
                        <!-- MENU A DISCESA -->
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <spring:message code="navbar.parent"/> <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="lista_pagamenti_effettuati"><spring:message code="navbar.parent.list"/></a></li>
                            </ul>
                        </li>
                        <!-- MENU A DISCESA -->
                    </sec:authorize>
                    <li><a href="contatti"><spring:message code="navbar.contatti"/></a></li>




                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <!-- MENU A DISCESA -->
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <spring:message code="navbar.admin"/> <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="inserisci_allievo"><spring:message code="navbar.drop.insertAllievo"/></a></li>
                                <li><a href="inserisci_pagamento"><spring:message code="navbar.drop.insertPagamento"/></a></li>
                                <li><a href="inserisci_account"><spring:message code="navbar.drop.creaAccount"/></a></li>
                                <li><a href="lista_genitori"><spring:message code="navbar.drop.listaGenitori"/></a></li>
                                <li><a href="lista_allievi"><spring:message code="navbar.drop.listaAllievi"/></a></li>
                                <li><a href="lista_pagamenti"><spring:message code="navbar.drop.listaPagamenti"/></a></li>
                                 <li><a href="lista_account"><spring:message code="navbar.drop.listaAccount"/></a></li>
                            </ul>
                        </li>
                        <!-- MENU A DISCESA -->

                    </sec:authorize>

                </ul>

                <sec:authorize access="isAuthenticated()">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                    </ul>
                </sec:authorize>



            </div>
        </nav>
    </body>
</html>
