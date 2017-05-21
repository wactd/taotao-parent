$(function () {
    $("input[type='button']").click(function () {
        var params = $("form").serializeArray();
        var values = {};
        for (var item in params) {
            console.log(item);
            values[params[item].name] = params[item].value;
        }
        console.log(values);
        $.ajax({
            url: '/json1',
            type: 'POST',
//                data: "{'username1':'小明','password1':'123456', 'a':123}",
            data: JSON.stringify(values),
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            success: function (data) {
                alert(data.username);
            }
        });
    });
})