/**
 * Created by Alexander Eveler on 13.03.2016.
 */
var steamAccounts;

$(document).ready(function () {
    $.ajax({
        url: '/get',
        type: 'GET',
        timeout: 10000,
        crossDomain: true,
        dataType: "json",
        contentType: "application/json; charset=UTF-8",
        beforeSend: function () {
            // should be some animation
            table = $('#steam-table').html();
            var animationDiv = '<div class="bar"></div>';
            $('#steam-table').html(animationDiv);
        },
        error: function () {
            // should be some error listener
        },
        success: addParentToTable
    });
});

function addParentToTable(data) {
    $("#steam-table").html(table);
    console.log(data.length);

    steamAccounts = data;

    for (var i = 0; i < data.length; i++) {
        data[i].id = i;
        var clazz;

        switch (data[i].status) {
            case 'starting' :
                clazz = "warning";
                break;
            case 'error' :
                clazz = "danger";
                break;
            case 'started' :
                clazz = "success";
                break;
            case 'startproceed' :
                clazz = "warning";
                break;
        }

        var tableRow = '<tr class="' + clazz + ' clickable-row">' +
            '<td class="id">' + data[i].id + '</td>' +
            '<td>' + data[i].login + '</td>' +
            '<td>' + data[i].dateAdded + '</td>' +
            '<td>' + data[i].updateDate + '</td>' +
            '<td>' + data[i].status + '</td>' +
            '</tr>';
        $('#steam-table-body').append(tableRow);
    }

    updateTable();
    onClickListeners();
}

function updateTable() {
    $('#steam-table').DataTable({
        responsive: true
    });
}

function onClickListeners() {
    $(".clickable-row").click(function () {
        var id = $(this).find('.id').html();
        var steamAccount = steamAccounts[id];
        var fields = '<tr><td>Login:</td><td id="login">' + steamAccount.login + '</td></tr>' +
            '<tr><td>Password:</td><td id="login">' + steamAccount.pass + '</td></tr>' +
            '<tr><td>Steam key:</td><td id="login">' + steamAccount.steamKey + '</td></tr>' +
            '<tr><td>Market key:</td><td id="login">' + steamAccount.dota2marketKey + '</td></tr>' +
            '<tr><td></td><td></td></tr>'; // for underline

        var inputFields = $('#data-input-fields').html();

        $('#modal-data-fields').html(fields);
        $('#modal-data-input-fields').html(inputFields);

        $('#modal').modal();
    });

    $('#delete').click(function(){
        console.log((confirm('вы подтверждаеье удаление учетной записи steam?')));
    });

    $('#add-and-start').click(function(){
        console.log('start');
        var a = '{"name":"reveller3","login":"alexander_eveler2","pass":"VivaForever",'+
                '"market_key":"qwerqwerqwer","steam_key":"7DA08E6F8F674E9778DC5F9C04BB44AD"}';

        $.ajax({
            url: 'http://ec2-52-35-187-114.us-west-2.compute.amazonaws.com:9000/bot/add',
            type: 'POST',
            timeout: 10000,
            crossDomain: true,
            dataType: "json",
            data: a,
            contentType: "application/json; charset=UTF-8",
            beforeSend: function () {
                console.log('before');
            },
            error: function () {
                // should be some error listener
            },
            success: addParentToTable
        });
        console.log('finish');
    });
}