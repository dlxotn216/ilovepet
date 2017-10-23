/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-23
 */

const onSelectPetClick = function(petKey){
	const redirectUrl = document.getElementById('redirectUrl').value;
	if(redirectUrl){
		window.location.href=redirectUrl+'?selectedPetKey='+petKey;
	}
};