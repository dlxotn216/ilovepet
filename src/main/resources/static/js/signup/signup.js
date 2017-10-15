/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-13
 */

const signupButton = document.getElementById('btn-signup');
signupButton.onclick = function () {
    const userType = document.getElementById('userType').value;

    const userId = document.getElementById('userId').value;
    const password = document.getElementById('password').value;
    const password2 = document.getElementById('password2').value;
    const userName = document.getElementById('userName').value;
    const email = document.getElementById('email').value;
    const phone = document.getElementById('phone').value;
    const birth = document.getElementById('birth').value;
    const profileFileValue = document.getElementById('profileFile').value;
    const genders = document.getElementsByName('gender');
    const isValidate = function() {
        if (!userId) {
            console.log("userId: ", userId);
            document.getElementById('userId').focus();
            return false;
        }
        if (!password || !password2 || password != password2) {
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
        if (!genders || genders.length == 0) {
            console.log("genders: ", genders, '_',genders.length);
            return false;
        }
        return true;
    }();

    if(!isValidate){
        alert("유효하지 않은 데이터가 있습니다");
        return false;
    }

    var gender;
    for (var i = 0; i < genders.length; i++) {
        if (genders[i].checked) {
            gender = genders[i].getAttribute('id');
        }
    }

    var age;
    if (birth) {
        const birthYear = birth.substr(0, 4);
        const nowYear = new Date().getFullYear();
        age = nowYear - birthYear;
    }

    const uploadFile = function(){
        const file = document.getElementById('profileFile').files[0];
        console.log("DEBUG CHECK PROFIL EFILE :", file);

        const formData = new FormData();
        formData.append('file', file);
        formData.append('fileType', 'USER_PROFILE');

        var xhr = new XMLHttpRequest();
        // xhr.setRequestHeader()
        xhr.open("POST", "/files");
        xhr.onreadystatechange = function(){
            if (xhr.readyState === 4 && xhr.status === 200)
            {
                addUser(xhr.responseText); // Another callback here
            }
        };
        xhr.send(formData);
    };

    const addUser = function(file){
        if(file){
            console.log("FIEL:", file);
        }
        const requestBody = {
            'roleName': userType,
            'userId': userId,
            'password': password,
            'userName': userName,
            'email': email,
            'phone': phone,
            'age': age,
            'gender': gender
        };
        console.log("DEBUG CHECK REQU BODY :", requestBody);
        const xhr = new XMLHttpRequest();
        xhr.open("POST", "/users");
        xhr.setRequestHeader('Content-Type', 'application/json');
        xhr.onreadystatechange = function(){
            if (xhr.readyState === 4 && xhr.status === 200)
            {
                console.log(xhr.responseText);
            }
        };
        xhr.send(JSON.stringify(requestBody));
        // $.ajax({
        //     type: 'POST',
        //     uri: '/users',
        //     data: requestBody,
        //     dataType: 'application/json',
        //     success: function(res){
        //         console.log(res);
        //     }
        // });
    };

    if(profileFileValue){
        uploadFile();
    } else {
        addUser(null);
    }

};
