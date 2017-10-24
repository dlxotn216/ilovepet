/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-19
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

const getImageFormNode = function (id) {
	const fileNameId = 'fileName' + id;
	const imageId = 'image' + id;
	const imageInputId = 'imageInput' + id;

	const node =
		`<div class="form-group row">
			<label class="col-md-2">Upload Image</label>
			<div class="col-md-6">
				<div class="input-group">
					<span class="input-group-btn">
						<span class="btn btn-default btn-file">
							Browse… <input type="file"
										id=` + imageInputId + `
										class="files"
										onchange="onChange(` + id + `)"/>
						</span>
					</span>
					<input type="text" id=` + fileNameId + ` class="form-control" readonly="readonly"/>
				</div>
			</div>
			<div class="col-md-3">
				<div class="thumbnail">
					<img id=` + imageId + ` style="width: 100%"/>
				</div>
			</div>
			<div class="col-md-1">
				<button type="button" id=` + id + ` onclick="onImageFormMinusClick(` + id + `)" class="btn btn-primary"><span class="glyphicon glyphicon-minus"></span>
				</button>
			</div>
		</div>`;

	return node;
};

const onImageFormAddClick = function (element) {
	const parent = document.getElementById('image-form-wrap');
	const id = document.getElementById('imageFormId').value + 1;
	document.getElementById('imageFormId').value = id;

	const node = getImageFormNode(id);
	const div = document.createElement('div');
	const formGroupId = 'formGroup' + id;
	div.setAttribute('id', formGroupId);
	div.innerHTML = node;

	parent.appendChild(div);
};

const onImageFormMinusClick = function (id) {
	const parent = document.getElementById('image-form-wrap');
	const formGroupId = 'formGroup' + id;
	const current = document.getElementById(formGroupId);

	console.log("DEBUG CHECK parent : ", parent);
	console.log("DEBUG CHECK CURRENT : ", current, id);

	parent.removeChild(current);
};

onAddCaretakerButtonClick = function (userKey) {
	const petCount = document.getElementById('petCount').value;
	const title = document.getElementById('title').value;
	const summary = document.getElementById('summary').value;
	const feePerNight = document.getElementById('feePerNight').value;
	const additionalFee = document.getElementById('additionalFee').value;
	const checkInTime = parseInt(document.getElementById('checkInTime').value);
	const checkInMinute = parseInt(document.getElementById('checkInMinute').value);
	const checkOutTime = parseInt(document.getElementById('checkOutTime').value);
	const checkOutMinute = parseInt(document.getElementById('checkOutMinute').value);
	const yards = document.getElementsByName('yard');
	const liveWithFamilys = document.getElementsByName('liveWithFamily');
	const hasYoungChildrens = document.getElementsByName('hasYoungChildren');
	const pickups = document.getElementsByName('pickup');

	const barking = slider_barking.noUiSlider.get();
	const marking = slider_marking.noUiSlider.get();
	const mounting = slider_mounting.noUiSlider.get();
	const aggression = slider_aggression.noUiSlider.get();
	const size = slider_size.noUiSlider.get();

	const isValidate = function () {
		if (!petCount) {
			document.getElementById('petCount').focus();
			return false;
		}
		if (!title) {
			document.getElementById('title').focus();
			return false;
		}
		if (!summary) {
			document.getElementById('summary').focus();
			return false;
		}
		if (!feePerNight) {
			document.getElementById('feePerNight').focus();
			return false;
		}
		if (!additionalFee) {
			document.getElementById('additionalFee').focus();
			return false;
		}

		if (checkInTime < 0 || checkInMinute < 0 || checkOutTime < 0 || checkOutMinute < 0) {
			document.getElementById('checkInTime').focus();
			return false;
		}

		if (checkInTime > checkOutTime || (checkInTime === checkOutTime && checkInMinute > checkOutMinute)) {
			document.getElementById('checkInTime').focus();
			return false;
		}
		return true;
	}();

	if (!isValidate) {
		alert("유효하지 않은 데이터가 있습니다");
		return false;
	}

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

	const updateCaretaker = function (response) {
		addedFiles = [];
		if (response) {
			let files = response.result;
			console.log("FIELS:", files);
			for (let i = 0; i < files.length; i++) {
				addedFiles[i] = {fileKey: files[i].fileKey};
			}
		}

		const requestBody = {
			'userKey': userKey,
			'petCount': petCount,
			'title': title,
			'summary': summary,
			'feePerNight': feePerNight,
			'additionalFee': additionalFee,
			'checkIn': checkInTime + ":" + checkInMinute,
			'checkOut': checkOutTime + ":" + checkOutMinute,
			'yard': yard,
			'liveWithFamily': liveWithFamily,
			'hasYoungChildren': hasYoungChildren,
			'pickup': pickup,
			'addedFiles': addedFiles,
			'barking': barking,
			'marking': marking,
			'mounting': mounting,
			'aggression': aggression,
			'size': size,
		};

		const xhr = new XMLHttpRequest();
		xhr.open("POST", "/users/" + userKey + "/caretakers");
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
	};

	const uploadIntroFiles = function (introFiles) {
		const formData = new FormData();
		formData.append('fileType', 'CARETAKER_INTRO');

		let count = 0;
		for (let i = 0; i < introFiles.length; i++) {
			const file = introFiles[i].files[0];
			if (file) {
				count++;
				formData.append('files', file);
			}
		}

		if (!count) {
			updateCaretaker(null);
			return;
		}

		const xhr = new XMLHttpRequest();
		// xhr.setRequestHeader()
		xhr.open("POST", "/files");
		xhr.onreadystatechange = function () {
			if (xhr.readyState === 4 && xhr.status === 200) {
				updateCaretaker(JSON.parse(xhr.responseText)); // Another callback here
			}
		};
		xhr.send(formData);
	};

	const introFiles = document.getElementsByClassName('files');
	if (introFiles && introFiles.length > 0) {
		uploadIntroFiles(introFiles);
	} else {
		updateCaretaker(null);
	}
};