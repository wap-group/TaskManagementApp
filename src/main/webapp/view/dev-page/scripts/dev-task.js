$(document).ready(function () {
    $("#viewBtn").click(function () {
        $.get("DevTaskServlet").done(function (data) {
            console.log(data);
            $.each(data, function (index, value) {
                $("#userTable").append("<tr data-id="+value.id+">" +
                    "<td>"+value.empId+"</td>" +
                    "<td>"+value.fName+"</td>" +
                    "<td>"+value.lName+"</td></tr>" +
                    "<td>"+value.email+"</td></tr>" +
                    "<td>"+value.role+"</td></tr>" +
                    "<td>"+value.phone+"</td></tr>");
            });
            $("#userTable").show();
        }).fail(function (err) {
            console.error(err);
        });
    });

    $("#userTable").on('click', 'tr', function(){
        var self = $(this);
        var userId=self.attr("data-id");
        console.log(userId);
        $.get("http://jsonplaceholder.typicode.com/posts?userId="+userId)
            .done(function(data){

                var tableStr = '<tr><td colspan="3"><table><tr><th>ID</th><th>Title</th><th>Body</th></tr>';

                $.each(data, function (index, value) {
                    tableStr += '<tr data-id="+value.id+"><td>"+value.id+"</td><td>"+value.title+"</td><td>"+value.body+"</td></tr>';
                });
                tableStr +='</table></td></tr>';
                self.append(tableStr);
            }).fail(function () {

        });
    });


});