var map,osm,indikatorname,xml_url_ioer,xml_base_layer,legende_link,URL,BBOX,SRS,WIDTH,HEIGHT,X,Y;
;

$(function storage_position() {
    map.on('moveend',         function () {

        var centerPoint = map.getSize().divideBy(2),
            targetLatLng = map.containerPointToLatLng(centerPoint);

        localStorage.setItem("targetLat", targetLatLng.lat);
        localStorage.setItem("targetLng", targetLatLng.lng);

        console.log(targetLatLng.lat);
        console.log(targetLatLng.lng);

    });
    map.on('zoomend',         function () {

        var zoom = map.getZoom();

        localStorage.setItem("zoom", zoom);
        console.log(zoom);
    });
});

$(function zoomcontrol() {
    if (localStorage.getItem("check_mess") == "true"){

    }
    else{
        // kommt vlt noch
    }
});

function init_map(){

    /*
     Create the Menu und the functions
     */
    // The Menu part
    var menu_div = '<div id="menu">' +
        '<ul id="list">' +
        '<li id="menuPoint1"><img src="../../img/Icon/info.png"/><p class="info">Infos</p></li>' +
        '<li id="legende"><img src="../../img/Icon/legende.png"/><p class="info">Legende</p></li>' +
        '<li id="menuPoint2"><img src="../../img/Icon/ebenen.png"/><p class="info">Karten</p></li>' +
        '<li id="menuPoint3"><img src="../../img/Icon/kalender.png"/><p class="info">Zeit</p></li>' +
        '<li id="menuPoint4"><img src="../../img/Icon/lupe.png"/><p class="info">Adresse</p></li>' +
        '<li id="menuPoint5"> <img src="../../img/Icon/helligkeit.png"/><p class="info">Visibilität</p></li>' +
        '<li id="check_mess"><img src="../../img/Icon/ruler.png"/><p class="info">Messen</p></li>' +
        '<li id="check_minimap"><img src="../../img/Icon/minimap.png"/><p class="info">Minimap</p></li>' +
        //'<li id="check_3d"><img src="../../img/Icon/building.png"/><p class="info">3D</p></li>' +
        '<li name="slider" value="slider" id="slider"><img src="../../img/Icon/time_scroll.png"/><p class="info">Swipe</p></li>' +
        '<li id="zoom_control"><img src="../../img/Icon/zoom.png"/><p class="info">Zoom</p></li>' +
        '<li id="help"><img src="../../img/Icon/help.png"/><p class="info">Hilfe</p></li>'+
        '</ul>' +
        '</div>';

    // the JQuery Dialog Part
    var dialog_html = '<div id="dialog" class="dialog">'+
        '<div id="interpretation_d">'+
        '<h3 class="indikator_name"></h3>'+
        '<p>Interpretation der Karte auf Kreisbasis:</p>'+
        '<p id="interpretation_text"></p>'+
        '</div>'+

        '<div id="kennblatt_d">'+
        '<h3 class="indikator_name"></h3>'+
        '<h4>Kategorie:</h4>'+
        '<p id="kategorie"></p>'+
        '<h4>Ma&szlig;einheit:</h4>'+
        '<p id="masseinheit"></p>'+
        '<h4>Kurzbeschreibung:</h4>'+
        '<p id="kurzbeschreibung"></p>'+
        '<h4>Bedeutung und Interpretation:</h4>'+
        '<p id="bedeutung"></p>'+
        '<h4>Datengrundlagen:</h4>'+
        '<p id="datengrundlage"></p>'+
        '<h4>Methodik:</h4>'+
        '<p id="methodik"></p>'+
        '<h4>Bemerkungen:</h4>'+
        '<p id="bemerkungen"></p>'+
        '<h4>Quellen/Literatur:</h4>'+
        '<p id="quellen"></p>'+
        '</div>'+

        '<div id="legende_d">'+
        '<h4 id="legende_masseinheit"></h4>'+
        '<img id="legende_pic"/>'+
        '</div>'+
        '</div>';

    /*
     The subMenu
     */

    var subMenu_html = '<div class="subMenu" id="subMenuPoint1">'+
        '<div class="interpretation">Interpretation</div>'+
        '<div class="kennblatt">Kennblatt</div>'+
        '<div class="label"><a id="link" style="text-decoration: none;color: #284496;">Indikatorübersicht</a></div>'+
        '</div>'+

        '<div class="subMenu" id="subMenuPoint2">'+
        '<div id="ebenen"></div>'+
        '</div>'+

        '<div class="subMenu" id="subMenuPoint3">'+
        '<div id="content_three">'+
        '<div id="left">'+
        '<div id="slider_left"></div>'+
        '<div id="slider_label_left">2014</div>'+
        '</div>'+
        '<div id="right">'+
        '<div id="slider_right"></div>'+
        '<div id="slider_label_right">2006</div>'+
        '</div>'+
        '</div>'+
        '</div>'+

        '<div class="subMenu" id="subMenuPoint4">'+
        '<div id="search"></div>'+
        '</div>'+

        '<div class="subMenu" id="subMenuPoint5">'+
        '<div type="range" id="OpacitySlider"></div>'+
        '</div>';

    //The Arrow for scrolling left

    var arrow_html = '<div class="toggle_arrow"><i  class="fa fa-chevron-down fa-2x"></i></div>'+
        '<div id="next" class="arrow"><img src="../../img/Icon/next.png"/></div>'+
        '<div id="prev" class="arrow"><img src="../../img/Icon/prev.png"/></div>';

    $('body').append(menu_div,dialog_html,subMenu_html,arrow_html);

    $("#next").click(function () {
        $('#menu').scrollLeft($('#menu').scrollLeft() + 500);
        $('#prev').show();
    });

    $("#prev").click(function () {
        $('#menu').scrollLeft($('#menu').scrollLeft() - 500);
        $('#prev').hide();
    });

    $('body').on({
        'touchmove': function(e) {
            $('.arrow').hide();
        }
    });

    // the Show Events
    $('#menuPoint1').click(function () {
        $('#subMenuPoint1').toggle();
        $('#subMenuPoint2').hide();
        $('#subMenuPoint3').hide();
        $('#subMenuPoint4').hide();
        $('#subMenuPoint5').hide();
        $('#subMenuPoint6').hide();
    });

    $('#menuPoint2').click(function () {
        $('#subMenuPoint2').toggle();
        $('#subMenuPoint1').hide();
        $('#subMenuPoint3').hide();
        $('#subMenuPoint4').hide();
        $('#subMenuPoint5').hide();
        $('#subMenuPoint6').hide();
    });

    $('#menuPoint3').click(function () {
        $('#subMenuPoint3').toggle();
        $('#subMenuPoint1').hide();
        $('#subMenuPoint2').hide();
        $('#subMenuPoint4').hide();
        $('#subMenuPoint5').hide();
        $('#subMenuPoint6').hide();
    });

    $('#menuPoint4').click(function () {
        $('#subMenuPoint4').toggle();
        $('#subMenuPoint1').hide();
        $('#subMenuPoint3').hide();
        $('#subMenuPoint2').hide();
        $('#subMenuPoint5').hide();
        $('#subMenuPoint6').hide();
    });

    $('#menuPoint5').click(function () {
        $('#subMenuPoint5').toggle();
        $('#subMenuPoint1').hide();
        $('#subMenuPoint3').hide();
        $('#subMenuPoint4').hide();
        $('#subMenuPoint2').hide();
        $('#subMenuPoint6').hide();
    });

    $('#menuPoint6').click(function () {
        $('#subMenuPoint6').toggle();
        $('#subMenuPoint5').hide();
        $('#subMenuPoint1').hide();
        $('#subMenuPoint3').hide();
        $('#subMenuPoint4').hide();
        $('#subMenuPoint2').hide();
    });

    $('#menuPoint7').click(function () {
        $('#subMenuPoint7').toggle();
    });

    $('#menuPoint8').click(function () {
        $('#subMenuPoint8').toggle();
    });

    $('#menuPoint9').click(function () {
        $('#subMenuPoint9').toggle();
    });

    $('#map').click(function () {
        $(".subMenu").hide();
    });

    $('.toggle_arrow_sub').click(function () {
        $(".subMenu").hide();
    });

    /*
     The map Part
     */

    // fix for the 3D problem by old phones
    L.Browser.webkit3d = false;

    $('#widget').draggable();

    $.extend({
        title_page: function(url, data) {
            // local var
            var title = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find(indikatorname).each(function() {
                        title = $(this).find('title').text();
                    });
                }
            });
            // Return the response text
            return title;
        },
        masseinheit: function(url, data) {
            // local var
            var masseinheit = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find(indikatorname).each(function() {
                        masseinheit = $(this).find('masseinheit').text();
                    });
                }
            });
            // Return the response text
            return masseinheit;
        },
        ioer_layer: function(url, data) {
            // local var
            var link = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find(indikatorname).each(function() {
                        link = $(this).find('link').text();
                    });
                }
            });
            // Return the response text
            return link;
        },
        osm_layer: function(url, data) {
            // local var
            var link = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("osm").each(function() {
                        link = $(this).find('link').text();
                    });
                }
            });
            // Return the response text
            return link;
        },
        vg_25_link: function(url, data) {
            // local var
            var link = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("vg25").each(function() {
                        link = $(this).find('link').text();
                    });
                }
            });
            // Return the response text
            return link;
        },
        laendergrenzen: function(url, data) {
            // local var
            var layer = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("vg25").each(function() {
                        layer = $(this).find('layer_laendergrenzen').text();
                    });
                }
            });
            // Return the response text
            return layer;
        },
        kreisgrenzen: function(url, data) {
            // local var
            var layer = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("vg25").each(function() {
                        layer = $(this).find('layer_kreisgrenzen').text();
                    });
                }
            });
            // Return the response text
            return layer;
        },
        gemeindegrenzen: function(url, data) {
            // local var
            var layer = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("vg25").each(function() {
                        layer = $(this).find('layer_gemeindegrenzen').text();
                    });
                }
            });
            // Return the response text
            return layer;
        },
        webDe_layer: function(url, data) {
            // local var
            var link = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("webatlas_de").each(function() {
                        link = $(this).find('link').text();
                    });
                }
            });
            // Return the response text
            return link;
        },
        year_layer: function (url, data) {
            // local var
            var a = [];
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data) {
                    $(data).find(indikatorname).each(function () {
                        a = $(this).find('year').map(function() {
                            return $(this).text();
                        }).get();
                    });
                }
            });
            // Return the response text
            return a;
        },
        layer_name: function (url, data) {
            // local var
            var name = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find(indikatorname).each(function() {
                        name = $(this).find('layer').text();
                    });
                }
            });
            // Return the response text
            return name;
        }
    });

    // set ajax response in var
    var xData = $.ioer_layer(xml_url_ioer, {issession: 1,selector: true});
    var osm = $.osm_layer(xml_base_layer, {issession: 1,selector: true});
    var web = $.webDe_layer(xml_base_layer, {issession: 1,selector: true});
    var layer_name = $.layer_name(xml_url_ioer, {issession: 1,selector: true});
    var vg25_link = $.vg_25_link(xml_base_layer, {issession: 1,selector: true});
    var masseinheit = $.masseinheit(xml_url_ioer, {issession: 1,selector: true});
    var layer_grenze_laender = $.laendergrenzen(xml_base_layer, {issession: 1,selector: true});
    var layer_grenze_kreis = $.kreisgrenzen(xml_base_layer, {issession: 1,selector: true});
    var layer_grenze_gemeinde = $.gemeindegrenzen(xml_base_layer, {issession: 1,selector: true});
    var page_title = $.title_page(xml_url_ioer, {issession: 1,selector: true});

    var zoom_control;

    // set ajax response in var
    var years = new Array();

    var years = $.year_layer(xml_url_ioer, {issession: 1,selector: true});

    // get the title of the page
    $(document).ready(function ()
    {
        document.title = page_title;
        console.log("Name of the Page: "+page_title);
    });

    var maxValueInArray = Math.max.apply(Math, years);
    var minValueInArray = Math.min.apply(Math, years);
    $("#slider_label_left").text(maxValueInArray);
    $("#slider_label_right").text(minValueInArray);
    console.log("neuester Layer :"+ maxValueInArray);
    console.log("Layername :"+ layer_name);

    var osmUrl = osm,
        osmAttrib = '&copy; <a href="http://openstreetmap.org/copyright">OpenStreetMap</a>',
        osm = L.tileLayer.grayscale(osmUrl, {attribution: osmAttrib});

    $(function set_view() {
        if (localStorage.getItem("zoom") == null){
            map.setView(new L.LatLng(50.9307, 9.7558),8);

        } else if(localStorage.getItem("targetLat") == null){
            map.setView(new L.LatLng(50.9307, 9.7558),8);
        }else {
            map.setView(new L.LatLng(localStorage.getItem("targetLat"), localStorage.getItem("targetLng")),localStorage.getItem("zoom"));
        }
    });

    L.control.scale({
        imperial:false,
    }).addTo(map);// add Scalebar

    $(function loading_control() {
        //Loading Control
        var loadingControl = L.Control.loading({
            separate: true
        });
        map.addControl(loadingControl);
    });

    $(function create_layers() {

        var wms_links = new L.tileLayer.wms(xData, {
            layers: layer_name+minValueInArray+'_a',
            version: '1.3.0',
            format: 'image/png',
            transparent: true,
            opacity: 0.5
        });

        var wms_rechts = new L.tileLayer.wms(xData, {
            layers: layer_name+maxValueInArray+'_a',
            version: '1.3.0',
            format: 'image/png',
            transparent: true,
            opacity: 0.5
        });

        // WMS Webatlas
        var webatlas = new L.tileLayer.wms(web, {
            layers: 'webatlasde.light_grau',
            version: '1.3.0',
            format: 'image/png',
            transparent: true,
            attribution: '&copy; <a href="http://www.bkg.bund.de">BKG</a>',
        });
        map.addLayer(webatlas);

        wms_links.setOpacity(0.5);
        wms_rechts.setOpacity(0.5);

        $(function opacity_slider() {
            $("#OpacitySlider").slider({
                range: "min",
                min: 0,
                max: 100,
                value: 60,
                step: 10,
                slide: function (event, ui) {
                    var slider_value = ui.value / 100;
                    wms_links.setOpacity(slider_value);
                    wms_rechts.setOpacity(slider_value);
                }
            });
        });

        var wmslaendergr = new L.tileLayer.wms(vg25_link, {
            layers: layer_grenze_laender,
            version: '1.3.0',
            format: 'image/png',
            transparent: true,
            style: 'default'
        });

        var wmskreisgr = new L.tileLayer.wms(vg25_link, {
            layers: layer_grenze_kreis,
            version: '1.3.0',
            format: 'image/png',
            transparent: true,
            style: 'default'
        });

        var wmsgemeindekrgr = new L.tileLayer.wms(vg25_link, {
            layers: layer_grenze_gemeinde,
            version: '1.3.0',
            format: 'image/png',
            transparent: true,
            style: 'default'
        });

        //Layer Control Basemaps
        var baseMaps = {
            "<div id='webatlas'>Webatlas</div>": webatlas,
            "<div id='osm'>OpenStreetMap</div>": osm
        };

        var overlayMaps = {
            "<div id='laender'>L\u00e4ndergrenzen</div>": wmslaendergr,
            "<div id='kreise'>Kreisgrenzen</div>": wmskreisgr,
            "<div id='gemeinde'>Gemeindegrenzen</div>": wmsgemeindekrgr
        };

        var ebenen = L.control.layers(baseMaps,overlayMaps,{collapsed:false});
        ebenen._map = map;
        var ebenenDiv = ebenen.onAdd(map);
        document.getElementById('ebenen').appendChild(ebenenDiv);

        var links = {
            "": osm,
            "WMS_IOER": wms_links
        };

        var timelayers = {
            "WMS_IOER": wms_rechts
        };

        var ebenent = L.control.layers(links,timelayers, {collapsed: false});
        ebenent._map = map;

        var layer_left;
        var layer_right;
        var side_by_side_abg = L.control.sideBySide(layer_left, layer_right).addTo(map);

        layer_left = wms_links;
        side_by_side_abg.setLeftLayers(layer_left.addTo(map));

        layer_right = wms_rechts;
        side_by_side_abg.setRightLayers(layer_right.addTo(map));

        var slider_value;

        $(function time_slider_right() {
            $("#slider_right").slider({
                range: "min",
                orientation: "vertical",
                min: 0,
                max: years.length - 1,
                step: 1,
                slide: function (e, ui) {
                    $("#slider_label_right").text(years[ui.value]);
                    map.removeLayer(layer_right);
                    layer_right = wms_rechts;
                    slider_value = years[ui.value];
                    layer_right.setParams({layers:layer_name + years[ui.value] + '_a'});
                    side_by_side_abg.setRightLayers(layer_right.addTo(map));
                    console.log("Add Time Layer Right==============" +layer_name+ years[ui.value] + '_a');

                }
            });
        });

        var slider_legende;

        $(function time_slider_left() {
            $("#slider_left").slider({
                range: "min",
                orientation: "vertical",
                min: 0,
                max: years.length - 1,
                value: maxValueInArray,
                step: 1,
                slide: function (e, ui) {

                    $("#slider_label_left").text(years[ui.value]);
                    map.removeLayer(layer_left);
                    layer_left = wms_links;
                    slider_value = years[ui.value];
                    layer_left.setParams({layers: layer_name + years[ui.value] + '_a'});
                    side_by_side_abg.setLeftLayers(layer_left.addTo(map));
                    console.log("Add Time Layer Left==============" +layer_name+ years[ui.value] + '_a');
                    slider_legende = xData + "language=ger&version=1.3.0&service=WMS&request=GetLegendGraphic&sld_version=1.1.0&layer=" + layer_name + years[ui.value] + "_a&format=image/png&STYLE=default";
                    console.log("Link Legende Slide:" + slider_legende);
                    $('#legende_pic').attr("src", slider_legende);
                }
            });
        });

        // initialize the legende on start, if slide is null
        if(legende_link == null) {
            $('#legende_pic').attr("src", xData + "language=ger&version=1.3.0&service=WMS&request=GetLegendGraphic&sld_version=1.1.0&layer=" + layer_name + maxValueInArray + "_a&format=image/png&STYLE=default");
            console.log("Legende Link on start");
        }

        // get Feature Info on Click
        function Identify (e) {
            BBOX = map.getBounds().toBBoxString();
            SRS = 'EPSG:4326';
            WIDTH = map.getSize().x;
            HEIGHT = map.getSize().y;
            X = map.layerPointToContainerPoint(e.layerPoint).x;
            Y = map.layerPointToContainerPoint(e.layerPoint).y;

            if( slider_value === undefined || slider_value === null){
                console.log("url unverändert");
                URL = xData + 'SERVICE=WMS&VERSION=1.1.1&REQUEST=GetFeatureInfo&BBOX='+BBOX+'&SRS='+SRS+'&WIDTH='+WIDTH+'&HEIGHT='+HEIGHT+'&LAYERS='+layer_name + maxValueInArray + '_a'+'&STYLES=&FORMAT=image/png&TRANSPARENT=true&QUERY_LAYERS='+layer_name + maxValueInArray + '_a'+'&INFO_FORMAT=html&X='+X+'&Y='+Y;
            }
            else{
                console.log("url geändert"+URL);
                URL = xData + 'SERVICE=WMS&VERSION=1.1.1&REQUEST=GetFeatureInfo&BBOX='+BBOX+'&SRS='+SRS+'&WIDTH='+WIDTH+'&HEIGHT='+HEIGHT+'&LAYERS='+layer_name + slider_value + '_a'+'&STYLES=&FORMAT=image/png&TRANSPARENT=true&QUERY_LAYERS='+layer_name + slider_value + '_a'+'&INFO_FORMAT=html&X='+X+'&Y='+Y;
            }

            $.ajax({
                url:URL,
                datatype: "html",
                type: "GET",
                success: function(data) {
                    var popup = new L.popup({
                        maxWith: 300
                    });
                    popup.setContent(data);
                    popup.setLatLng(e.latlng);
                    map.openPopup(popup);
                }
            });
        }

        map.addEventListener('click', Identify);

        $('#legende').click(function () {
            $('#menu').hide();
            $( ".toggle_arrow" ).html('<i class="fa fa-arrow-down fa-2x"></i>');
            $("#legende_d").dialog({
                height: 300,
                draggable: false,
                modal: true,
                resizable: false,
                show: 'blind',
                hide: 'blind',
                title: 'Legende',
                dialogClass: 'ui-dialog-osx',
                dialogClass: 'no-close success-dialog',
                dialogClass: "#legende_d",
                open: function() {
                    $('.arrow').hide();
                    $( ".toggle_arrow" ).show();
                    $( ".toggle_arrow" ).html('<i class="fa fa-chevron-down fa-2x"></i>');
                    $(".subMenu").hide();
                    $(this).closest(".ui-dialog")
                        .find(".ui-dialog-titlebar-close")
                        .html("<span class='ui-button-icon-primary ui-icon ui-icon-closethick'></span>");
                }
            });
        });
        $('#legende_masseinheit').text("Einheit: " + masseinheit);

        //tools
        var mess = 0;
        var mini = 0;
        var zoom = 0;
        var menu = 0;
        var three_d = 0;

        // the Toggle Menu
        $(function menu_toggle() {
            $('.toggle_arrow').click(function () {
                if(menu == 0) {
                    $('#menu').toggle();
                    $("#next").show();
                    $( ".toggle_arrow" ).html('<i class="fa fa-chevron-up fa-2x"></i>');
                    menu++;
                }else{
                    $( ".toggle_arrow" ).html('<i class="fa fa-chevron-down fa-2x"></i>');
                    $('#menu').hide();
                    $('#next').hide();
                    menu=0;
                }
            });
        });
        // Measure Tool
        var measureControl = L.control.measure({
            primaryLengthUnit: 'kilometers',
            secondaryLengthUnit: 'meters',
            primaryAreaUnit: 'hectares',
            activeColor: '#8bba23',
            completedColor: '#284496',
            position: 'bottomright'
        });

        $('#check_mess').click(function(){
            if(mess == 0){
                $('#check_mess').css('background-color','black');
                measureControl.addTo(map);
                console.log("Messen klick 1");
                $('#menu').hide();
                $('.arrow').hide();
                $('.subMenu').hide();
                $( ".toggle_arrow" ).html('<i class="fa fa-chevron-down fa-2x"></i>');
                mess++;
            }else{
                measureControl.removeFrom(map);
                console.log("Messen klick 2");
                $('#check_mess').css('background-color','#284496');
                mess=0;
            }
        });

        // Minimap
        var rect1 = {color: "#ff1100", weight: 3};
        var rect2 = {color: "#0000AA", weight: 1, opacity:0, fillOpacity:0};
        //Plugin magic goes here! Note that you cannot use the same layer object again, as that will confuse the two map controls
        var osm2 = new L.TileLayer(osmUrl, {minZoom: 0, maxZoom: 13, attribution: osmAttrib });
        var miniMap = new L.Control.MiniMap(osm2, {
            toggleDisplay: true,
            aimingRectOptions : rect1,
            shadowRectOptions: rect2,
            width: 100,
            position: 'topleft',
            height: 100
        });

        $('#check_minimap').click(function(){
            if(mini == 0){
                $('#check_minimap').css('background-color','black');
                miniMap.addTo(map);
                console.log("Messen klick 1");
                $('#menu').hide();
                $('.arrow').hide();
                $('.subMenu').hide();
                $( ".toggle_arrow" ).html('<i class="fa fa-chevron-down fa-2x"></i>');
                mini++;
            }else{
                miniMap.removeFrom(map);
                console.log("Messen klick 2");
                $('#check_minimap').css('background-color','#284496');
                mini=0;
            }
        });

        // Zoom Control
        var zoom_control = new L.control.zoom({position:'topright'});

        $('#zoom_control').click(function(){
            if(zoom == 0){
                $('#zoom_control').css('background-color','black');
                zoom_control.addTo(map);
                console.log("Messen klick 1");
                $('#menu').hide();
                $('.arrow').hide();
                $('.subMenu').hide();
                $( ".toggle_arrow" ).html('<i class="fa fa-chevron-down fa-2x"></i>');
                zoom++;
            }else{
                zoom_control.removeFrom(map);
                console.log("Messen klick 2");
                $('#zoom_control').css('background-color','#284496');
                zoom=0;
            }
        });
        //slider
        $('#slider').css('background-color','black');
        $('#slider').click(function(){
            localStorage.setItem("slider", "false");
            location.reload();
            $('#menu').hide();
        });

        var osmLayer = new OSMBuildings(map);

        /*OSM 3D
        $('#check_3d').click(function(){
            if(three_d == 0){
                $('#check_3d').css('background-color','black');
                map.addLayer(osmLayer.load());
                three_d++;
            }else{
                $('#check_3d').css('background-color','#284496');
                map.removeLayer(osmLayer);
                three_d=0;
            }
        });*/
    });

    $(function geosearch() {
        // The Geosearch
        var search = document.getElementById('search');
        search.appendChild(new L.Control.GeoSearch({
            provider: new L.GeoSearch.Provider.OpenStreetMap(),
        }).onAdd(map));
    });

    // Ortungsfunktion
    $('head').append('<script src="../../js/L.Control.Locate.js" ></script>');
    $('head').append('<link rel="stylesheet" href="../../css/L.Control.Locate.min.css" />');
    L.control.locate({
        position: 'bottomright',
        icon: 'fa fa-location-arrow fa-2x',
        iconLoading:'fa fa-spinner fa-spin fa-2x',
        locateOptions: {
            maxZoom:14
        }
    }).addTo(map);

    $(function slider() {
        if (localStorage.getItem("slider") == "false"){
            window.open("../local.html","_self");
            localStorage.setItem("slider",false);
        }
        else{
            localStorage.setItem("slider",true);
        }
    });

    $(function loading_control() {
        //Loading Control
        var loadingControl = L.Control.loading({
            separate: true
        });
        map.addControl(loadingControl);
    });
}