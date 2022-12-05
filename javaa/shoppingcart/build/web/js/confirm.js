window.onload = function () {
    $.ajax({
        type: "post",
        url: "Confirm_Page",
        success: function (data) {
            var da = eval('(' + data.toString() + ')');
            document.getElementById("name").innerHTML = da.fname + da.lname;
            document.getElementById("username").innerHTML = da.username;
            document.getElementById("fname").innerHTML = da.fname;
            document.getElementById("lname").innerHTML = da.lname;
            document.getElementById("gender").innerHTML = da.gender;
            document.getElementById("email").innerHTML = da.email;
            document.getElementById("address").innerHTML = da.address;
        }


    });
}

$(function () {
    $("#gs").click(function () {
        window.location.href = "shopping.jsp";
    })
})