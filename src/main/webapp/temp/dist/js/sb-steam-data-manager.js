/**
 * Created by Alexander Eveler on 13.03.2016.
 */
var steamAccounts;
var tempTable;
var currentSteamAccount;

var pieChartData = {
    newSteamAccounts: 0,
    startedSteamAccounts: 0,
    otherSteamAccounts: 0
};

var steamAccountAPI = {

    deleteSteamAccount: function (deleteObject) {
        $.ajax({
            url: window.location.href + '/delete',
            type: 'POST',
            timeout: 10000,
            crossDomain: true,
            dataType: "json",
            data: JSON.stringify(deleteObject),
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
    },

    stopSteamAccount: function (stopObject) {
        $.ajax({
            url: window.location.href + '/stop',
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
    },

    startSteamAccount: function (startObject) {
        $.ajax({
            url: window.location.href + '/start',
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
    },

    updateSteamAccount: function (updateObject) {
        $.ajax({
            url: window.location.href + '/update',
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
    },

    addSteamAccount: function (steamAccount) {
        $.ajax({
            url: window.location.href + '/add',
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
    },

    getSteamAccounts: function () {
        $.ajax({
            url: window.location.href + '/get',
            type: 'GET',
            timeout: 10000,
            crossDomain: true,
            dataType: "json",
            contentType: "application/json; charset=UTF-8",
            beforeSend: function () {
                tempTable = $('#steam-table').html();
                var animationDiv = '<div class="bar"></div>';
                $('#steam-table').html(animationDiv);
                $('#morris-donut-chart').html(animationDiv);
            },
            error: function () {
                // TODO: should be some error listener
            },
            success: addParentOnPage
        });
    }
};

$(document).ready(function () {
    steamAccountAPI.getSteamAccounts();
});

function addParentOnPage(data) {
    $("#steam-table").html(tempTable);
    console.log(data.length);

    steamAccounts = data;

    for (var i = 0; i < data.length; i++) {
        data[i].id = i;
        var clazz;

        switch (data[i].status) {
            case 'starting' :
                clazz = 'warning ';
                pieChartData.otherSteamAccounts++;
                break;
            case 'error' :
                clazz = 'danger ';
                pieChartData.otherSteamAccounts++;
                break;
            case 'stopped' :
                clazz = 'danger ';
                pieChartData.otherSteamAccounts++;
                break;
            case 'started' :
                clazz = 'success ';
                pieChartData.startedSteamAccounts++;
                break;
            case 'startproceed' :
                clazz = 'warning ';
                pieChartData.otherSteamAccounts++;
                break;
            case 'new' :
                pieChartData.newSteamAccounts++;
                clazz = '';
                break;
            default :
                pieChartData.otherSteamAccounts++;
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

function setDiagram() {
    Morris.Donut({
        element: 'morris-donut-chart',
        data: [{
            label: "started",
            value: pieChartData.startedSteamAccounts
        }, {
            label: "other",
            value: pieChartData.otherSteamAccounts
        }, {
            label: "new",
            value: pieChartData.newSteamAccounts
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
        if (confirm('Вы подтверждаете удаление учетной записи Steam?')) {
            steamAccountAPI.deleteSteamAccount(currentSteamAccount);
        }
    });

    $('#update').click(function () {
        var steamAccount = parseData($('#modal-data-input-fields'));
        var updateObject = {};

        steamAccount.status = "new";
        updateObject.name = currentSteamAccount.login;

        if (steamAccount.name) {
            updateObject.name = steamAccount.login;
        }

        updateObject.update = steamAccount;
        console.log(JSON.stringify(updateObject));

        if (confirm('Вы подтверждаете обновление учетную запись Steam?')) {
            steamAccountAPI.updateSteamAccount(updateObject);
        }
    });

    $('#start').click(function () {
        var startObject = {};
        startObject.name = currentSteamAccount.login;
        console.log(JSON.stringify(startObject));

        steamAccountAPI.startSteamAccount(startObject);
    });

    $('#stop').click(function () {
        var stopObject = {};
        stopObject.name = currentSteamAccount.login;
        console.log(JSON.stringify(stopObject));

        steamAccountAPI.stopSteamAccount(stopObject);
    });

    $('#add-and-start').click(function () {
        var steamAccount = parseData($('#data-input-fields'));
        steamAccount.name = steamAccount.login;
        console.log(JSON.stringify(steamAccount));
        steamAccountAPI.addSteamAccount(steamAccount);

        var updateObject = {};
        steamAccount.status = "new";
        updateObject.name = steamAccount.login;
        updateObject.update = steamAccount;
        steamAccountAPI.updateSteamAccount(updateObject);

        var startObject = {};
        startObject.name = steamAccount.name;
        steamAccountAPI.startSteamAccount(startObject);
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