<%-- 
    Document   : head
    Created on : 30-apr-2014, 22.42.52
    Author     : Sasha Alexandru Podgoreanu
--%>
<meta name="Keywords" content="ristrutturazioni, ristruturazione, edilizia, decoratore, impianto, eletrico, eletrici, idraulici, idraulico, rivestimenti pavimenti, intonaco">
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
<meta name="description" content="Ristrutturazioni Damici Sorin"> 
<meta name="author" content="Damici Sorin">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Damici Ristrutturazioni</title>
<!-- Style -->
<link href="${pageContext.request.getContextPath()}/css/stile.css" rel="stylesheet"> <!-- 1 KB -->
<!-- Link to jQuery -->       
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script> <!-- 94 KB -->
<script>!window.jQuery && document.write('<script src="${pageContext.request.getContextPath()}/js/jquery-1.11.0.min"><\/script>');</script>
<!-- Bootstrap -->
<link href="${pageContext.request.getContextPath()}/css/bootstrap.min.css" rel="stylesheet"> <!-- 120 KB -->
<!-- Bootstrap plugins -->
<script src="${pageContext.request.getContextPath()}/js/bootstrap.min.js"></script> <!-- 28 KB -->
<script src="${pageContext.request.getContextPath()}/js/tooltip.js"></script> <!-- 28 KB -->
<!-- fotorama.css & fotorama.js -->
<link  href="${pageContext.request.getContextPath()}/css/fotorama.css" rel="stylesheet"> <!-- 3 KB -->
<script src="${pageContext.request.getContextPath()}/js/fotorama.js"></script> <!-- 15 KB -->
<!-- Google Analytics -->
<script>
    (function(i, s, o, g, r, a, m) {
        i['GoogleAnalyticsObject'] = r;
        i[r] = i[r] || function() {
            (i[r].q = i[r].q || []).push(arguments)
        }, i[r].l = 1 * new Date();
        a = s.createElement(o),
                m = s.getElementsByTagName(o)[0];
        a.async = 1;
        a.src = g;
        m.parentNode.insertBefore(a, m)
    })(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');

    ga('create', 'UA-50436982-1', 'damicicostruzioni.it');
    ga('send', 'pageview');

</script>
<!-- Google Maps -->
<script src="https://maps.googleapis.com/maps/api/js"></script>
<script>
   var myLatlng = new google.maps.LatLng(45.07160, 7.70528);
    function initialize() {
        var mapOptions = {
            zoom: 10,
            center: myLatlng,
            mapTypeId: google.maps.MapTypeId.ROADMAP};
        var map = new google.maps.Map(document.getElementById('map_canvas'), mapOptions);
        var marker = new google.maps.Marker({position: myLatlng, map: map});
    }
    google.maps.event.addDomListener(window, 'load', initialize);
</script>

