/**
 * Created by taesu on 2017-10-25.
 */

const noticeDetailModule = (function () {
	'use strict';

	const onNoticeDeleteButtonClick = function (noticeKey) {
		const okCallback = function () {
			const xhr = new XMLHttpRequest();
			xhr.open("DELETE", "/notices/" + noticeKey);
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
			xhr.send();
		};
		displayDeleteConfirmModal(okCallback);
	};

	const onRouteToNoticeUpdateButtonClick = function (noticeKey) {
		window.location.href = '/notice/' + noticeKey + '/update';
	};

	return {
		'onNoticeDeleteButtonClick': onNoticeDeleteButtonClick,
		'onRouteToNoticeUpdateButtonClick': onRouteToNoticeUpdateButtonClick
	};
})();

const onNoticeDeleteButtonClick = noticeDetailModule.onNoticeDeleteButtonClick;
const onRouteToNoticeUpdateButtonClick = noticeDetailModule.onRouteToNoticeUpdateButtonClick;
