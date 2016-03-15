/**
 * Created by Alexander Eveler on 13.03.2016.
 */
var steamAccounts;
var table;
var currentSteamAccount;

var newSteamAccounts = 0;
var startedSteamAccounts = 0;
var otherSteamAccounts = 0;

$(document).ready(function () {
    $.ajax({
        url: 'http://ec2-52-35-187-114.us-west-2.compute.amazonaws.com:9000/bot',
        type: 'GET',
        timeout: 10000,
        crossDomain: true,
        dataType: "json",
        contentType: "application/json; charset=UTF-8",
        beforeSend: function () {
            // TODO: should be some animation
            table = $('#steam-table').html();
            var animationDiv = '<div class="bar"></div>';
            $('#steam-table').html(animationDiv);
            $('#morris-donut-chart').html(animationDiv);
        },
        error: function () {
            // TODO: should be some error listener
        },
        success: addParentOnPage
    });
});

function addParentOnPage(data) {
    $("#steam-table").html(table);
    console.log(data.length);

    steamAccounts = data;


    for (var i = 0; i < data.length; i++) {
        data[i].id = i;
        var clazz;

        switch (data[i].status) {
            case 'starting' :
                clazz = 'warning ';
                otherSteamAccounts++;
                break;
            case 'error' :
                clazz = 'danger ';
                otherSteamAccounts++;
                break;
            case 'stopped' :
                clazz = 'danger ';
                otherSteamAccounts++;
                break;
            case 'started' :
                clazz = 'success ';
                startedSteamAccounts++;
                break;
            case 'startproceed' :
                clazz = 'warning ';
                otherSteamAccounts++;
                break;
            case 'new' :
                newSteamAccounts++;
                break;
            default :
                otherSteamAccounts++;
                clazz = '';
        }

        var tableRow = '<tr class="' + clazz + 'clickable-row">' +
            '<td class="id">' + data[i].id + '</td>' +
            '<td>' + data[i].login + '</td>' +
            '<td>' + data[i].dateAdded + '</td>' +
            '<td>' + data[i].updateDate + '</td>' +
            '<td>' + data[i].status + '</td>' +
            '</tr>';
        $('#steam-table-body').append(tableRow);
        $('#morris-donut-chart').html('');
    }

    updateTable();
    setDiagram();
    onClickListeners();
}

function setDiagram(){
    Morris.Donut({
        element: 'morris-donut-chart',
        data: [{
            label: "started",
            value: startedSteamAccounts
        }, {
            label: "other",
            value: otherSteamAccounts
        }, {
            label: "new",
            value: newSteamAccounts
        }],
        resize: true,
        colors: [
            '#54CF22',
            '#CD2626',
            '#A8A1A1'
        ]
    });
}

function updateTable() {
    $('#steam-table').DataTable({
        responsive: true
    });
}

function onClickListeners() {
    $(".clickable-row").click(function () {
        var id = $(this).find('.id').html();
        currentSteamAccount = steamAccounts[id];

        var fields = '<tr><td>Login:</td><td id="login">' + currentSteamAccount.login + '</td></tr>' +
            '<tr><td>Password:</td><td id="pass">' + currentSteamAccount.pass + '</td></tr>' +
            '<tr><td>Steam key:</td><td id="steam-key">' + currentSteamAccount.steamKey + '</td></tr>' +
            '<tr><td>Market key:</td><td id="market-key">' + currentSteamAccount.dota2marketKey + '</td></tr>' +
            '<tr><td></td><td></td></tr>'; // for underline

        var inputFields = $('#data-input-fields').html();

        $('#modal-data-fields').html(fields);
        $('#modal-data-input-fields').html(inputFields);

        $('#modal').modal();
    });

    $('#delete').click(function () {
        if (confirm('вы подтверждаеье удаление учетной записи steam?')) {
            $.ajax({
                url: 'http://ec2-52-35-187-114.us-west-2.compute.amazonaws.com:9000/bot/delete',
                type: 'POST',
                timeout: 10000,
                crossDomain: true,
                dataType: "json",
                data: JSON.stringify(currentSteamAccount),
                contentType: "application/json; charset=UTF-8",
                beforeSend: function () {
                    // TODO: should be some on before listener
                },
                error: function () {
                    // TODO: should be some on error listener
                },
                success: function () {
                    $('#modal').modal('hide');
                    // TODO: should be some on success listener
                }
            })
        }
    });

    $('#update').click(function () {
        var steamAccount = parseData($('#modal-data-input-fields'));
        steamAccount.status = "new";
        var updateObject = {};
        updateObject.name = currentSteamAccount.login;

        if (steamAccount.name) {
            updateObject.name = steamAccount.login;
        }

        updateObject.update = steamAccount;
        console.log(JSON.stringify(updateObject));

        if (confirm('Вы подтверждаеье обновить учетную запись steam?')) {
            update(updateObject);
        }
    });

    $('#start').click(function () {
        var startObject = {};
        startObject.name = currentSteamAccount.login;
        console.log(JSON.stringify(startObject));

        start(startObject);
    });

    $('#stop').click(function () {
        var stopObject = {};
        stopObject.name = currentSteamAccount.login;
        console.log(JSON.stringify(stopObject));

        $.ajax({
            url: 'http://ec2-52-35-187-114.us-west-2.compute.amazonaws.com:9000/bot/stop',
            type: 'POST',
            timeout: 10000,
            crossDomain: true,
            dataType: "json",
            data: JSON.stringify(stopObject),
            contentType: "application/json; charset=UTF-8",
            beforeSend: function () {
                // TODO: should be some on before listener
            },
            error: function () {
                // TODO: should be some on error listener
            },
            success: function () {
                // TODO: should be some on success listener
            }
        })
    });

    $('#add-and-start').click(function () {
        var steamAccount = parseData($('#data-input-fields'));
        steamAccount.name = steamAccount.login;
        console.log(JSON.stringify(steamAccount));
        add(steamAccount);

        var updateObject = {};
        steamAccount.status = "new";
        updateObject.name = steamAccount.name;
        updateObject.update = steamAccount;

        update(updateObject);

        var startObject = {};
        startObject.name = steamAccount.name;
        start(startObject);
    });
}

function start(startObject) {
    $.ajax({
        url: 'http://ec2-52-35-187-114.us-west-2.compute.amazonaws.com:9000/bot/start',
        type: 'POST',
        timeout: 10000,
        crossDomain: true,
        dataType: "json",
        data: JSON.stringify(startObject),
        contentType: "application/json; charset=UTF-8",
        beforeSend: function () {
            // TODO: should be some on before listener
        },
        error: function () {
            // TODO: should be some on error listener
        },
        success: function () {
            // TODO: should be some on success listener
        }
    })
}

function update(updateObject) {

    $.ajax({
        url: 'http://ec2-52-35-187-114.us-west-2.compute.amazonaws.com:9000/bot/update',
        type: 'POST',
        timeout: 10000,
        crossDomain: true,
        dataType: "json",
        data: JSON.stringify(updateObject),
        contentType: "application/json; charset=UTF-8",
        beforeSend: function () {
            // TODO: should be some on before listener
        },
        error: function () {
            // TODO: should be some on error listener
        },
        success: function () {
            // TODO: should be some on success listener
        }
    })
}

function add(steamAccount) {
    $.ajax({
        url: 'http://ec2-52-35-187-114.us-west-2.compute.amazonaws.com:9000/bot/add',
        type: 'POST',
        timeout: 10000,
        crossDomain: true,
        dataType: "json",
        data: JSON.stringify(steamAccount),
        contentType: "application/json; charset=UTF-8",
        beforeSend: function () {
            // TODO: should be some on before listener
        },
        error: function () {
            // TODO: should be some on error listener
        },
        success: function () {
            // TODO: should be some on success listener
        }
    });
}

function parseData(fields) {
    var inputFields = fields.find("input");
    var steamAccount = {};

    var login = $(inputFields.get(0)).val();
    var pass = $(inputFields.get(1)).val();
    var steamKey = $(inputFields.get(2)).val();
    var marketKey = $(inputFields.get(3)).val();
    var twoFactorCode = $(inputFields.get(4)).val();

    if (login) steamAccount.login = login;

    if (pass) steamAccount.pass = pass;

    if (steamKey) steamAccount.steam_key = steamKey;

    if (marketKey) steamAccount.market_key = marketKey;

    if (twoFactorCode) steamAccount.authCode = twoFactorCode;

    return steamAccount;
}