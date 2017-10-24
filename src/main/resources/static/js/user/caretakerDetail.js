/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-20
 */

const moduleCaretakerDetail = (function () {
	'use strict';

	window.addEventListener('load', function () {
		vanillacalendar.init();
	});

	const slider_barking = document.getElementById('slider-barking');
	noUiSlider.create(slider_barking, {
		start: 10,
		behaviour: 'snap',
		connect: [true, false],
		range: {
			'min': 0,
			'max': 100
		}
	});
	const barkingValue = document.getElementById('barking').value;
	slider_barking.noUiSlider.set(barkingValue);
	slider_barking.setAttribute('disabled', true);

	const slider_marking = document.getElementById('slider-marking');
	noUiSlider.create(slider_marking, {
		start: 10,
		behaviour: 'snap',
		connect: [true, false],
		range: {
			'min': 0,
			'max': 100
		}
	});
	const markingValue = document.getElementById('marking').value;
	slider_marking.noUiSlider.set(markingValue);
	slider_marking.setAttribute('disabled', true);

	const slider_mounting = document.getElementById('slider-mounting');
	noUiSlider.create(slider_mounting, {
		start: 10,
		behaviour: 'snap',
		connect: [true, false],
		range: {
			'min': 0,
			'max': 100
		}
	});
	const mountingValue = document.getElementById('mounting').value;
	slider_mounting.noUiSlider.set(mountingValue);
	slider_mounting.setAttribute('disabled', true);

	const slider_aggression = document.getElementById('slider-aggression');
	noUiSlider.create(slider_aggression, {
		start: 10,
		behaviour: 'snap',
		connect: [true, false],
		range: {
			'min': 0,
			'max': 100
		}
	});
	const aggressionValue = document.getElementById('aggression').value;
	slider_aggression.noUiSlider.set(aggressionValue);
	slider_aggression.setAttribute('disabled', true);

	const slider_size = document.getElementById('slider-size');
	noUiSlider.create(slider_size, {
		start: 10,
		behaviour: 'snap',
		connect: [true, false],
		range: {
			'min': 0,
			'max': 100
		}
	});
	const sizeValue = document.getElementById('size').value;
	slider_size.noUiSlider.set(sizeValue);
	slider_size.setAttribute('disabled', true);

	const setTotalPrice = function () {
		const feePerNight = document.getElementById('feePerNight').value;
		const dayCount = document.getElementById('dayCount').value;

		const additionalCount = document.getElementById('additionalCount').value;
		const additionalFee = document.getElementById('additionalFee').value;

		document.getElementById('totalPrice').innerHTML = ((feePerNight * dayCount) + (additionalCount * additionalFee)) + ' 원';
	};

	const dayPlusButton = document.getElementById("dayPlusButton");
	dayPlusButton.onclick = function () {
		let dayCount = document.getElementById('dayCount').value;
		dayCount++;
		document.getElementById('dayCount').value = dayCount;
		document.getElementById('dayCountDisplay').value = dayCount + ' 박';

		const feePerNight = document.getElementById('feePerNight').value;
		document.getElementById('perNightTotal').innerHTML = dayCount * feePerNight + ' 원';
		setTotalPrice();
	};

	const dayMinusButton = document.getElementById("dayMinusButton");
	dayMinusButton.onclick = function () {
		let dayCount = document.getElementById('dayCount').value;
		dayCount--;
		if (dayCount < 0) {
			return;
		}
		document.getElementById('dayCount').value = dayCount;

		document.getElementById('dayCountDisplay').value = dayCount + ' 박';

		const feePerNight = document.getElementById('feePerNight').value;
		document.getElementById('perNightTotal').innerHTML = dayCount * feePerNight + ' 원';
		setTotalPrice();
	};

	const plusButton = document.getElementById("plusButton");
	plusButton.onclick = function () {
		let additionalCount = document.getElementById('additionalCount').value;
		additionalCount++;
		const additionalMaxCount = document.getElementById('additionalMaxCount').value;
		if (additionalCount >= additionalMaxCount) {
			return;
		}
		document.getElementById('additionalCount').value = additionalCount;
		document.getElementById('additionalCountDisplay').value = additionalCount + ' 마리';

		const additionalFee = document.getElementById('additionalFee').value;
		document.getElementById('additionalCountTotal').innerHTML = additionalCount * additionalFee + ' 원';
		setTotalPrice();
	};

	const minusButton = document.getElementById("minusButton");
	minusButton.onclick = function () {
		let additionalCount = document.getElementById('additionalCount').value;
		additionalCount--;
		if (additionalCount < 0) {
			return;
		}
		document.getElementById('additionalCount').value = additionalCount;
		document.getElementById('additionalCountDisplay').value = additionalCount + ' 마리';

		const additionalFee = document.getElementById('additionalFee').value;
		document.getElementById('additionalCountTotal').innerHTML = additionalCount * additionalFee + ' 원';
		setTotalPrice();
	};

	const onChangeImageClick = function (fileKey) {
		document.getElementById('mainIntroImage').setAttribute('src', '/files/' + fileKey + '/downloads');
	};

	const onRequestCareButtonClick = function () {
		const caretakerKey = document.getElementById('caretakerKey');
		const selectPetModal = document.getElementById('selectPetModal');
		selectPetModal.style.display = "block";

		const getPetObject = function (element) {
			const petName = element.id;
			const petKey = element.value;
			return {
				petKey: petKey,
				petName: petName
			}
		};

		const getMonthByFromString = function (str) {
			const mapping = {
				'Jan': 1,
				'Feb': 2,
				'Mar': 3,
				'Apr': 4,
				'May': 5,
				'Jun': 6,
				'Jul': 7,
				'Aug': 8,
				'Sep': 9,
				'Oct': 10,
				'Nov': 11,
				'Dec': 12
			};

			return mapping[str];
		}

		const okCallback = function () {
			let selectedPet = [];
			let pets = document.getElementsByClassName('pets');
			if (pets && pets.length > 0) {
				for (let i = 0; i < pets.length; i++) {
					if (pets[i].checked) {
						selectedPet.push(getPetObject(pets[i]));
					}
				}
			}
			if (selectedPet && selectedPet.length > 0) {
				const caretakerKey = document.getElementById('caretakerKey').value;

				const feePerNight = document.getElementById('feePerNight').value;
				const dayCount = document.getElementById('dayCount').value;
				const additionalCount = document.getElementById('additionalCount').value;
				const additionalFee = document.getElementById('additionalFee').value;
				let startAt = document.getElementById('startAt').innerHTML;
				if (!startAt) {
					alert('맡기실 날짜를 선택 해주세요');
					return;
				}
				//YYYY-MM-DD HH:mm:ss
				const splits = startAt.split(" ");
				console.log("DEBUG CHECK SPLIT :", splits);
				startAt = splits[3] + '-' + getMonthByFromString(splits[1]) + '-' + splits[2] + ' ' + splits[4];

				if ((parseInt(additionalCount) + 1) !== selectedPet.length) {
					alert('설정한 옵션에 따라 맡기실 반려견 수를 선택 해주세요');
					return;
				}

				const requestBody = {
					caretakerKey: caretakerKey,
					day: dayCount,
					price: ((feePerNight * dayCount) + (additionalCount * additionalFee)),
					petDetails: selectedPet,
					startAt: startAt,
					careDetails: selectedPet
				};
				console.log("DEBUG CHECK PARAM :", requestBody);

				const xhr = new XMLHttpRequest();
				xhr.open("POST", "/care");
				xhr.setRequestHeader('Content-Type', 'application/json');
				xhr.onreadystatechange = function () {
					if (xhr.readyState === 4 && xhr.status === 200) {
						let response = JSON.parse(xhr.responseText);
						if (response.status) {
							displayAlertModal(true, '요청 성공하였습니다');
							afterSuccessThenRefresh();
						} else {
							displayAlertModal(false, '요청 실패하였습니다');
						}
					}
				};
				xhr.send(JSON.stringify(requestBody));

			} else {
				alert("맡기실 반려동물을 선택해주세요");
			}
		};

		const selectPetOkButton = document.getElementById('selectPetOkButton');
		selectPetOkButton.onclick = function () {
			okCallback();
		};

		const selectPetDeleteButton = document.getElementById('selectPetDeleteButton');
		selectPetDeleteButton.onclick = function () {
			selectPetModal.style.display = "none";
		}
	};

	return {
		'onRequestCareButtonClick': onRequestCareButtonClick,
		'onChangeImageClick': onChangeImageClick
	}
})();

const onRequestCareButtonClick = moduleCaretakerDetail.onRequestCareButtonClick;
const onChangeImageClick = moduleCaretakerDetail.onChangeImageClick;


const reviewModule = (function () {
	'use strict';

	const slider_rating = document.getElementById('slider_rating');
	if (slider_rating) {
		noUiSlider.create(slider_rating, {
			start: 1,
			behaviour: 'snap',
			connect: [true, false],
			tooltips: [true],
			range: {
				'min': 1,
				'max': 10
			}
		});
	}

	const addReviewButtonClick = function () {
		const score = slider_rating.noUiSlider.get();
		const comment = document.getElementById('comment').value;
		const careKey = document.getElementById('care').value;
		if (!careKey || careKey === null || careKey === 'null') {
			document.getElementById('care').focus();
			alert("이용하신 서비스를 선택 해주세요");
			return;
		}

		const requestBody = {
			score: score,
			comment: comment,
			careKey: careKey,
		};
		console.log("DEBUG CHECK PARAM :", requestBody);

		const xhr = new XMLHttpRequest();
		xhr.open("POST", "/care/" + careKey + "/review");
		xhr.setRequestHeader('Content-Type', 'application/json');
		xhr.onreadystatechange = function () {
			if (xhr.readyState === 4 && xhr.status === 200) {
				let response = JSON.parse(xhr.responseText);
				if (response.status) {
					displayAlertModal(true, '요청 성공하였습니다');
					afterSuccessThenRefresh();
				} else {
					displayAlertModal(false, '요청 실패하였습니다');
				}
			}
		};
		xhr.send(JSON.stringify(requestBody));
	};

	return {
		'addReviewButtonClick': addReviewButtonClick
	}
})();

const addReviewButtonClick = reviewModule.addReviewButtonClick;