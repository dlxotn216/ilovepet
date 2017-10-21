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

onChangeImageClick = function(fileKey){
    document.getElementById('mainIntroImage').setAttribute('src', '/files/'+fileKey+'/downloads');
}