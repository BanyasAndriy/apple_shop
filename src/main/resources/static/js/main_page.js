$(function() {

var slides = $('#slides .slide');
var currentSlide = 0;
var slideInterval = setInterval(nextSlide,3000);

function nextSlide(){
    slides[currentSlide].className = 'slide';
    currentSlide = (currentSlide+1)%slides.length;
    slides[currentSlide].className = 'slide showing';
}
});



$(function() {
 		$('.badhon-tab li img').click(function(){
		  var src = $(this).attr('src');
		  $('.tab-pane img').attr("src", src);
        });
});


$(document).ready(function () {
    $('#list > li').click(function (event) {
        $(this).children("ul").slideToggle();
        event.stopPropagation();
    });
});







$(function() {

        $('#qwe').click(function(){

        $('#one').css("display", "none");
        $('#two').css("display", "block");

        $('head').append('<link rel="stylesheet" href="css/main1.css" type="text/css" />');
            $("#list > li").children("ul").slideUp();

      
});
        
});


    $(function() {
        $('#goods').click(function(event){
            $("#list > li").children("ul").slideDown();
            event.stopPropagation();
        });
    });











$(document).ready(function () {
    $('#qwe').click(function (event) {
       var name = $(this).attr("id");
       var value = $(this).val();
  
        getWatch(name, value);


        
    });
});













    function getWatch(name, value ) {
     console.log(name);
     console.log(value);


    $.ajax({
        type: "POST",
        contentType : 'application/json; charset=utf-8',
        dataType : "json",
       // url: '/type=' +value + '/model=' +name + '',

        url: '/type=watch/model=6s',


        //      data: JSON.stringify(search), // Note it is important
        success :function(response){

            let select=""
            let gfdj= [35,2,3,46,5]
            $('#price').html(response.price+'$');
            $('#shortDescription').html('Short Description : '+response.shortDescription);
            $('#fullDescription').html('Full Description :'+response.fullDescription);
            $('#model').html('Model: ' + response.model);
            $('#name-model').html(response.name+ ' '+ response.model);

            for( let i of gfdj ){
                select+= '<button type="button" id="val" class="btn btn-success "  >'+ i+'</button>'






            }



            $('.memory').html(select);
            var lst = [];
            lst = document.querySelectorAll("#val");
            for (let i in gfdj) {
                lst[i].id = gfdj[i] ;
            }
        },
        error:function(response) {
            alert("smt wrong "+ response);

        }
    });
}



