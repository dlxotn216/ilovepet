/**
 * Created by taesu on 2017-10-25.
 */

const noticeUpdateModule = (function () {
	'use strict';

	const updateNoticeButton = document.getElementById('updateNoticeButton');
	updateNoticeButton.onclick = function () {
		const noticeKey = document.getElementById('noticeKey').value;

		const title = document.getElementById('title').value;
		const content = document.getElementById('content').value;

		if (!title || title === "" || title === null) {
			alert("제목을 입력해주세요");
			document.getElementById('title').focus();
			return;
		}

		if (!content || content === "" || content === null) {
			alert("내용을 입력해주세요");
			document.getElementById('content').focus();
			return;
		}

		const requestBody ={
			title: title,
			content: content
		};

		const xhr = new XMLHttpRequest();
		xhr.open("PUT", "/notices/"+noticeKey);
		xhr.setRequestHeader('Content-Type', 'application/json');

		xhr.onreadystatechange = function () {
			if (xhr.readyState === 4 && xhr.status === 200) {
				let response = JSON.parse(xhr.responseText);
				if (response.status) {
					displayAlertModal(true, '요청 성공하였습니다');
					afterSuccess();
				} else {
					displayAlertModal(false, '요청 실패하였습니다');
				}
			}
		};
		xhr.send(JSON.stringify(requestBody));
	}
})();