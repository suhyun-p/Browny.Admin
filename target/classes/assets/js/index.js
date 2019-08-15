$(document).ready(function () {

    $.ajax({
        contentType: 'application/json',
        dataType: 'json',
        // data: JSON.stringify(data),
        url: '/getClassSimpleList',
        type: 'GET',
        success: function (response) {

            console.log(response);

            $("#jsGrid").jsGrid({
                width: "100%",
                height: "100%",
                filtering: false,
                inserting: false,
                editing: false,
                sorting: true,
                autoload: true,
                paging: true,
                pageSize: 5,
                pageButtonCount: 5,
                rowDoubleClick: function(args) {
                    var getData = args.item;
                    alert(getData["classNo"]);
                },
                data: response,
                fields: [
                    { name: "classNo", title: "Class No", type: "text", width: 10, align:"center" },
                    { name: "genre", title: "Genre", type: "text", width: 15, align:"center" },
                    { name: "region", title: "Region", type: "text", width: 15, align:"center" },
                    { name: "classType", title: "Class Type", type: "text", width: 20, align:"center" },
                    { name: "only", title: "Only", type: "text", width: 10, align:"center" },
                    { name: "title", title: "Title", type: "text", width: 100 }
                ]
            });
        },
        error: function (request, status, error) {
            alert("데이터 조회에 실패했습니다.");
        }
    })
});