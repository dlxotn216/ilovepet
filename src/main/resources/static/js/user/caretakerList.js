/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-23
 */

const onUserDetailClick = function(userKey){
	window.location.href = '/consigner/user/'+userKey+'/detail';
};


const onRecommendationRouteButtonClick = function(){
	window.location.href='/consigner/recommendation';
};