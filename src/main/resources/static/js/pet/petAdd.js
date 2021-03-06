/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-16
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

const onAddPetButtonClick = function () {
	const petName = document.getElementById('petName').value;
	const birth = document.getElementById('birth').value;
	const petType = document.getElementById('petType').value;
	const genders = document.getElementsByName('gender');
	const neutralizings = document.getElementsByName('neutralizings');
	const barking = slider_barking.noUiSlider.get();
	const marking = slider_marking.noUiSlider.get();
	const mounting = slider_mounting.noUiSlider.get();
	const aggression = slider_aggression.noUiSlider.get();
	const size = slider_size.noUiSlider.get();
	const isValidate = function () {
		if (!petName) {
			document.getElementById('petName').focus();
			return false;
		}
		if (!birth) {
			document.getElementById('birth').focus();
			return false;
		}
		return !(!petType || petType === null || petType === 'null');
	}();

	if (!isValidate) {
		alert("유효하지 않은 데이터가 있습니다");
		return false;
	}

	let gender;
	for (let i = 0; i < genders.length; i++) {
		if (genders[i].checked) {
			gender = genders[i].value;
		}
	}
	if (gender === 'true') {
		gender = 'MEN';
	} else {
		gender = 'WOMEN';
	}

	let neutralizing;
	for (let i = 0; i < neutralizings.length; i++) {
		if (neutralizings[i].checked) {
			neutralizing = neutralizings[i].value;
		}
	}

	let age;
	if (birth) {
		const birthYear = birth.substr(0, 4);
		const nowYear = new Date().getFullYear();
		age = nowYear - birthYear;
	}

	const uploadFiles = function (profileFiles) {
		const formData = new FormData();
		formData.append('fileType', 'PET_PROFILE');

		let count = 0;
		for (let i = 0; i < profileFiles.length; i++) {
			const file = profileFiles[i].files[0];
			if (file) {
				count++;
				formData.append('files', file);
			}
		}

		if (!count) {
			addPet(null);
			return;
		}

		const xhr = new XMLHttpRequest();
		// xhr.setRequestHeader()
		xhr.open("POST", "/files");
		xhr.onreadystatechange = function () {
			if (xhr.readyState === 4 && xhr.status === 200) {
				addPet(JSON.parse(xhr.responseText)); // Another callback here
			}
		};
		xhr.send(formData);

	};

	const addPet = function (response) {
		addedFiles = [];
		if (response) {
			let files = response.result;
			console.log("FIELS:", files);
			for (let i = 0; i < files.length; i++) {
				addedFiles[i] = {fileKey: files[i].fileKey};
			}
		}

		const requestBody = {
			'petName': petName,
			'petTypeKey': petType,
			'birth': birth,
			'gender': gender,
			'neutralizing': neutralizing,
			'barking': barking,
			'marking': marking,
			'mounting': mounting,
			'aggression': aggression,
			'size': size,
			'age': age,
			'addedFiles': addedFiles,
		};

		const xhr = new XMLHttpRequest();
		// xhr.setRequestHeader()
		xhr.open("POST", "/pets");
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

	const profileFiles = document.getElementsByClassName('files');
	if (profileFiles && profileFiles.length > 0) {
		uploadFiles(profileFiles);
	} else {
		addPet();
	}
};