/**
 * Created by Eveler on 05.04.2016.
 */

$(document).ready(function () {
    $('#auth-button').click(function () {
        var authorizationData = getAuthorizationData();
        doAuthorization(authorizationData);
    });

    $('#register-button').click (function () {
        var registrationData = getRegistrationData();
        //doRegistration(authorizationData);
    })
});

function doAuthorization(authorizationData) {
    $.ajax({
        url: window.location.pathname,
        type: 'POST',
        timeout: 10000,
        crossDomain: true,
        dataType: "json",
        data: JSON.stringify(authorizationData),
        contentType: "application/json; charset=UTF-8",
        beforeSend: function () {
            // TODO: should be some on before listener
        },
        error: function (data) {
            console.log("error: mes ==>" + JSON.stringify(data));
            // TODO: should be some on error listener
        },
        success: function (mes) {
            var host = window.location.host;
            var protocol = window.location.protocol;

            console.log("success: mes ==>" + JSON.stringify(mes));

            //window.location.href = protocol + '://' + host + '/steam';
        }
    });
}

function getRegistrationData() {
    var fields = $('#register-form').find('input');
    var registrationData = {};

    fields.each(function () {
        var key = this.getAttribute('placeholder').toLowerCase();
        var value = $(this).val();

        registrationData[key] = value;
    });
    console.log(registrationData);
    console.log(JSON.stringify(registrationData));

    return registrationData;
}

function getAuthorizationData() {
    var login = $('#login-field').val();
    var password = $('#password-field').val();
    console.log("login ==> " + login + " pass ==> " + password);

    return {"login": login, "password": password}
}
