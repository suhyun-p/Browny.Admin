$(document).ready(function () {

    $.ajax({
        contentType: 'application/json',
        dataType: 'json',
        // data: JSON.stringify(data),
        url: '/getInstructorList',
        type: 'GET',
        success: function (response) {
            response.forEach(function (user, index, list) {
                $("#instructor1").append('<option value="' + user.userNo + '">'+ user.nickname + '</option>');
                $("#instructor2").append('<option value="' + user.userNo + '">'+ user.nickname + '</option>');
            });
        },
        error: function (request, status, error) {
            alert("데이터 조회에 실패했습니다.");
        }
    });

    $.ajax({
        contentType: 'application/json',
        dataType: 'json',
        // data: JSON.stringify(data),
        url: '/getClubList',
        type: 'GET',
        success: function (response) {
            response.forEach(function (club, index, list) {
                $("#club").append('<option value="' + club.clubNo + '">'+ club.clubName + '</option>');
            });
        },
        error: function (request, status, error) {
            alert("데이터 조회에 실패했습니다.");
        }
    });

    var data = {};
    data["inProgress"] = true;

    $.ajax({
        contentType: 'application/json',
        dataType: 'json',
        data: JSON.stringify(data),
        url: '/getClassSimpleList',
        type: 'POST',
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
                    loadClassDetail(getData["classNo"]);
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
    });

    $("#instructor1").change(function() {
       // alert(this.value);

        if(this.value == "")  return;

        $.ajax({
            contentType: 'application/json',
            dataType: 'json',
            // data: JSON.stringify(data),
            url: '/getInstructor?userNo=' + this.value,
            type: 'GET',
            success: function (response) {
                console.log(response);
                $("#divInstructorContact2").hide();
                $("#instructorContactList1").empty();
                if(response.contactList != null && response.contactList.length > 0) {
                    var contactList = response.contactList
                    $("#divInstructorContact1").show();
                    contactList.forEach(function (contact, index, list) {
                        $("#instructorContactList1").append('<input type="checkbox" class="custom-control-input" name="instructorContact1" value="' + contact.type + '">');
                        $("#instructorContactList1").append('<label class="custom-control-label" for="same-address">' + contact.contact + '</label>');
                        $("#instructorContactList1").append('<br/>');
                    });
                }
            },
            error: function (request, status, error) {
                alert("데이터 조회에 실패했습니다.");
            }
        });
    });

    $("#instructor2").change(function() {
        // alert(this.value);

        if(this.value == "")  return;

        $.ajax({
            contentType: 'application/json',
            dataType: 'json',
            // data: JSON.stringify(data),
            url: '/getInstructor?userNo=' + this.value,
            type: 'GET',
            success: function (response) {
                // console.log(response)
                $("#divInstructorContact2").hide();
                $("#instructorContactList2").empty();
                if(response.contactList != null && response.contactList.length > 0) {
                    var contactList = response.contactList;
                    $("#divInstructorContact2").show();
                    contactList.forEach(function (contact, index, list) {
                        $("#instructorContactList2").append('<input type="checkbox" class="custom-control-input" name="instructorContact2" value="' + contact.type + '">');
                        $("#instructorContactList2").append('<label class="custom-control-label" for="same-address">' + contact.contact + '</label>');
                        $("#instructorContactList2").append('<br/>');
                    });
                }
            },
            error: function (request, status, error) {
                alert("데이터 조회에 실패했습니다.");
            }
        });
    });

    $("#imageLoad").click(function() {
        $("#classImage").attr('src', 'http://image.browny.kr/' + $("#classImageUrl").val());
    });

    $("#dateOptionAdd").click(function() {
        $("#dateOptionList").append('<li name="dateOptionList">' + $("#dateOption").val() + '<a onclick="javascript:$(this).parent().remove();">[X]</a></li>')
    })

    $("#priceOptionAdd").click(function() {
        $("#priceOptionList").append('<li name="priceOptionList">' + $("#priceOption").val() + '<a onclick="javascript:$(this).parent().remove();">[X]</a></li>')
    })
});

function loadClassDetail(classNo) {

    $.ajax({
        contentType: 'application/json',
        dataType: 'json',
        // data: JSON.stringify(data),
        url: '/getClassDetail?classNo=' + classNo,
        type: 'GET',
        success: function (response) {
            console.log(response);
            setClassDetail(response);
        },
        error: function (request, status, error) {
            alert("데이터 조회에 실패했습니다.");
        }
    })
}

function setClassDetail(response) {
    resetClassDetail();

    $("#title").val(response.title);
    $("#genre").val(response.genre);
    $("#region").val(response.region);
    if(response.classType != null) $("#classType").val(response.classType);
    if(response.only != null) $("#only").val(response.only);

    $("#instructor1").val(response.instructorNo1).trigger('change');
    if(response.instructorNo2 != null)  $("#instructor2").val(response.instructorNo2).trigger('change');

    $("#startDate").val(response.startDate);
    $("#endDate").val(response.endDate);
    if(response.dateSummary != null) $("#dateSummary").val(response.dateSummary);
    if(response.dateOptionList != null) {
        response.dateOptionList.forEach(function (option, index) {
            $("#dateOptionList").append('<li name="dateOptionList">' + option + '<a onclick="javascript:$(this).parent().remove();">[X]</a></li>')
        })
    }

    $("#startTime").val(response.startTime);
    $("#endTime").val(response.endTime);

    $("#location").val(response.location);

    $("#malePrice").val(response.malePrice);
    $("#femalePrice").val(response.femalePrice);
    if(response.priceOptionList != null) {
        response.priceOptionList.forEach(function (option, index) {
            $("#priceOptionList").append('<li name="priceOptionList">' + option + '<a onclick="javascript:$(this).parent().remove();">[X]</a></li>')
        })
    }

    $("#payment").val(response.payment);

    if(response.clubNo != null)  $("#club").val(response.clubNo);

    $("#classImageUrl").val(response.classImage);
    $("#imageLoad").trigger('click');

}

function resetClassDetail() {
    $("#instructor1").val("");
    $("#divInstructorContact1").hide();
    $("#instructorContactList1").empty();

    $("#instructor2").val("");
    $("#divInstructorContact2").hide();
    $("#instructorContactList2").empty();
}