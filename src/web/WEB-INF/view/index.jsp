<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
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

            <div class slider>
                <img class="slider-image" src="<c:url value="/resources/css/img/slider-1.jpg"/>" alt="La scuola calcio dei leoni!" />

            </div>

            <div class="row">




                <!--COLONNA 1-->
                <div class="col-lg-6">
                    <h2 class="title">Storia della  società</h2>
                    <p>La Scuola Calcio è nata nel 2012 su iniziativa di alcune persone che hanno inteso mettere al servizio dei bambini la loro passione per il "pallone" e la professionalità  maturata in anni di attività  agonistica.
                        È stato subito un grande successo perchè le attività  proposte andavano incontro ad esigenze che da anni aspettavano di essere soddisfatte.
                        Negli anni sempre più bambini si sono iscritti e sempre più famiglie ci hanno riconosciuto come un interlocutore importante per la gestione del tempo libero dei propri figli. 
                        La gestione di un così grande numero di bambini si realizza per l´impegno costante di molte persone che, nel più puro spirito di volontariato, dedicano il loro tempo libero nella risoluzione degli innumerevoli problemi che l´attività  comporta.
                        Un aiuto insostituibile viene da molti genitori, i quali offrono la loro disponibilità  e contribuiscono alla riuscita dei progetti. 
                        Durante il percorso abbiamo sempre avuto al nostro fianco il sostegno insostituibile di numerosi sponsor a testimonianza dell´avvenuta integrazione nel tessuto sociale.
                        È evidente però che senza la sensibilità , la vicinanza morale e materiale delle varie Amministrazioni Comunali, la Scuola Calcio non avrebbe potuto sopravvivere e continuare il suo servizio.
                        Negli anni l´impegno, la passione, lo studio hanno permesso alla Scuola Calcio di migliorare la propria offerta formativa e grazie al raggiungimento di requisiti societari, organizzativi, tecnici, di strutture e di programmi a livello qualificato è stata anche riconosciuta dalla F.I.G.C. "Scuola Calcio Specializzata".
                        Cerchiamo di trasmettere a tutti i nostri allievi non solo le capacità motorie, tecniche, tattiche ed agonistiche necessarie per una formazione sportiva ed in particolare calcistica, ma ci proponiamo di essere, assieme ad altre agenzie educative come la scuola, la famiglia, la Chiesa, un supporto integrativo all´educazione di giovani responsabili che diverranno, speriamo buoni calciatori, ma soprattutto cittadini onesti.
                </div>

                <!--COLONNA 2-->
                <div class="col-lg-6">
                    <h2 class="title">Al giorno d'oggi...</h2>

                    <p>
                        La mission è infatti quella di creare un bacino di  piccoli calciatori attraverso un progetto interdisciplinare che coniughi l'aspetto organizzativo a quello della valorizzazione e della scoperta dei giovani talenti.
                        Per quanto riguarda la formazione e l'insegnamento è stata appositamente creata un'esperta e affiatata squadra d' istruttori che aiuteranno le singole società nello sviluppo del proprio lavoro.
                        Particolare attenzione ed enfasi saranno poste anche agli aspetti psico-socio-pedagocici, che insieme all'area tecnico-tattica e condizionale, costituiranno le materie principali dei corsi di formazione e dei seminari destinati a tutti gli allenatori delle società affiliate. In questo ambito fondamentale sarà l'apporto del Scuola Calcio Frosinone che, avvalendosi della frequente presenza dei propri allenatori sui campi delle Società, garantirà un costante controllo sull'attività sportiva.
                        Tutti i ragazzi iscritti alle Scuola Calcio San Luciano sono accomunati dal kit di abbigliamento sportivo utilizzato durante gli allenamenti. Tutte le Scuole Affiliate infatti, così come la prima squadra, saranno rigorosamente vestite Legea.

                    </p>
                </div>


            </div>



            <footer id="footer">
                <small>Copyright<br>
                    © 2016 SCUOLA CALCIO SAN LUCIANO. </small>
            </footer>
        </div>
    </body>
</html>
