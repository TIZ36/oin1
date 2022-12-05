window.onload = function () {
    $.ajax({
        url: "ViewHistory",
        type: "POST",
        success: function (data) {
            //alert(data)
            var da = eval('(' + data + ')');
            //  alert(da[1]["USERNAME"]);

            var table = document.getElementById("tb");

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
                    var newTd3 = newTr.insertCell();
                    var newTd4 = newTr.insertCell();


                    newTd0.innerHTML = rowData["TIME"];
                    newTd1.innerHTML = rowData["USERNAME"];
                    newTd2.innerHTML = rowData["PRODUCTNAME"];
                    newTd3.innerHTML = rowData["AMOUNT"];
                    newTd4.innerHTML = rowData["ADDRESS"];

                }
            }
        }
    })
}

$(function () {
    $("#backs").click(function () {
        window.location.href = "shopping.jsp"
    })
})