
(function ($) {
    "use strict";
    console.log("lodedd.....");
    $("#loginBtn").click(function(e){
        e.preventDefault();
        sendToServlet();
    })



    function sendToServlet(value){

        const email = $("input[name='username']").val();
        const password = $("input[name='pass']").val();

        $.ajax({
            'url':"LoginServlet",
            'type':'POST',
            'data': {'email':email, 'passWord':password},
            'success': ajaxSucessful
        });

    }

    function ajaxSucessful(data){

        if(data.login == "true"){
            window.location.href = "/TaskManagementApp_war_exploded" + data.url;
        }else{
            $('.wrap-login100').append($('<p/>').text("Incorrect Credential.")
                .css({"color":"red"}));
        }

    }


})(jQuery);