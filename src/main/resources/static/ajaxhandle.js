$(function () {
    let socket = new SockJS("/chat");
    let stompCilent = Stomp.over(socket);
    let current = 1;
    stompCilent.connect();

    function setConnectDisplay(isConnected) {
        let connect = $("#connectState");
        if (isConnected) {
            connect.val("connected");
            connect.css("color", "green");
        } else {
            connect.val("disconnected");
            connect.css("color", "red");
        }
    }

    function connect(id) {
        console.log("connected");
        stompCilent.subscribe("/group/" + id, function (response) {
            let msg = JSON.parse(response.body);
            console.log(msg);
            let msgBox = document.getElementById("msgBox");
            msgBox.innerHTML +=
                "<br><b class='" + id + "' style='color: blue'>" + msg.name + ": </b>" +
                msg.content;
        });
        current = id;
        setConnectDisplay(true);
    }

    function disconnect(id) {
        console.log("disconnected");
        stompCilent.unsubscribe("/group/" + id);
        setConnectDisplay(false);
    }

    function swicthconnect(id) {
        disconnect(current);
        connect(id);
        $("b").hide();
        $("b " + "." + id).show();
    }

    function sendMsg() {
        stompCilent.send("/send/" + $("#group").val(), {}, JSON.stringify({"name": $("#name").val(), "content": $("#msg").val()}))
    }

    $("#group").change(function () {
        swicthconnect($(this).val())
    });
    $("#connect").click(function () {
        connect($("#group").val())
    });
    $("#disconnect").click(function () {
        disconnect($("#group").val())
    });
    $("#send").click(function () {
        sendMsg()
    });
});