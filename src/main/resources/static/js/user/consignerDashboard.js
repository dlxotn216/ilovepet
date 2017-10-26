/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-25
 */

const MonthMapper = {
	"Jan": 0,
	"Feb": 1,
	"Mar": 2,
	"Apr": 3,
	"May": 4,
	"Jun": 5,
	"Jul": 6,
	"Aug": 7,
	"Sep": 8,
	"Oct": 9,
	"Nov": 10,
	"Dec": 11,
	"null": -1
};
const initModule = (function () {
	'use strict';

	const initDailyAddedPetLog = function (result) {
		let datas = [];
		let labels = [];
		let backgroundColors = [];
		let borderColors = [];
		if (result && result.length > 0) {
			for (let i = 0; i < result.length; i++) {
				labels[i] = result[i].date;
				datas[i] = result[i].count;
				backgroundColors[i] = 'rgba(75, 192, 192, 0.2)';
				borderColors[i] = 'rgba(75, 192, 192, 1)';
			}
		}
		const ctx = document.getElementById("monthlyAddedPetLog").getContext('2d');
		const myChart = new Chart(ctx, {
			type: 'line',
			data: {
				labels: labels,
				datasets: [{
					label: '등록 된 반려동물 수',
					data: datas,
					backgroundColor: backgroundColors,
					borderColor: borderColors,
					borderWidth: 1
				}]
			},
			options: {
				scales: {
					yAxes: [{
						ticks: {
							beginAtZero: true
						}
					}]
				}
			}
		});
	};

	const initDailyCareServiceUsageLog = function (result) {
		let datas = [];
		let labels = [];
		let backgroundColors = [];
		let borderColors = [];
		if (result && result.length > 0) {
			for (let i = 0; i < result.length; i++) {
				labels[i] = result[i].date;
				datas[i] = result[i].count;
				backgroundColors[i] = 'rgba(255, 206, 86, 0.2)';
				borderColors[i] = 'rgba(255, 206, 86, 1)';
			}
		}
		const ctx2 = document.getElementById("monthlyCareServiceUsageLog").getContext('2d');
		const myChart2 = new Chart(ctx2, {
			type: 'bar',
			data: {
				labels:labels,
				datasets: [{
					label: '돌봄 서비스 사용 현황',
					data: datas,
					backgroundColor: backgroundColors,
					borderColor: borderColors,
					borderWidth: 1
				}]
			},
			options: {
				scales: {
					yAxes: [{
						ticks: {
							beginAtZero: true
						}
					}]
				}
			}
		});
	};

	const initDailyAddedCaretakerLog = function (result) {
		let datas = [];
		let labels = [];
		let backgroundColors = [];
		let borderColors = [];
		if (result && result.length > 0) {
			for (let i = 0; i < result.length; i++) {
				labels[i] = result[i].date;
				datas[i] = result[i].count;
				backgroundColors[i] = 'rgba(54, 162, 235, 0.2)';
				borderColors[i] = 'rgba(54, 162, 235, 1)';
			}
		}
		const ctx3 = document.getElementById("monthlyAddedCaretakerLog").getContext('2d');
		const myChart3 = new Chart(ctx3, {
			type: 'line',
			data: {
				labels: labels,
				datasets: [{
					label: '등록 된 돌보미 수',
					data: datas,
					backgroundColor: backgroundColors,
					borderColor:borderColors,
					borderWidth: 1
				}]
			},
			options: {
				scales: {
					yAxes: [{
						ticks: {
							beginAtZero: true
						}
					}]
				}
			}
		});
	};

	const initNumOfCaretakerAsCity = function (result) {
		let labels = [];
		let data = [];

		if (result && result.length > 0) {
			for (let i = 0; i < result.length; i++) {
				labels.push(result[i].cityName);
				data.push(result[i].count);
			}
		}
		const ctx4 = document.getElementById("numOfCaretakerAsCity").getContext('2d');
		const myChart4 = new Chart(ctx4, {
			type: 'doughnut',
			data: {
				datasets: [{
					data: data,
					backgroundColor: [
						'rgba(255, 99, 132, 0.2)',
						'rgba(54, 162, 235, 0.2)',
						'rgba(255, 206, 86, 0.2)',
						'rgba(75, 192, 192, 0.2)',
						'rgba(153, 102, 255, 0.2)',
						'rgba(255, 159, 64, 0.2)',

						'rgba(37, 129, 161, 0.2)',
						'rgba(37, 186, 109, 0.2)',
						'rgba(223, 68, 198, 0.2)',
						'rgba(97, 151, 218, 0.2)',

						'rgba(255, 206, 86, 0.2)',
						'rgba(75, 192, 192, 0.2)',
						'rgba(153, 102, 255, 0.2)',
						'rgba(255, 159, 64, 0.2)',

						'rgba(223, 68, 198, 0.2)',
						'rgba(97, 151, 218, 0.2)',
						'rgba(255, 206, 86, 0.2)',
						'rgba(75, 192, 192, 0.2)',

					],
					borderColor: [
						'rgba(255,99,132,1)',
						'rgba(54, 162, 235, 1)',
						'rgba(255, 206, 86, 1)',
						'rgba(75, 192, 192, 1)',
						'rgba(153, 102, 255, 1)',
						'rgba(255, 159, 64, 1)',

						'rgba(37, 129, 161, 1)',
						'rgba(37, 186, 109, 1)',
						'rgba(223, 68, 198, 1)',
						'rgba(97, 151, 218, 1)',

						'rgba(255, 206, 86, 1)',
						'rgba(75, 192, 192, 1)',
						'rgba(153, 102, 255, 1)',
						'rgba(255, 159, 64, 1)',

						'rgba(223, 68, 198, 1)',
						'rgba(97, 151, 218, 1)',
						'rgba(255, 206, 86, 1)',
						'rgba(75, 192, 192, 1)',
					],
				}],
				labels: labels,
			}
		});
	};

	const onNoticeDetailClick = function (noticeKey) {
		window.location.href = '/notice/' + noticeKey + "/detail";
	}

	return {
		'initDailyAddedPetLog': initDailyAddedPetLog,
		'initDailyCareServiceUsageLog': initDailyCareServiceUsageLog,
		'initDailyAddedCaretakerLog': initDailyAddedCaretakerLog,
		'initNumOfCaretakerAsCity': initNumOfCaretakerAsCity,
		'onNoticeDetailClick': onNoticeDetailClick
	};
})();

const dashboardForConsignerModule = (function () {
	'use strict';

	const xhr = new XMLHttpRequest();
	xhr.open("GET", "/consigners/dashboard/pets");
	xhr.setRequestHeader('Content-Type', 'application/json');
	xhr.onreadystatechange = function () {
		if (xhr.readyState === 4 && xhr.status === 200) {
			initModule.initDailyAddedPetLog(JSON.parse(xhr.responseText).result);
		}
	};
	xhr.send();

	const xhr2 = new XMLHttpRequest();
	xhr2.open("GET", "/consigners/dashboard/care/usage");
	xhr2.setRequestHeader('Content-Type', 'application/json');
	xhr2.onreadystatechange = function () {
		if (xhr2.readyState === 4 && xhr2.status === 200) {
			initModule.initDailyCareServiceUsageLog(JSON.parse(xhr2.responseText).result);
		}
	};
	xhr2.send();

	const xhr3 = new XMLHttpRequest();
	xhr3.open("GET", "/consigners/dashboard/added-caretakers");
	xhr3.setRequestHeader('Content-Type', 'application/json');
	xhr3.onreadystatechange = function () {
		if (xhr3.readyState === 4 && xhr3.status === 200) {
			initModule.initDailyAddedCaretakerLog(JSON.parse(xhr3.responseText).result);
		}
	};
	xhr3.send();

	const xhr4 = new XMLHttpRequest();
	xhr4.open("GET", "/consigners/dashboard/caretakers-by-city");
	xhr4.setRequestHeader('Content-Type', 'application/json');
	xhr4.onreadystatechange = function () {
		if (xhr4.readyState === 4 && xhr4.status === 200) {
			initModule.initNumOfCaretakerAsCity(JSON.parse(xhr4.responseText).result);
		}
	};
	xhr4.send();
})();

const onNoticeDetailClick = initModule.onNoticeDetailClick;