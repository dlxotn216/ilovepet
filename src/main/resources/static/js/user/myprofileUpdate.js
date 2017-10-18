/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-18
 */

const updateButton = document.getElementById('btn-update');
updateButton.onclick = function () {
	const userId = document.getElementById('userId').value;
	const password = document.getElementById('password').value;
	const password2 = document.getElementById('password2').value;
	const userName = document.getElementById('userName').value;
	const email = document.getElementById('email').value;
	const phone = document.getElementById('phone').value;
	const birth = document.getElementById('birth').value;
	const profileFileValue = document.getElementById('profileFile').value;
	const genders = document.getElementsByName('gender');
	const isValidate = function () {
		if (!userId) {
			console.log("userId: ", userId);
			document.getElementById('userId').focus();
			return false;
		}
		if (password !== password2) {
			console.log("password: ", password);
			console.log("password2: ", password2);
			document.getElementById('password').focus();
			return false;
		}
		if (!userName) {
			console.log("userName: ", userName);
			document.getElementById('userName').focus();
			return false;
		}
		if (!email) {
			console.log("email: ", email);
			document.getElementById('email').focus();
			return false;
		}
		if (!phone) {
			console.log("phone: ", phone);
			document.getElementById('phone').focus();
			return false;
		}
		if (!birth) {
			console.log("birth: ", birth);
			document.getElementById('birth').focus();
			return false;
		}
		if (!genders || genders.length === 0) {
			console.log("genders: ", genders, '_', genders.length);
			return false;
		}
		return true;
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

	const uploadFile = function () {
		const file = document.getElementById('profileFile').files[0];
		console.log("DEBUG CHECK PROFIL EFILE :", file);

		const formData = new FormData();
		formData.append('files', file);
		formData.append('fileType', 'USER_PROFILE');

		const xhr = new XMLHttpRequest();
		// xhr.setRequestHeader()
		xhr.open("POST", "/files");
		xhr.onreadystatechange = function () {
			if (xhr.readyState === 4 && xhr.status === 200) {
				updateUser(JSON.parse(xhr.responseText)); // Another callback here
			}
		};
		xhr.send(formData);
	};

	const updateUser = function (response) {
		let fileKey = null;
		if (response) {
			let addedFiles = response.result;
			fileKey = addedFiles[0].fileKey;
		}
		//기존 프로필 파일
		const profileFileKey = document.getElementById('profileFileKey').value;
		const requestBody = {
			'userId': userId,
			'password': password,
			'userName': userName,
			'updatedProfileFileKey': fileKey,
			'profileFileKey': profileFileKey,
			'email': email,
			'phone': phone,
			'birth': birth,
			'gender': gender
		};

		const xhr = new XMLHttpRequest();
		const userKey = document.getElementById("userKey").value;
		xhr.open("PUT", "/users/" + userKey);
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

	if (profileFileValue) {
		uploadFile();
	} else {
		updateUser(null);
	}
}
