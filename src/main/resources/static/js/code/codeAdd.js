/**
 * Created by taesu on 2017-10-25.
 */

const codeAddModule = (function () {
	'use strict';

	const addCodeButton = document.getElementById('addCodeButton');
	addCodeButton.onclick = function () {
		const codeType = document.getElementById('codeType').value;
		const codeSeq = document.getElementById('codeSeq').value;
		const codeName = document.getElementById('codeName').value;

		if (!codeType || codeType === "" || codeType === null) {
			alert("제목을 입력해주세요");
			document.getElementById('codeType').focus();
			return;
		}

		if (!codeSeq || codeSeq === "" || codeSeq === null) {
			alert("코드 순서를 입력해주세요");
			document.getElementById('codeSeq').focus();
			return;
		}

		if (!codeName || codeName === "" || codeName === null) {
			alert("코드 이름을 입력해주세요");
			document.getElementById('codeName').focus();
			return;
		}

		const requestBody ={
            codeType: codeType,
            codeSeq: codeSeq,
            codeName: codeName,
		};

		const xhr = new XMLHttpRequest();
		xhr.open("POST", "/codes");
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