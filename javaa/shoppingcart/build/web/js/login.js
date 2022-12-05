function check(obj) {
    $(":radio").removeAttr("checked");
    obj.setAttribute("checked", "checked");
}

$(document).ready(function () {
    $("#sb").click(function () {

        var valid1 = 0;
        var valid2 = 0;
        var valid3 = 1;
        var Gender = null;
        $("input[type='radio']").each(function () {
            if ($(this).attr("checked") === "checked") {
                Gender = $(this).attr("value");
            }
        });


        password = document.getElementById("pwd1").value;
        repassword = document.getElementById("pwd2").value;
        email = document.getElementById("email").value;

        //validate for password
        if (password === '') {
            alert("password could not be null");
            valid3 = 0;
            document.getElementById("pwd1").style.borderColor = "red";
        } else if (password === repassword) {

            valid1 = 1;
        } else {
            alert("password did not matched");
            window.location.reload();
        }

        //validate for email
        reg = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
        if (reg.test(email)) {
            valid2 = 1;
        } else {
            alert("worry email format");
            window.location.reload();
        }

        if (valid1 && valid2) {
            //account
            name = document.getElementById("name").value;
            pwd = document.getElementById("pwd1").value;
            reminder = document.getElementById("reminder").value;
            if (reminder === '') {
                reminder = "no provided";
            }

            //user information
            fname = document.getElementById("fname").value;
            lname = document.getElementById("lname").value;

            address = document.getElementById("address").value;
            if (address === '') {
                address = "no provided";
            }


            if (name === '') {
                alert("username is required");
                document.getElementById("name").style.borderColor = "red";
                valid3 = 0;
            } else {
                document.getElementById("name").style.borderColor = null;
            }

            if (fname === '') {
                alert("firstname is required");
                document.getElementById("fname").style.borderColor = "red";
                valid3 = 0;
            } else {
                document.getElementById("fname").style.borderColor = null;
            }

            if (lname === '') {
                alert("lastname is required");
                document.getElementById("lname").style.borderColor = "red";
                valid3 = 0;
            } else {
                document.getElementById("lname").style.borderColor = null;
            }

            if (valid3) {
                $.ajax({
                    type: "post",
                    url: "Servlet_for_DB",
                    data: {
                        'username': name,
                        'password': pwd,
                        'reminder': reminder,
                        'fname': fname,
                        'lname': lname,
                        'gender': Gender,
                        'email': email,
                        'address': address
                    },
                    success: function (result) {
                        if (result === "success") {
                            window.location.href = "confirm.jsp";
                        } else {
                            alert(result);
                        }


                    }
                });
            }
        }

    });

    $("#back").click(function () {
        window.location.href = "register.jsp";
    });
});


        