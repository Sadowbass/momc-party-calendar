function createHttpRequest(method, url) {
    let xhr = new XMLHttpRequest();

    xhr.open(method, url, true);
    xhr.setRequestHeader("Content-Type", "application/json");

    return xhr;
}

function ajaxOnload(httpRequest, successCallback) {
    httpRequest.onload = (data) => {
        let response = JSON.parse(httpRequest.response);
        if (httpRequest.status === 200) {
            successCallback(response);
        } else {
            console.error("===error log start===")
            console.error(data);
            console.error(response);
            console.error("===error log end===")
            alert(`작업에 실패하였습니다. 에러 로그를 확인해주세요.`)
        }
    }
}