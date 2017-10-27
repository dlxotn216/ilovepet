/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-27
 */

const resultModule = (function(){
	const onUserDetailClick = function(userKey){
		window.location.href = '/consigner/user/'+userKey+'/detail';
	};

	return {
		'onUserDetailClick': onUserDetailClick
	};
})();

const onUserDetailClick = resultModule.onUserDetailClick;