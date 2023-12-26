var Board_call = (function () {

    function getBoardList() {
        $.ajax({
            // type: 'GET',
            // url: '/board/v1/board?pageSize='+encodeURI(10)+'&page='+encodeURI(0),
            // dataType: 'json',
            // contentType: "application/json",
            // success: function (data) {
            //     console.log(data)
            //     document.getElementById("testbutton").innerText = data.success;
            // }

            type: 'GET',
            url: '/board/post/1',
            dataType: 'json',
            contentType: "application/json",
            success: function (data) {
                console.log(data)
            }

        })
    }

    return {
        getBoardList: getBoardList,
    }
})();