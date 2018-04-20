$.ajaxSetup({
    beforeSend: function (xhr, settings) {
        if (settings.type == 'POST' || settings.type == 'PUT'
            || settings.type == 'DELETE') {
            if (!(/^http:.*/.test(settings.url) || /^https:.*/
                    .test(settings.url))) {
                // Only send the token to relative URLs i.e. locally.
                xhr.setRequestHeader("X-XSRF-TOKEN",
                    Cookies.get('XSRF-TOKEN'));
            }
        }
    }
});

$.get("/lifetime-activity", function (data) {
    $("#lifetimeSteps").html(data.steps);
    $("#lifetimeFloors").html(data.floors);
    $("#lifetimeDistance").html(data.distance);
});

$.get("/user", function (data) {
    $("#user").html(data.userAuthentication.details.user.fullName);
    $(".unauthenticated").hide();
    $(".authenticated").show();
});

var daily_activities = function () {
    var date = document.getElementById("date").value;
    $.get("/daily-activity", {date: date + ".json"}, function (data) {
        console.log(data);
    });
};

var goals = function () {
    var goal_type = $('input[name=goals]:checked').val()
    $.get("/goals", {goal_type: goal_type + ".json"}, function (data) {
        console.log(data);
    });
};

var sleep_data = function () {
    var start_date = document.getElementById("start_date").value;
    var end_date = document.getElementById("end_date").value;
    $.get("/sleep-data", {date_range: start_date + "/" + end_date + ".json"}, function (data) {
        console.log("hii man 1");
        console.log(data);
        var deepObjList = [];
        var lightObjList = [];
        var remObjList = [];
        var wakeObjList = [];
        data.forEach(function (entry) {
            var summary = entry.levels.summary;

            var deepObj = {};
            deepObj['y'] = parseInt(summary.deep.minutes);
            deepObj['label'] = entry.dateOfSleep;
            deepObjList.push(deepObj);

            var lightObj = {};
            lightObj['y'] = parseInt(summary.light.minutes);
            lightObj['label'] = entry.dateOfSleep;
            lightObjList.push(lightObj);

            var remObj = {};
            remObj['y'] = parseInt(summary.rem.minutes);
            remObj['label'] = entry.dateOfSleep;
            remObjList.push(remObj);

            var wakeObj = {};
            wakeObj['y'] = parseInt(summary.wake.minutes);
            wakeObj['label'] = entry.dateOfSleep;
            wakeObjList.push(wakeObj);
        });
        sleep_graphs(deepObjList, lightObjList, remObjList, wakeObjList);
    });
};

var heart_rate_data = function () {
    var start_date = document.getElementById("heart_start_date").value;
    var end_date = document.getElementById("heart_end_date").value;
    $.get("/heart-rate", {date_range: start_date + "/" + end_date + ".json"}, function (data) {
        console.log("hii man 2");
        console.log(data);
        var normalObjList = [];
        var fatBurnObjList = [];
        var cardioObjList = [];
        var peakObjList = [];
        var parts;
        var mydate;
        data.forEach(function (entry) {
            var heartRateZones = entry.value.heartRateZones;
            heartRateZones.forEach(function (heartZone) {
                if (heartZone.name === "Out of Range") {
                    var normalObj = {};
                    normalObj['y'] = parseInt(heartZone.minutes);
                    parts = entry.dateTime.split('-');
                    mydate = new Date(parts[0], parts[1] - 1, parts[2]);
                    normalObj['label'] = mydate.toLocaleDateString();

                    normalObjList.push(normalObj);
                } else if (heartZone.name === "Fat Burn") {
                    var fatBurnObj = {};
                    fatBurnObj['y'] = parseInt(heartZone.minutes);
                    parts = entry.dateTime.split('-');
                    mydate = new Date(parts[0], parts[1] - 1, parts[2]);
                    fatBurnObj['label'] = mydate.toLocaleDateString();

                    fatBurnObjList.push(fatBurnObj);
                } else if (heartZone.name === "Cardio") {
                    var cardioObj = {};
                    cardioObj['y'] = parseInt(heartZone.minutes);
                    parts = entry.dateTime.split('-');
                    mydate = new Date(parts[0], parts[1] - 1, parts[2]);
                    cardioObj['label'] = mydate.toLocaleDateString();

                    cardioObjList.push(cardioObj);
                } else {
                    var peakObj = {};
                    peakObj['y'] = parseInt(heartZone.minutes);
                    parts = entry.dateTime.split('-');
                    mydate = new Date(parts[0], parts[1] - 1, parts[2]);
                    peakObj['label'] = mydate.toLocaleDateString();

                    peakObjList.push(peakObj);
                }
                console.log(heartZone.name + " : " + heartZone.minutes + ":" + entry.dateTime);
            })

        });
        heart_graphs(normalObjList, fatBurnObjList, cardioObjList, peakObjList);
        // graph1(listOfObjects, "Daily Steps", "Daily Steps", "Date");
    });
};

var steps_data = function () {
    var start_date = document.getElementById("steps_start_date").value;
    var end_date = document.getElementById("steps_end_date").value;
    $.get("/steps-data", {date_range: start_date + "/" + end_date + ".json"}, function (data) {
        console.log("hii man 3");
        console.log(data);
        var listOfObjects = [];
        data.forEach(function (entry) {
            var singleObj = {};
            console.log(entry.dateTime + " : " + entry.value);
            singleObj['y'] = parseInt(entry.value);
            singleObj['label'] = entry.dateTime;

            listOfObjects.push(singleObj);
        });
        graph1(listOfObjects, "Daily Steps", "Daily Steps", "Date");
    });
};


var calories_data = function () {
    var start_date = document.getElementById("calories_start_date").value;
    var end_date = document.getElementById("calories_end_date").value;
    $.get("/calories-data", {date_range: start_date + "/" + end_date + ".json"}, function (data) {
        console.log("hii man 4");
        console.log(data);
        // for (var i = 0, l = data.length; i < l; i++) {
        //     var obj = data[i];
        //     console.log(obj.dateTime + " : " +obj.value)
        // }
        var listOfObjects = [];
        data.forEach(function (entry) {
            var singleObj = {};
            console.log(entry.dateTime + " : " + entry.value);
            singleObj['y'] = parseInt(entry.value);
            singleObj['label'] = entry.dateTime;

            listOfObjects.push(singleObj);
        });
        graph1(listOfObjects, "Calories Burned", "Calories Burned in kJ", "Date");
    });
};


var distance_data = function () {
    var start_date = document.getElementById("distance_start_date").value;
    var end_date = document.getElementById("distance_end_date").value;
    $.get("/distance-data", {date_range: start_date + "/" + end_date + ".json"}, function (data) {
        console.log("hii man 5");
        console.log(data);

        var listOfObjects = [];
        data.forEach(function (entry) {
            var singleObj = {};
            console.log(entry.dateTime + " : " + entry.value);
            singleObj['y'] = parseInt(entry.value);
            singleObj['label'] = entry.dateTime;

            listOfObjects.push(singleObj);
        });
        graph1(listOfObjects, "Walking Distance", "Distance in Miles", "Date");
    });
};


var floors_data = function () {
    var start_date = document.getElementById("floors_start_date").value;
    var end_date = document.getElementById("floors_end_date").value;
    $.get("/floors-data", {date_range: start_date + "/" + end_date + ".json"}, function (data) {
        console.log("hii man 6");
        console.log(data);
        var listOfObjects = [];
        data.forEach(function (entry) {
            var singleObj = {};
            console.log(entry.dateTime + " : " + entry.value);
            singleObj['y'] = parseInt(entry.value);
            singleObj['label'] = entry.dateTime;

            listOfObjects.push(singleObj);
        });
        graph1(listOfObjects, "Floors Climbed", "Number of Floors", "Date");
    });
};

var graph1 = function (data, strTitle, strY, strX) {

    var chart = new CanvasJS.Chart("chartContainer", {
        animationEnabled: true,
        theme: "light2", // "light1", "light2", "dark1", "dark2"
        title: {
            text: strTitle
        },
        axisY: {
            title: strY
        },
        axisX: {
            title: strX
        },
        data: [{
            type: "column",
            showInLegend: true,
            legendMarkerColor: "grey",
            // legendText: "Date",
            dataPoints: data
        }]
    });
    chart.render();

}

var logout = function () {
    $.post("/logout", function () {
        $("#user").html('');
        $(".unauthenticated").show();
        $(".authenticated").hide();
    });
    return true;
}