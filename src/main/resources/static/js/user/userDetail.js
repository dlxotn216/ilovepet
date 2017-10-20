/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-20
 */

window.addEventListener('load', function () {
	vanillacalendar.init();
})

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