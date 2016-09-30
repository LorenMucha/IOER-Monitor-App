$(document).ready(function() {

    $('#menuPoint0').click(function() {
        $('.subMenuPoint0').toggle();
        $('.subMenuPoint1').hide();
        $('.subMenuPoint2').hide();
        $('.subMenuPoint3').hide();
        $('.subMenuPoint4').hide();
        $('.subMenuPoint5').hide();
        $('.subMenuPoint6').hide();
        console.log("click");
    });
    
    $('#menuPoint1').click(function() {
        $('.subMenuPoint1').toggle();
        $('.subMenuPoint2').hide();
        $('.subMenuPoint3').hide();
        $('.subMenuPoint4').hide();
        $('.subMenuPoint5').hide();
        $('.subMenuPoint6').hide();
    });

    $('#menuPoint2').click(function() {
        $('.subMenuPoint2').toggle();
        $('.subMenuPoint1').hide();
        $('.subMenuPoint3').hide();
        $('.subMenuPoint4').hide();
        $('.subMenuPoint5').hide();
        $('.subMenuPoint6').hide();
    });

    $('#menuPoint3').click(function() {
        $('.subMenuPoint3').toggle();
        $('.subMenuPoint1').hide();
        $('.subMenuPoint2').hide();
        $('.subMenuPoint4').hide();
        $('.subMenuPoint5').hide();
        $('.subMenuPoint6').hide();
    });

    $('#menuPoint4').click(function() {
        $('.subMenuPoint4').toggle();
        $('.subMenuPoint1').hide();
        $('.subMenuPoint3').hide();
        $('.subMenuPoint2').hide();
        $('.subMenuPoint5').hide();
        $('.subMenuPoint6').hide();
    });

    $('#menuPoint5').click(function() {
        $('.subMenuPoint5').toggle();
        $('.subMenuPoint1').hide();
        $('.subMenuPoint3').hide();
        $('.subMenuPoint4').hide();
        $('.subMenuPoint2').hide();
        $('.subMenuPoint6').hide();
    });

    $('#menuPoint6').click(function() {
        $('.subMenuPoint6').toggle();
        $('.subMenuPoint5').hide();
        $('.subMenuPoint1').hide();
        $('.subMenuPoint3').hide();
        $('.subMenuPoint4').hide();
        $('.subMenuPoint2').hide();
    });

    $('#menuPoint7').click(function() {
        $('.subMenuPoint7').toggle();
    });

    $('#menuPoint8').click(function() {
        $('.subMenuPoint8').toggle();
    });

    $('#menuPoint9').click(function() {
        $('.subMenuPoint9').toggle();
    });

    $("#map").click(function () {
        $(".subMenuPoint1").css("display", "none");
        $(".subMenuPoint2").css("display", "none");
        $(".subMenuPoint3").css("display", "none");
        $(".subMenuPoint4").css("display", "none");
        $(".subMenuPoint5").css("display", "none");
        $(".subMenuPoint6").css("display", "none");
        $(".subMenuPoint7").css("display", "none");
        $(".subMenuPoint8").css("display", "none");
        $(".subMenuPoint9").css("display", "none");
    });
});

