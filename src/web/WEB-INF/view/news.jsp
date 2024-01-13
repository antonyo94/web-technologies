<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
    <head>
        <title>News</title>
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

            <div class="row">


                <div class="col-lg-6">
                    <h1 class="title"> Newsletter </h1>
                    <p>
                        <h4 class="title">21/06/16	Aversa: l'accademia Frocalcio si esibisce al centro sportivo Igloo</h4>
                        AVERSA. Lunedì 20 giugno dalle ore 15 alle ore 20, il centro sportivo Igloo ad Aversa è stato palcoscenico di una magnifica giornata calcistica con protagonisti i giovani atleti dei settori giovanili.
                        Trattasi del raduno targato Accademia Frocalcio, che ha coinvolto oltre 100 giocatori dai 2002 ai 2005. Oltre ai giocatori, presenti sul campo gli osservatori del Frosinone Calcio, attenti nel loro compito di scovare giovani promesse, da inserire eventualmente nel progetto Accademia Frocalcio.
                        Ottime le performance dei 2005, che hanno suscitato vivo interesse al team Frocalcio, che allenerà gratuitamente per l'anno 2016/2017 i più talentuosi emersi dalla giornata di raduno. Vi saranno nel corso dei mesi di giugno e luglio altre giornate dedicate all'obiettivo di selezione, anche solo per i portieri.

                    </p>
                    <p>
                    <h4 class="title">13/6/2016 Aversa: Raduni San Luciano</h4>
                        Ricordiamo a tutti che LUNEDÌ 13 Giugno al centro sportivo Igloo di via Petrarca a Carinaro continuano i raduni FROCALCIO ACCADEMY. Selezioneremo in presenza di osservatori professionisti, le giovani promesse, che allenaremo gratuitamente per l'anno calcistico 2016/2017. Ecco il programma: 2002 ore 15:30, 2004 ore 17:00, 2005 re 17:00. Martedì secondo raduno portieri ore 18:30.
                    </p>
                </div>
            </div>











            <jsp:include page="/WEB-INF/resources/template/footer.jsp" />
        </div>

    </body>
</html>
