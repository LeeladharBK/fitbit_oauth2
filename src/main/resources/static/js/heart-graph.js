var heart_graphs = function (data1, data2, data3, data4) {

    var chart = new CanvasJS.Chart("chartContainer", {
        animationEnabled: true,
        title: {
            text: "Heartrate Breakdown",
            fontFamily: "arial black",
            fontColor: "#695A42"
        },
        axisX: {
            title: "Date",
            interval: 1,
            intervalType: "date"
        },
        axisY: {
            // valueFormatString: "$#0bn",
            title: "Minutes",
            gridColor: "#B6B1A8",
            tickColor: "#B6B1A8"
        },
        toolTip: {
            shared: true,
            content: toolTipContent
        },
        data: [{
            type: "stackedColumn",
            showInLegend: true,
            color: "#696661",
            name: "Normal",
            dataPoints: data1
        },
            {
                type: "stackedColumn",
                showInLegend: true,
                name: "Fat Burn",
                color: "#EDCA93",
                dataPoints: data2
            },
            {
                type: "stackedColumn",
                showInLegend: true,
                name: "Cardio",
                color: "#695A42",
                dataPoints: data3
            },
            {
                type: "stackedColumn",
                showInLegend: true,
                name: "Peak",
                color: "#B6B1A8",
                dataPoints: data4
            }]
    });
    chart.render();

    function toolTipContent(e) {
        var str = "";
        var total = 0;
        var str2, str3;
        for (var i = 0; i < e.entries.length; i++) {
            var str1 = "<span style= \"color:" + e.entries[i].dataSeries.color + "\"> " + e.entries[i].dataSeries.name + "</span>: <strong>" + e.entries[i].dataPoint.y + "</strong><br/>";
            total = e.entries[i].dataPoint.y + total;
            str = str.concat(str1);
        }
        str2 = "<span style = \"color:DodgerBlue;\"><strong>" + (e.entries[0].dataPoint.label) + "</strong></span><br/>";
        total = Math.round(total * 100) / 100;
        str3 = "<span style = \"color:Tomato\">Total:</span><strong> " + total + "</strong>m<br/>";
        return (str2.concat(str)).concat(str3);
    }

};