/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-17
 */

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

const onChange = function (id) {
	const fileNameId = 'fileName' + id;
	const imageId = 'image' + id;
	const imageInputId = 'imageInput' + id;

	const input = document.getElementById(imageInputId);

	if (input.files && input.files[0]) {
		const reader = new FileReader();
		const fileNameInput = document.getElementById(fileNameId);
		fileNameInput.value = input.value;
		reader.onload = function (e) {
			const resultSrc = e.target.result;
			document.getElementById(imageId).setAttribute('src', resultSrc);
		};

		reader.readAsDataURL(input.files[0]);
	}
};


onTabClick = function(btn, tabId){
	let buttons = document.getElementsByClassName('tab-btn ');
	if(buttons && buttons.length > 0){
		for(let i=0; i<buttons.length; i++){
			buttons[i].classList.remove('btn-primary');
			buttons[i].classList.add('btn-default');
		}
	}
	btn.classList.remove( 'btn-default' );
	btn.classList.add( 'btn-primary' );

	let tab = document.getElementById(tabId);
	let tabs = document.getElementsByClassName('tab-pane');

	if(tabs && tabs.length > 0){
		for(let i=0; i<tabs.length; i++){
			tabs[i].classList.remove('active');
		}
	}

	tab.classList.add( 'active' );
};

const onPetUpdateButtonClick = function(petKey){
	window.location.href='/pet/'+petKey+'/update';
};