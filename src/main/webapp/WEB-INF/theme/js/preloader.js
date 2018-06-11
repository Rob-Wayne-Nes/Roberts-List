function preload(arrayOfImages){
    $(arrayOfImages).each(function (){
       $('<img/>').attr('src',this)._appendTo('body').css('display', 'none');
    });
}

preload([
   'WEB-INF/theme/images/dreaming.jpeg',
    'WEB-INF/theme/images/fun.jpeg',
    'WEB-INF/theme/images/special .jpeg'
]);


$(window).on('load', function() { // makes sure the whole site is loaded
    $('#status').fadeOut(); // will first fade out the loading animation
    $('#preload').delay(600).fadeOut('slow'); // will fade out the white DIV that covers the website.
    $('body').delay(600).css({'overflow':'visible'});

    var  i = 0;
    setInterval(function() {

        var images= ['dreaming.jpeg','fun.jpeg','special.jpg'];
        (i === images.length-1) ? i = 0 : i++;

        console.log(i);
        var image = $('#image-holder');
        image.fadeOut(2000, function () {
            image.css("background", "url('images/" + images[i] + "')");
            image.css("background-size", "cover");
            image.fadeIn(2000);

        });

    }, 6000);



});