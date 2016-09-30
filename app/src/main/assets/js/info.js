var indikatorname,xml_url_ioer,link,info_xml;

function info(){

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
        interpretation: function(url, data) {
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
                        title = $(this).find('interpretation').text();
                    });
                }
            });
            // Return the response text
            return title;
        },
        kategorie: function(url, data) {
            // local var
            var kategorie = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find(indikatorname).each(function() {
                        kategorie = $(this).find('kategorie').text();
                    });
                }
            });
            // Return the response text
            return kategorie;
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
        kurzbeschreibung: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find(indikatorname).each(function() {
                        text = $(this).find('kurzbeschreibung').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        bedeutung: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find(indikatorname).each(function() {
                        text = $(this).find('bedeutung').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        datengrundlage: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find(indikatorname).each(function() {
                        text = $(this).find('datengrundlage').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        methodik: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find(indikatorname).each(function() {
                        text = $(this).find('methodik').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        bemerkungen: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find(indikatorname).each(function() {
                        text = $(this).find('bemerkungen').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        quellen: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find(indikatorname).each(function() {
                        text = $(this).find('quellen').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        //hilfe
        info_title: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("info").each(function() {
                        text = $(this).find('title').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        info_text: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("info").each(function() {
                        text = $(this).find('text').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        legende_title: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("legende").each(function() {
                        text = $(this).find('title').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        legende_text: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("legende").each(function() {
                        text = $(this).find('text').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
       ebenen_title: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("ebenen").each(function() {
                        text = $(this).find('title').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        ebenen_text: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("ebenen").each(function() {
                        text = $(this).find('text').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        zeit_title: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("kalender").each(function() {
                        text = $(this).find('title').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        zeit_text: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("kalender").each(function() {
                        text = $(this).find('text').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        suche_title: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("suche").each(function() {
                        text = $(this).find('title').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        suche_text: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("suche").each(function() {
                        text = $(this).find('text').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
       tran_title: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("transparenz").each(function() {
                        text = $(this).find('title').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        tran_text: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("transparenz").each(function() {
                        text = $(this).find('text').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        messen_title: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("messen").each(function() {
                        text = $(this).find('title').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        messen_text: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("messen").each(function() {
                        text = $(this).find('text').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        mini_title: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("minimap").each(function() {
                        text = $(this).find('title').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        mini_text: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("minimap").each(function() {
                        text = $(this).find('text').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
       slider_title: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("timeslider").each(function() {
                        text = $(this).find('title').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        slider_text: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("timeslider").each(function() {
                        text = $(this).find('text').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        zoom_title: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("zoom").each(function() {
                        text = $(this).find('title').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
       zoom_text: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("zoom").each(function() {
                        text = $(this).find('text').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        gps_title: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("gps").each(function() {
                        text = $(this).find('title').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        gps_text: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("gps").each(function() {
                        text = $(this).find('text').text();
                    });
                }
            });
            // Return the response text
            return text;
        }
    });

    var interpretation = $.interpretation(xml_url_ioer, {issession: 1,selector: true});
    var page_title = $.title_page(xml_url_ioer, {issession: 1,selector: true});
    var kategorie = $.kategorie(xml_url_ioer, {issession: 1,selector: true});
    var masseinheit = $.masseinheit(xml_url_ioer, {issession: 1,selector: true});
    var kurzbeschreibung = $.kurzbeschreibung(xml_url_ioer, {issession: 1,selector: true});
    var bedeutung = $.bedeutung(xml_url_ioer, {issession: 1,selector: true});
    var datengrundlage = $.datengrundlage(xml_url_ioer, {issession: 1,selector: true});
    var methodik = $.methodik(xml_url_ioer, {issession: 1,selector: true});
    var bemerkungen = $.bemerkungen(xml_url_ioer, {issession: 1,selector: true});
    var quellen = $.quellen(xml_url_ioer, {issession: 1,selector: true});

    //hilfe
    var info_title = $.info_title(info_xml, {issession: 1,selector: true});
    var info_text = $.info_text(info_xml, {issession: 1,selector: true});
    var legende_title = $.legende_title(info_xml, {issession: 1,selector: true});
    var legende_text = $.legende_text(info_xml, {issession: 1,selector: true});
    var ebenen_title = $.ebenen_title(info_xml, {issession: 1,selector: true});
    var ebenen_text = $.ebenen_text(info_xml, {issession: 1,selector: true});
    var zeit_title = $.zeit_title(info_xml, {issession: 1,selector: true});
    var zeit_text = $.zeit_text(info_xml, {issession: 1,selector: true});
    var suche_title = $.suche_title(info_xml, {issession: 1,selector: true});
    var suche_text = $.suche_text(info_xml, {issession: 1,selector: true});
    var tran_title = $.tran_title(info_xml, {issession: 1,selector: true});
    var tran_text = $.tran_text(info_xml, {issession: 1,selector: true});
    var messen_title = $.messen_title(info_xml, {issession: 1,selector: true});
    var messen_text = $.messen_text(info_xml, {issession: 1,selector: true});
    var mini_title = $.mini_title(info_xml, {issession: 1,selector: true});
    var mini_text = $.mini_text(info_xml, {issession: 1,selector: true});
    var slider_title = $.slider_title(info_xml, {issession: 1,selector: true});
    var slider_text = $.slider_text(info_xml, {issession: 1,selector: true});
    var zoom_title = $.zoom_title(info_xml, {issession: 1,selector: true});
    var zoom_text = $.zoom_text(info_xml, {issession: 1,selector: true});
    var gps_title = $.gps_title(info_xml, {issession: 1,selector: true});
    var gps_text = $.gps_text(info_xml, {issession: 1,selector: true});

    // get the title of the page
    $(document).ready(function ()
    {
        document.title = page_title;
        console.log("Name of the Page: "+page_title);
    });

        // set text for interpreation
        $('.interpretation').click(function () {
            $('#menu').hide();
            $(".toggle_arrow").hide();
            $("#interpretation_d").dialog({
                height: 500,
                draggable: false,
                modal: true,
                resizable: false,
                show: 'blind',
                hide: 'blind',
                title: 'Interpretation',
                dialogClass: 'ui-dialog-osx',
                dialogClass: 'no-close success-dialog',
                dialogClass: "#interpretation_d",
                open: function() {
                    $('#menu').hide();
                    $('.arrow').hide();
                    $('.subMenu').hide();
                    $( ".toggle_arrow").show();
                    $( ".toggle_arrow" ).html('<i class="fa fa-chevron-down fa-2x"></i>');
                    $(this).closest(".ui-dialog")
                        .find(".ui-dialog-titlebar-close")
                        .html("<span class='ui-button-icon-primary ui-icon ui-icon-closethick'></span>");
                }
            });
        });

        //Interpretation with Jquery Dialog text setzten
        $('#interpretation_text').text(interpretation);
        $('.indikator_name').text(page_title);

    // set text for Kennblatt
    $('.kennblatt').click(function () {
        $('#menu').hide();
        $(".toggle_arrow").hide();
        $("#kennblatt_d").dialog({
            height: 500,
            draggable: false,
            modal: true,
            resizable: false,
            show: 'blind',
            hide: 'blind',
            title: 'Kennblatt',
            dialogClass: 'ui-dialog-osx',
            dialogClass: 'no-close success-dialog',
            dialogClass: "#kennblatt_d",
            open: function() {
                $('#menu').hide();
                $('.arrow').hide();
                $('.subMenu').hide();
                $( ".toggle_arrow").show();
                $( ".toggle_arrow" ).html('<i class="fa fa-chevron-down fa-2x"></i>');
                $(this).closest(".ui-dialog")
                    .find(".ui-dialog-titlebar-close")
                    .html("<span class='ui-button-icon-primary ui-icon ui-icon-closethick'></span>");
            }
        });

        $('#kategorie').text(kategorie);
        $('#masseinheit').text(masseinheit);
        $('#kurzbeschreibung').text(kurzbeschreibung);
        $('#bedeutung').text(bedeutung);
        $('#datengrundlage').text(datengrundlage);
        $('#methodik').text(methodik);
        $('#bemerkungen').text(bemerkungen);
        $('#quellen').text(quellen);

    });

    // set the link for the indicator overview
    $("#link").attr("href", link);
    console.log("Link Indikatorenübersicht :"+link);

    var help_div = '<div id="help_text">'+
        '<div class="info">'+
            '<image src="../img/Icon/info.png" class="info_icon_help"></image>'+
            '<h4 id="info_ue" class="info_ue"></h4>'+
            '<p id="text_info" class="text_info"></p>'+
        '</div>'+
        '<div class="info">'+
            '<image src="../img/Icon/legende.png" class="info_icon_help"></image>'+
            '<h4 id="legende_ue" class="info_ue"></h4>'+
             '<p id="legende_text" class="text_info"></p>'+
        '</div>'+
        '<div class="info">'+
            '<image src="../img/Icon/ebenen.png" class="info_icon_help"></image>'+
            '<h4 id="ebenen_ue" class="info_ue"></h4>'+
            '<p id="ebenen_text" class="text_info"></p>'+
        '</div>'+
        '<div class="info">'+
            '<image src="../img/Icon/kalender.png" class="info_icon_help"></image>'+
            '<h4 id="zeit_ue" class="info_ue"></h4>'+
            '<p id="zeit_text" class="text_info"></p>'+
        '</div>'+
        '<div class="info">'+
            '<image src="../img/Icon/lupe.png" class="info_icon_help"></image>'+
            '<h4 id="suche_ue" class="info_ue"></h4>'+
            '<p id="suche_text" class="text_info"></p>'+
        '</div>'+
        '<div class="info">'+
            '<image src="../img/Icon/helligkeit.png" class="info_icon_help"></image>'+
            '<h4 id="tran_ue" class="info_ue"></h4>'+
            '<p id="tran_text" class="text_info"></p>'+
        '</div>'+
        '<div class="info">'+
            '<image src="../img/Icon/ruler.png" class="info_icon_help"></image>'+
            '<h4 id="messen_ue" class="info_ue"></h4>'+
            '<p id="messen_text" class="text_info"></p>'+
        '</div>'+
        '<div class="info">'+
            '<image src="../img/Icon/minimap.png" class="info_icon_help"></image>'+
            '<h4 id="minni_ue" class="info_ue"></h4>'+
            '<p id="minni_text" class="text_info"></p>'+
        '</div>'+
        '<div class="info">'+
            '<image src="../img/Icon/time.png" class="info_icon_help"></image>'+
            '<h4 id="slider_ue" class="info_ue"></h4>'+
            '<p id="slider_text" class="text_info"></p>'+
        '</div>'+
        '<div class="info">'+
            '<image src="../img/Icon/zoom.png" class="info_icon_help"></image>'+
            '<h4 id="zoom_ue" class="info_ue"></h4>'+
            '<p id="zoom_text" class="text_info"></p>'+
        '</div>'+
        '<div class="info">'+
            '<i id="arrow_gps" class="fa fa-location-arrow fa-2x" aria-hidden="true"></i>'+
            '<h4 id="gps_ue" class="info_ue"></h4>'+
            '<p id="gps_text" class="text_info"></p>'+
        '</div>'+
    '</div>'

    $('#dialog').append(help_div);
    // set the texts
    $('#info_ue').text(info_title);
    $('#text_info').text(info_text);
    $('#legende_ue').text(legende_title);
    $('#legende_text').text(legende_text);
    $('#ebenen_ue').text(ebenen_title);
    $('#ebenen_text').text(ebenen_text);
    $('#zeit_ue').text(zeit_title);
    $('#zeit_text').text(zeit_text);
    $('#suche_ue').text(suche_title);
    $('#suche_text').text(suche_text);
    $('#tran_ue').text(tran_title);
    $('#tran_text').text(tran_text);
    $('#messen_ue').text(messen_title);
    $('#messen_text').text(messen_text);
    $('#minni_ue').text(mini_title);
    $('#minni_text').text(mini_text);
    $('#slider_ue').text(slider_title);
    $('#slider_text').text(slider_text);
    $('#zoom_ue').text(zoom_title);
    $('#zoom_text').text(zoom_text);
    $('#gps_ue').text(gps_title);
    $('#gps_text').text(gps_text);

    //help
    $('#help').click(function () {
        $('#menu').hide();
        $(".toggle_arrow").hide();
        $("#help_text").dialog({
            height: 500,
            draggable: false,
            modal: true,
            resizable: false,
            show: 'blind',
            hide: 'blind',
            title: 'Hilfe',
            dialogClass: 'ui-dialog-osx',
            dialogClass: 'no-close success-dialog',
            dialogClass: "#help_text",
            open: function () {
                $('#menu').hide();
                $('.arrow').hide();
                $('.subMenu').hide();
                $( ".toggle_arrow").show();
                $( ".toggle_arrow" ).html('<i class="fa fa-chevron-down fa-2x"></i>');
                $(this).closest(".ui-dialog")
                    .find(".ui-dialog-titlebar-close")
                    .html("<span class='ui-button-icon-primary ui-icon ui-icon-closethick'></span>");
            }
        });
    });
}
function info_slide(){

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
        interpretation: function(url, data) {
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
                        title = $(this).find('interpretation').text();
                    });
                }
            });
            // Return the response text
            return title;
        },
        kategorie: function(url, data) {
            // local var
            var kategorie = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find(indikatorname).each(function() {
                        kategorie = $(this).find('kategorie').text();
                    });
                }
            });
            // Return the response text
            return kategorie;
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
        kurzbeschreibung: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find(indikatorname).each(function() {
                        text = $(this).find('kurzbeschreibung').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        bedeutung: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find(indikatorname).each(function() {
                        text = $(this).find('bedeutung').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        datengrundlage: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find(indikatorname).each(function() {
                        text = $(this).find('datengrundlage').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        methodik: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find(indikatorname).each(function() {
                        text = $(this).find('methodik').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        bemerkungen: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find(indikatorname).each(function() {
                        text = $(this).find('bemerkungen').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        quellen: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find(indikatorname).each(function() {
                        text = $(this).find('quellen').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        //hilfe
        info_title: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("info").each(function() {
                        text = $(this).find('title').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        info_text: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("info").each(function() {
                        text = $(this).find('text').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        legende_title: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("legende").each(function() {
                        text = $(this).find('title').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        legende_text: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("legende").each(function() {
                        text = $(this).find('text').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        ebenen_title: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("ebenen").each(function() {
                        text = $(this).find('title').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        ebenen_text: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("ebenen").each(function() {
                        text = $(this).find('text').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        zeit_title: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("kalender").each(function() {
                        text = $(this).find('title').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        zeit_text: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("kalender").each(function() {
                        text = $(this).find('text').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        suche_title: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("suche").each(function() {
                        text = $(this).find('title').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        suche_text: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("suche").each(function() {
                        text = $(this).find('text').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        tran_title: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("transparenz").each(function() {
                        text = $(this).find('title').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        tran_text: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("transparenz").each(function() {
                        text = $(this).find('text').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        messen_title: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("messen").each(function() {
                        text = $(this).find('title').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        messen_text: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("messen").each(function() {
                        text = $(this).find('text').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        mini_title: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("minimap").each(function() {
                        text = $(this).find('title').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        mini_text: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("minimap").each(function() {
                        text = $(this).find('text').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        slider_title: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("timeslider").each(function() {
                        text = $(this).find('title').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        slider_text: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("timeslider").each(function() {
                        text = $(this).find('text').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        zoom_title: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("zoom").each(function() {
                        text = $(this).find('title').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        zoom_text: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("zoom").each(function() {
                        text = $(this).find('text').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        gps_title: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("gps").each(function() {
                        text = $(this).find('title').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
        gps_text: function(url, data) {
            // local var
            var text = "";
            // jQuery ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: "xml",
                async: false,
                success: function (data){
                    $(data).find("gps").each(function() {
                        text = $(this).find('text').text();
                    });
                }
            });
            // Return the response text
            return text;
        },
    });

    var interpretation = $.interpretation(xml_url_ioer, {issession: 1,selector: true});
    var page_title = $.title_page(xml_url_ioer, {issession: 1,selector: true});
    var kategorie = $.kategorie(xml_url_ioer, {issession: 1,selector: true});
    var masseinheit = $.masseinheit(xml_url_ioer, {issession: 1,selector: true});
    var kurzbeschreibung = $.kurzbeschreibung(xml_url_ioer, {issession: 1,selector: true});
    var bedeutung = $.bedeutung(xml_url_ioer, {issession: 1,selector: true});
    var datengrundlage = $.datengrundlage(xml_url_ioer, {issession: 1,selector: true});
    var methodik = $.methodik(xml_url_ioer, {issession: 1,selector: true});
    var bemerkungen = $.bemerkungen(xml_url_ioer, {issession: 1,selector: true});
    var quellen = $.quellen(xml_url_ioer, {issession: 1,selector: true});

    //hilfe
    var info_title = $.info_title(info_xml, {issession: 1,selector: true});
    var info_text = $.info_text(info_xml, {issession: 1,selector: true});
    var legende_title = $.legende_title(info_xml, {issession: 1,selector: true});
    var legende_text = $.legende_text(info_xml, {issession: 1,selector: true});
    var ebenen_title = $.ebenen_title(info_xml, {issession: 1,selector: true});
    var ebenen_text = $.ebenen_text(info_xml, {issession: 1,selector: true});
    var zeit_title = $.zeit_title(info_xml, {issession: 1,selector: true});
    var zeit_text = $.zeit_text(info_xml, {issession: 1,selector: true});
    var suche_title = $.suche_title(info_xml, {issession: 1,selector: true});
    var suche_text = $.suche_text(info_xml, {issession: 1,selector: true});
    var tran_title = $.tran_title(info_xml, {issession: 1,selector: true});
    var tran_text = $.tran_text(info_xml, {issession: 1,selector: true});
    var messen_title = $.messen_title(info_xml, {issession: 1,selector: true});
    var messen_text = $.messen_text(info_xml, {issession: 1,selector: true});
    var mini_title = $.mini_title(info_xml, {issession: 1,selector: true});
    var mini_text = $.mini_text(info_xml, {issession: 1,selector: true});
    var slider_title = $.slider_title(info_xml, {issession: 1,selector: true});
    var slider_text = $.slider_text(info_xml, {issession: 1,selector: true});
    var zoom_title = $.zoom_title(info_xml, {issession: 1,selector: true});
    var zoom_text = $.zoom_text(info_xml, {issession: 1,selector: true});
    var gps_title = $.gps_title(info_xml, {issession: 1,selector: true});
    var gps_text = $.gps_text(info_xml, {issession: 1,selector: true});

    // get the title of the page
    $(document).ready(function ()
    {
        document.title = page_title;
        console.log("Name of the Page: "+page_title);
    });

    // set text for interpreation
    $('.interpretation').click(function () {
        $('#menu').hide();
        $(".toggle_arrow").hide();
        $("#interpretation_d").dialog({
            height: 500,
            draggable: false,
            modal: true,
            resizable: false,
            show: 'blind',
            hide: 'blind',
            title: 'Interpretation',
            dialogClass: 'ui-dialog-osx',
            dialogClass: 'no-close success-dialog',
            dialogClass: "#interpretation_d",
            open: function() {
                $('#menu').hide();
                $('.arrow').hide();
                $('.subMenu').hide();
                $( ".toggle_arrow").show();
                $( ".toggle_arrow" ).html('<i class="fa fa-chevron-down fa-2x"></i>');
                $(this).closest(".ui-dialog")
                    .find(".ui-dialog-titlebar-close")
                    .html("<span class='ui-button-icon-primary ui-icon ui-icon-closethick'></span>");
            }
        });
    });

    //Interpretation with Jquery Dialog text setzten
    $('#interpretation_text').text(interpretation);
    $('.indikator_name').text(page_title);

    // set text for Kennblatt
    $('.kennblatt').click(function () {
        $('#menu').hide();
        $(".toggle_arrow").hide();
        $("#kennblatt_d").dialog({
            height: 500,
            draggable: false,
            modal: true,
            resizable: false,
            show: 'blind',
            hide: 'blind',
            title: 'Kennblatt',
            dialogClass: 'ui-dialog-osx',
            dialogClass: 'no-close success-dialog',
            dialogClass: "#kennblatt_d",
            open: function() {
                $('#menu').hide();
                $('.arrow').hide();
                $('.subMenu').hide();
                $( ".toggle_arrow").show();
                $( ".toggle_arrow" ).html('<i class="fa fa-chevron-down fa-2x"></i>');
                $(this).closest(".ui-dialog")
                    .find(".ui-dialog-titlebar-close")
                    .html("<span class='ui-button-icon-primary ui-icon ui-icon-closethick'></span>");
            }
        });

        $('#kategorie').text(kategorie);
        $('#masseinheit').text(masseinheit);
        $('#kurzbeschreibung').text(kurzbeschreibung);
        $('#bedeutung').text(bedeutung);
        $('#datengrundlage').text(datengrundlage);
        $('#methodik').text(methodik);
        $('#bemerkungen').text(bemerkungen);
        $('#quellen').text(quellen);

    });

    // set the link for the indicator overview
    $("#link").attr("href", link);
    console.log("Link Indikatorenübersicht :"+link);

    var help_div = '<div id="help_text">'+
        '<div class="info">'+
        '<image src="../../img/Icon/info.png" class="info_icon_help"></image>'+
        '<h4 id="info_ue" class="info_ue"></h4>'+
        '<p id="text_info" class="text_info"></p>'+
        '</div>'+
        '<div class="info">'+
        '<image src="../../img/Icon/legende.png" class="info_icon_help"></image>'+
        '<h4 id="legende_ue" class="info_ue"></h4>'+
        '<p id="legende_text" class="text_info"></p>'+
        '</div>'+
        '<div class="info">'+
        '<image src="../../img/Icon/ebenen.png" class="info_icon_help"></image>'+
        '<h4 id="ebenen_ue" class="info_ue"></h4>'+
        '<p id="ebenen_text" class="text_info"></p>'+
        '</div>'+
        '<div class="info">'+
        '<image src="../../img/Icon/kalender.png" class="info_icon_help"></image>'+
        '<h4 id="zeit_ue" class="info_ue"></h4>'+
        '<p id="zeit_text" class="text_info"></p>'+
        '</div>'+
        '<div class="info">'+
        '<image src="../../img/Icon/lupe.png" class="info_icon_help"></image>'+
        '<h4 id="suche_ue" class="info_ue"></h4>'+
        '<p id="suche_text" class="text_info"></p>'+
        '</div>'+
        '<div class="info">'+
        '<image src="../../img/Icon/helligkeit.png" class="info_icon_help"></image>'+
        '<h4 id="tran_ue" class="info_ue"></h4>'+
        '<p id="tran_text" class="text_info"></p>'+
        '</div>'+
        '<div class="info">'+
        '<image src="../../img/Icon/ruler.png" class="info_icon_help"></image>'+
        '<h4 id="messen_ue" class="info_ue"></h4>'+
        '<p id="messen_text" class="text_info"></p>'+
        '</div>'+
        '<div class="info">'+
        '<image src="../../img/Icon/minimap.png" class="info_icon_help"></image>'+
        '<h4 id="minni_ue" class="info_ue"></h4>'+
        '<p id="minni_text" class="text_info"></p>'+
        '</div>'+
        '<div class="info">'+
        '<image src="../../img/Icon/time.png" class="info_icon_help"></image>'+
        '<h4 id="slider_ue" class="info_ue"></h4>'+
        '<p id="slider_text" class="text_info"></p>'+
        '</div>'+
        '<div class="info">'+
        '<image src="../../img/Icon/zoom.png" class="info_icon_help"></image>'+
        '<h4 id="zoom_ue" class="info_ue"></h4>'+
        '<p id="zoom_text" class="text_info"></p>'+
        '</div>'+
        '<div class="info">'+
        '<i id="arrow_gps" class="fa fa-location-arrow fa-2x" aria-hidden="true"></i>'+
        '<h4 id="gps_ue" class="info_ue"></h4>'+
        '<p id="gps_text" class="text_info"></p>'+
        '</div>'+
        '</div>'

    $('#dialog').append(help_div);
    // set the texts
    $('#info_ue').text(info_title);
    $('#text_info').text(info_text);
    $('#legende_ue').text(legende_title);
    $('#legende_text').text(legende_text);
    $('#ebenen_ue').text(ebenen_title);
    $('#ebenen_text').text(ebenen_text);
    $('#zeit_ue').text(zeit_title);
    $('#zeit_text').text(zeit_text);
    $('#suche_ue').text(suche_title);
    $('#suche_text').text(suche_text);
    $('#tran_ue').text(tran_title);
    $('#tran_text').text(tran_text);
    $('#messen_ue').text(messen_title);
    $('#messen_text').text(messen_text);
    $('#minni_ue').text(mini_title);
    $('#minni_text').text(mini_text);
    $('#slider_ue').text(slider_title);
    $('#slider_text').text(slider_text);
    $('#zoom_ue').text(zoom_title);
    $('#zoom_text').text(zoom_text);
    $('#gps_ue').text(gps_title);
    $('#gps_text').text(gps_text);

    //help
    $('#help').click(function () {
        $('#menu').hide();
        $(".toggle_arrow").hide();
        $("#help_text").dialog({
            height: 500,
            draggable: false,
            modal: true,
            resizable: false,
            show: 'blind',
            hide: 'blind',
            title: 'Hilfe',
            dialogClass: 'ui-dialog-osx',
            dialogClass: 'no-close success-dialog',
            dialogClass: "#help_text",
            open: function () {
                $('#menu').hide();
                $('.arrow').hide();
                $('.subMenu').hide();
                $( ".toggle_arrow").show();
                $( ".toggle_arrow" ).html('<i class="fa fa-chevron-down fa-2x"></i>');
                $(this).closest(".ui-dialog")
                    .find(".ui-dialog-titlebar-close")
                    .html("<span class='ui-button-icon-primary ui-icon ui-icon-closethick'></span>");
            }
        });
    });
}