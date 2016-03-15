$(function() {

    Morris.Donut({
        element: 'morris-donut-chart',
        data: [{
            label: "started",
            value: 12
        }, {
            label: "other",
            value: 30
        }, {
            label: "new",
            value: 20
        }],
        resize: true,
        colors: [
            '#54CF22',
            '#CD2626',
            '#A8A1A1'
        ]
    });

});
