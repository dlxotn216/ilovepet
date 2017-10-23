/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-23
 */
const slider_barking = document.getElementById('slider-barking');
noUiSlider.create(slider_barking, {
	start: 10,
	behaviour: 'snap',
	connect: [true, false],
	tooltips: [true],
	range: {
		'min': 0,
		'max': 100
	}
});
const barkingValue = document.getElementById('barking').value;
slider_barking.noUiSlider.set(barkingValue);

const slider_marking = document.getElementById('slider-marking');
noUiSlider.create(slider_marking, {
	start: 10,
	behaviour: 'snap',
	connect: [true, false],
	tooltips: [true],
	range: {
		'min': 0,
		'max': 100
	}
});
const markingValue = document.getElementById('marking').value;
slider_marking.noUiSlider.set(markingValue);

const slider_mounting = document.getElementById('slider-mounting');
noUiSlider.create(slider_mounting, {
	start: 10,
	behaviour: 'snap',
	connect: [true, false],
	tooltips: [true],
	range: {
		'min': 0,
		'max': 100
	}
});
const mountingValue = document.getElementById('mounting').value;
slider_mounting.noUiSlider.set(mountingValue);

const slider_aggression = document.getElementById('slider-aggression');
noUiSlider.create(slider_aggression, {
	start: 10,
	behaviour: 'snap',
	connect: [true, false],
	tooltips: [true],
	range: {
		'min': 0,
		'max': 100
	}
});
const aggressionValue = document.getElementById('aggression').value;
slider_aggression.noUiSlider.set(aggressionValue);


const slider_size = document.getElementById('slider-size');
noUiSlider.create(slider_size, {
	start: 10,
	behaviour: 'snap',
	connect: [true, false],
	tooltips: [true],
	range: {
		'min': 0,
		'max': 100
	}
});
const sizeValue = document.getElementById('size').value;
slider_size.noUiSlider.set(sizeValue);

const onSelectMyPetButtonClick = function(){
	window.location.href='/consigner/recommendation/select-pet?redirect=/consigner/recommendation/not-enough';
};

const onRecommendationButtonClick = function(){
	let cityTypeKey = document.getElementById('cityType').value;
	if(!cityTypeKey || cityTypeKey === null || cityTypeKey === 'null'){
		alert("유효하지 않은 데이터가 존재합니다");
		return false;
	}

	let age;
	const birth = document.getElementById('birth').value;
	if (birth) {
		const birthYear = birth.substr(0, 4);
		const nowYear = new Date().getFullYear();
		age = nowYear - birthYear;
	} else {
		alert("유효하지 않은 데이터가 존재합니다");
		return false;
	}

	const genders = document.getElementsByName('gender');
	let gender;
	for (let i = 0; i < genders.length; i++) {
		if (genders[i].checked) {
			gender = genders[i].value;
		}
	}

	const barking = slider_barking.noUiSlider.get();
	const marking = slider_marking.noUiSlider.get();
	const mounting = slider_mounting.noUiSlider.get();
	const aggression = slider_aggression.noUiSlider.get();
	const size = slider_size.noUiSlider.get();
	const yards = document.getElementsByName('yard');
	const liveWithFamilys = document.getElementsByName('liveWithFamily');
	const hasYoungChildrens = document.getElementsByName('hasYoungChildren');
	const pickups = document.getElementsByName('pickup');

	let yard;
	for (let i = 0; i < yards.length; i++) {
		if (yards[i].checked) {
			yard = yards[i].value
		}
	}

	let liveWithFamily;
	for (let i = 0; i < liveWithFamilys.length; i++) {
		if (liveWithFamilys[i].checked) {
			liveWithFamily = liveWithFamilys[i].value
		}
	}

	let hasYoungChildren;
	for (let i = 0; i < hasYoungChildrens.length; i++) {
		if (hasYoungChildrens[i].checked) {
			hasYoungChildren = hasYoungChildrens[i].value
		}
	}

	let pickup;
	for (let i = 0; i < pickups.length; i++) {
		if (pickups[i].checked) {
			pickup = pickups[i].value
		}
	}

	const form = document.getElementById('recommendationForm')

	document.getElementById('barking').value = barking;
	document.getElementById('marking').value = marking;
	document.getElementById('mounting').value = mounting;
	document.getElementById('aggression').value = aggression;
	document.getElementById('size').value = size;
	document.getElementById('age').value = age;

	form.submit();
};