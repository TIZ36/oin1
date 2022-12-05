$(document).ready(function () {
    $("#login").click(function () {
        valid1 = 1;
        valid2 = 1;
        usr = document.getElementById("name").value;
        pwd = document.getElementById("pwd1").value;

        if (usr === '') {
            alert("Please input the username");
            valid1 = 0;
        }

        if (pwd === '') {
            alert("Password is required! ");
            valid2 = 0;
        }

        if (valid1 && valid2) {
            $.ajax({
                type: "POST",
                url: "Login",
                data: {
                    'username': usr,
                    'password': pwd
                },
                success: function (data) {
                    if (data === "success") {
                        window.location.href = "shopping.jsp";
                    } else {
                        alert(data);
                    }
                }
            });
        }
    });//end of sub-button

    $("#hint").click(function () {
        vd = 1;
        usr = document.getElementById("name").value;

        if (usr === '') {
            vd = 0;
            alert("If you want to see the hint, username is required ");
        }
        if (vd) {
            $.ajax({
                type: "POST",
                url: "Hint",
                data: {
                    'username': usr
                },
                success: function (data) {
                    alert("hint: " + data);
                }
            });
        }
    });//end of hint

    $("#register").click(function () {
        window.location.href = "login.html";
    });


});