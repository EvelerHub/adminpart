$(function() {

    Morris.Donut({
        element: 'morris-donut-chart',
        data: [{
            label: "new",
            value: 12
        }, {
            label: "started",
            value: 30
        }, {
            label: "other",
            value: 20
        }],
        resize: true,
        colors: [
            'red',
            'green',
            'grey'
        ]
    });

});
