/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-18
 */


const displayDeleteConfirmModal = function(okCallback){
	const deleteModal = document.getElementById('confirmDeleteModal');
	deleteModal.style.display = "block";

	const deleteOkButton = document.getElementById('deleteOkButton');
	deleteOkButton.onclick = function (){
		okCallback();
	};

	const deleteCloseButton = document.getElementById('deleteCloseButton');
	deleteCloseButton.onclick = function () {
		deleteModal.style.display = "none";
	}
};

const closeDeleteConfirmModal = function(){
	const deleteModal = document.getElementById('confirmDeleteModal');
	deleteModal.style.display = "none";
};

const displayAlertModal = function (isSuccess, content){
	const alertModal = document.getElementById('alertModal');
	const alertModalFooter = document.getElementById('alertModalFooter');
	console.log("DEBUG CHECK ALERT :", isSuccess);
	if(isSuccess){
		alertModalFooter.classList.add('alert-modal-footer-success');
	} else {
		alertModalFooter.classList.add('alert-modal-footer-error');
	}
	const alertMoralContent = document.getElementById('alertModalContent');
	alertMoralContent.innerHTML = content;
	alertModal.style.display = "block";

	const closeAlertModal = function(isSuccess){
		const alertModal = document.getElementById('alertModal');
		const alertModalFooter = document.getElementById('alertModalFooter');
		if(isSuccess){
			alertModalFooter.classList.remove('alert-modal-footer-success');
		} else {
			alertModalFooter.classList.remove('alert-modal-footer-error');
		}
		const alertMoralContent = document.getElementById('alertModalContent');
		alertMoralContent.innerHTML = '';
		alertModal.style.display = "none";
	};
	setTimeout(function(){ closeAlertModal(); }, 2000);
};

const afterSuccess = function(){
	setTimeout(function(){ window.history.back(); }, 2000);
};

const afterSuccessThenRefresh = function(){
	setTimeout(function(){ location.reload(); }, 2000);
}