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

        url: '/type=watch/model=6',


        //      data: JSON.stringify(search), // Note it is important
        success :function(response){



            let models = response.allModels;//список моделей
let memories = response.allMemories;
           console.log(memories);


            for (var key in response.memoryAndPrice) {
                if (response.memoryAndPrice.hasOwnProperty(key)) {

                    $('#price').html(response.memoryAndPrice[key]+'$');//виводить ціну з мепа

                    $('#name-model').html(response.name+ ' '+ response.model+' ' + key+"GB");//виводить память з мепа
                }}

            let select="";

            $('#shortDescription').html('***');

            $('#fullDescription').html('Full Description :'+response.fullDescription);
            $('#model').html('Model: ' + response.model);


            for( let i of models ){
                select+= '<button type="button" id="val" class="btn btn-success "  >'+ i+'</button>';

            }


            $('.memory').html(select);
            var lst = [];
            lst = document.querySelectorAll("#val");
            for (let i in models) {
                lst[i].id = models[i] ;
            }


            for( let i of memories ){
                select+= '<button type="button" id="mem" class="btn btn-success "  >'+ i+'</button>';

            }



            $('.memory').html(select);
            var lst = [];
            lst = document.querySelectorAll("#mem");
            for (let i in memories) {
                lst[i].id = memories[i] ;
            }




        },
        error:function(response) {
            alert("smt wrong "+ response);

        }
    });
}





