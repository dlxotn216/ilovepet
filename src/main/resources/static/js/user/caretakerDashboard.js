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

	const initMounthlyCareLogAsAllUser = function (result) {
		let data = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
		if (result && result.length > 0) {
			for (let i = 0; i < result.length; i++) {
				let idx = MonthMapper[result[i].month];
				if (idx >= 0) {
					data[idx] = result[i].count;
				}
			}
		}

		const ctx = document.getElementById("monthlyCareLogAsAllUser").getContext('2d');
		const myChart = new Chart(ctx, {
			type: 'line',
			data: {
				labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun"
					, "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
				datasets: [{
					data: data,
					label: '전체 돌봄 서비스 제공 횟수',
					backgroundColor: [
						'rgba(255, 99, 132, 0.2)',
						'rgba(54, 162, 235, 0.2)',
						'rgba(255, 206, 86, 0.2)',
						'rgba(75, 192, 192, 0.2)',
						'rgba(153, 102, 255, 0.2)',
						'rgba(255, 159, 64, 0.2)'
					],
					borderColor: [
						'rgba(255,99,132,1)',
						'rgba(54, 162, 235, 1)',
						'rgba(255, 206, 86, 1)',
						'rgba(75, 192, 192, 1)',
						'rgba(153, 102, 255, 1)',
						'rgba(255, 159, 64, 1)'
					],
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

	const initMonthlyCareLogAsCurrentUser = function (result) {
		let data = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
		if (result && result.length > 0) {
			for (let i = 0; i < result.length; i++) {
				let idx = MonthMapper[result[i].month];
				if (idx >= 0) {
					data[idx] = result[i].count;
				}
			}
		}

		const ctx2 = document.getElementById("monthlyCareLogAsCurrentUser").getContext('2d');
		const myChart2 = new Chart(ctx2, {
			type: 'bar',
			data: {
				labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun"
					, "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
				datasets: [{
					data: data,
					label: '나의 돌봄 서비스 제공 횟수',
					backgroundColor: [
						'rgba(255, 99, 132, 0.2)',
						'rgba(54, 162, 235, 0.2)',
						'rgba(255, 206, 86, 0.2)',
						'rgba(75, 192, 192, 0.2)',
						'rgba(153, 102, 255, 0.2)',
						'rgba(255, 159, 64, 0.2)',
						'rgba(255, 99, 132, 0.2)',
						'rgba(54, 162, 235, 0.2)',
						'rgba(255, 206, 86, 0.2)',
						'rgba(75, 192, 192, 0.2)',
						'rgba(153, 102, 255, 0.2)',
						'rgba(255, 159, 64, 0.2)'
					],
					borderColor: [
						'rgba(255,99,132,1)',
						'rgba(54, 162, 235, 1)',
						'rgba(255, 206, 86, 1)',
						'rgba(75, 192, 192, 1)',
						'rgba(153, 102, 255, 1)',
						'rgba(255, 159, 64, 1)',
						'rgba(255,99,132,1)',
						'rgba(54, 162, 235, 1)',
						'rgba(255, 206, 86, 1)',
						'rgba(75, 192, 192, 1)',
						'rgba(153, 102, 255, 1)',
						'rgba(255, 159, 64, 1)'
					],
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

	const initMonthlyAddedPetLog = function (result) {
		let data = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
		if (result && result.length > 0) {
			for (let i = 0; i < result.length; i++) {
				let idx = MonthMapper[result[i].month];
				if (idx >= 0) {
					data[idx] = result[i].count;
				}
			}
		}

		const ctx3 = document.getElementById("monthlyAddedPetLog").getContext('2d');
		const myChart3 = new Chart(ctx3, {
			type: 'bar',
			data: {
				labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun"
					, "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
				datasets: [{
					data: data,
					label: '등록 된 반려동물 수',
					backgroundColor: [
						'rgba(255, 99, 132, 0.2)',
						'rgba(54, 162, 235, 0.2)',
						'rgba(255, 206, 86, 0.2)',
						'rgba(75, 192, 192, 0.2)',
						'rgba(153, 102, 255, 0.2)',
						'rgba(255, 159, 64, 0.2)',
						'rgba(255, 99, 132, 0.2)',
						'rgba(54, 162, 235, 0.2)',
						'rgba(255, 206, 86, 0.2)',
						'rgba(75, 192, 192, 0.2)',
						'rgba(153, 102, 255, 0.2)',
						'rgba(255, 159, 64, 0.2)'
					],
					borderColor: [
						'rgba(255,99,132,1)',
						'rgba(54, 162, 235, 1)',
						'rgba(255, 206, 86, 1)',
						'rgba(75, 192, 192, 1)',
						'rgba(153, 102, 255, 1)',
						'rgba(255, 159, 64, 1)',
						'rgba(255,99,132,1)',
						'rgba(54, 162, 235, 1)',
						'rgba(255, 206, 86, 1)',
						'rgba(75, 192, 192, 1)',
						'rgba(153, 102, 255, 1)',
						'rgba(255, 159, 64, 1)'
					],
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

	const initMonthlyAddedConsignerLog = function (result) {
		let data = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
		if (result && result.length > 0) {
			for (let i = 0; i < result.length; i++) {
				let idx = MonthMapper[result[i].month];
				if (idx >= 0) {
					data[idx] = result[i].count;
				}
			}
		}

		const ctx4 = document.getElementById("monthlyAddedConsignerLog").getContext('2d');
		const myChart4 = new Chart(ctx4, {
			type: 'line',
			data: {
				labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun"
					, "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
				datasets: [{
					data: data,
					label: '등록 맡기미 수',
					backgroundColor: [
						'rgba(255, 99, 132, 0.2)',
						'rgba(54, 162, 235, 0.2)',
						'rgba(255, 206, 86, 0.2)',
						'rgba(75, 192, 192, 0.2)',
						'rgba(153, 102, 255, 0.2)',
						'rgba(255, 159, 64, 0.2)'
					],
					borderColor: [
						'rgba(255,99,132,1)',
						'rgba(54, 162, 235, 1)',
						'rgba(255, 206, 86, 1)',
						'rgba(75, 192, 192, 1)',
						'rgba(153, 102, 255, 1)',
						'rgba(255, 159, 64, 1)'
					],
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

	return {
		'initMonthlyAddedConsignerLog': initMonthlyAddedConsignerLog,
		'initMonthlyAddedPetLog': initMonthlyAddedPetLog,
		'initMonthlyCareLogAsCurrentUser': initMonthlyCareLogAsCurrentUser,
		'initMounthlyCareLogAsAllUser': initMounthlyCareLogAsAllUser
	}
})();

const dashboardForCaretakerModule = (function(){
	'use strict';

	const xhr = new XMLHttpRequest();
	xhr.open("GET", "/caretakers/dashboard/added-pets");
	xhr.setRequestHeader('Content-Type', 'application/json');
	xhr.onreadystatechange = function () {
		if (xhr.readyState === 4 && xhr.status === 200) {
			initModule.initMonthlyAddedPetLog(JSON.parse(xhr.responseText).result);
		}
	};
	xhr.send();

	const xhr2 = new XMLHttpRequest();
	xhr2.open("GET", "/caretakers/dashboard/cares");
	xhr2.setRequestHeader('Content-Type', 'application/json');
	xhr2.onreadystatechange = function () {
		if (xhr2.readyState === 4 && xhr2.status === 200) {
			initModule.initMounthlyCareLogAsAllUser(JSON.parse(xhr2.responseText).result);
		}
	};
	xhr2.send();

	const xhr3 = new XMLHttpRequest();
	xhr3.open("GET", "/caretakers/dashboard/my-cares");
	xhr3.setRequestHeader('Content-Type', 'application/json');
	xhr3.onreadystatechange = function () {
		if (xhr3.readyState === 4 && xhr3.status === 200) {
			initModule.initMonthlyCareLogAsCurrentUser(JSON.parse(xhr3.responseText).result);
		}
	};
	xhr3.send();

	const xhr4 = new XMLHttpRequest();
	xhr4.open("GET", "/caretakers/dashboard/added-consigners");
	xhr4.setRequestHeader('Content-Type', 'application/json');
	xhr4.onreadystatechange = function () {
		if (xhr4.readyState === 4 && xhr4.status === 200) {
			initModule.initMonthlyAddedConsignerLog(JSON.parse(xhr4.responseText).result);
		}
	};
	xhr4.send();
})();