window.onload = function () {

    $.ajax({
        url: "Laptop",
        type: "post",
        data: {
            'type': "all"
        },
        success: function (data) {
            // alert(data);
            var da = eval('(' + data + ')');

            // alert(da[2]["PRODUCTNAME"]);
            var table = document.getElementById("sb");

            if (table.rows.length > 0)
            {
                for (var i = table.rows.length - 1; i > 0; i--)
                {
                    table.deleteRow(i);
                }
            }


            if (da.length > 0) {
                for (var i = 0; i < da.length; i++) {
                    var rowData = da[i];
                    var newTr = table.insertRow();
                    var newTd0 = newTr.insertCell();
                    var newTd1 = newTr.insertCell();
                    var newTd2 = newTr.insertCell();
                    // var newTd3 = newTr.insertCell();


                    newTd0.innerHTML = rowData["PRODUCTNAME"];
                    newTd1.innerHTML = rowData["PRICE"];
                    var get = rowData["PRODUCTNAME"];
                    newTd2.innerHTML = "<input  name='" + get + "''  onmouseover='ph(this)' onmouseout='phn(this)'/><button onclick='selectItem(this)' name='" + get + "''> get </button>";
                    //newTd3.innerHTML = "<button onclick='selectItem(this)' name='" + get + "''> get </button>";
                }
            }

        }
    });

}

function ph(obj) {
    obj.setAttribute("placeholder", "how many you want")
}
function phn(obj) {
    obj.setAttribute("placeholder", "")
}

function selectItem(obj) {

    $(function () {

        var myDate = new Date();
        var valid4 = 1;
        myDate.getTime();
        myDate.toLocaleDateString();
        var purchaseTime = myDate.toLocaleTimeString();

        pnode = obj.parentNode;
        amount = pnode.firstChild.value;   //amount they want
        pnode.firstChild.value = '';

        if (amount === '') {
            alert("please input amount you want");
            valid4 = 0;
        } else if (isNaN(amount)) {
            valid4 = 0;
            alert("please input a integer");
        }
        var Pname = obj.getAttribute("name");//product name

        if (valid4)
        {
            $.ajax({
                url: "Buy",
                type: "post",
                data: {
                    'Pname': Pname,
                    'amount': amount,
                    'date': purchaseTime
                },

                success: function (data) {
                    alert(data);

                }
            });
        }



    });
}

$(function () {
    $('#searchb').click(function () {
        var searchEle = document.getElementById('search').value;
        var valid5 = 1;
        if (searchEle === '') {
            alert("input what you want to search");
            valid5 = 0;
        }

        if (valid5) {
            $.ajax({
                url: "Search",
                type: "post",
                data: {
                    'key': searchEle
                },
                success: function (data) {
                    // alert(data);
                    var da = eval('(' + data + ')');

                    // alert(da[2]["PRODUCTNAME"]);
                    var table = document.getElementById("sb");

                    if (table.rows.length > 0)
                    {
                        for (var i = table.rows.length - 1; i > 0; i--)
                        {
                            table.deleteRow(i);
                        }
                    }


                    if (da.length > 0) {
                        for (var i = 0; i < da.length; i++) {
                            var rowData = da[i];
                            var newTr = table.insertRow();
                            var newTd0 = newTr.insertCell();
                            var newTd1 = newTr.insertCell();
                            var newTd2 = newTr.insertCell();
                            // var newTd3 = newTr.insertCell();


                            newTd0.innerHTML = rowData["PRODUCTNAME"];
                            newTd1.innerHTML = rowData["PRICE"];
                            var get = rowData["PRODUCTNAME"];
                            newTd2.innerHTML = "<input  name='" + get + "''  onmouseover='ph(this)' onmouseout='phn(this)'/><button onclick='selectItem(this)' name='" + get + "''> get </button>";
                            //newTd3.innerHTML = "<button onclick='selectItem(this)' name='" + get + "''> get </button>";
                        }
                    }

                }
            });
        }
    });
});

$(function () {
    $("#logout").click(function () {
        $.ajax({
            url: "Logout",
            type: "POST",
            success: function (data) {
                da = eval('(' + data.toString() + ')');
                alert("You are going to log out the current account: \n\n" +
                        "username: " + da.username);
                window.location.href = "register.jsp";
            }
        });
    });


});

$(function () {
    $("#history").click(function () {
        window.location.href = "history.jsp";

    })
})

$(function () {
    $('#type-change').click(function () {
        var selectNode = document.getElementById("type-change");
        var type = selectNode.options[selectNode.selectedIndex].value;
        $.ajax({
            url: "Laptop",
            type: "post",
            data: {
                'type': type
            },
            success: function (data) {
                // alert(data);
                var da = eval('(' + data + ')');

                // alert(da[2]["PRODUCTNAME"]);
                var table = document.getElementById("sb");

                if (table.rows.length > 0)
                {
                    for (var i = table.rows.length - 1; i > 0; i--)
                    {
                        table.deleteRow(i);
                    }
                }


                if (da.length > 0) {
                    for (var i = 0; i < da.length; i++) {
                        var rowData = da[i];
                        var newTr = table.insertRow();
                        var newTd0 = newTr.insertCell();
                        var newTd1 = newTr.insertCell();
                        var newTd2 = newTr.insertCell();
                        // var newTd3 = newTr.insertCell();


                        newTd0.innerHTML = rowData["PRODUCTNAME"];
                        newTd1.innerHTML = rowData["PRICE"];
                        var get = rowData["PRODUCTNAME"];
                        newTd2.innerHTML = "<input  name='" + get + "''  onmouseover='ph(this)' onmouseout='phn(this)'/><button onclick='selectItem(this)' name='" + get + "''> get </button>";
                        //newTd3.innerHTML = "<button onclick='selectItem(this)' name='" + get + "''> get </button>";
                    }
                }

            }
        });
    });
});

