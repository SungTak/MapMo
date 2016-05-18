var MapMo = MapMo || {};

/**
 * 유저 정보에 대한 이벤트 등록/해제를 담당합니다. 
 */
MapMo.UserEventHandler = function() {
	if (!(this instanceof arguments.callee)) {
		return new MapMo.UserEventHandler();
	}
}
/**
 * jQuery를 사용하여 이름으로 유저 정보를 수정할 수 있도록 이벤트를 등록한다.
 * 
 * @param $target 클릭을 발생시킬 jQuery의 selector
 * @param sEvent 이벤트 이름
 * @param oUser 유저 객체(MapMo.User)
 */
MapMo.UserEventHandler.prototype.modifyByName = function($target, sEvent, oUser) {
	var result = {
		"message" : "비어 있습니다!",
		"isValid" : false
	};
	
	if (jQuery.type($target) != "object") {
		result.message = "target이 비었습니다!";
		return result;
	}
	
	if ((oUser instanceof MapMo.User) === false) {
		result.message = "유저 객체 타입이 올바르지 않습니다!";
		return result;
	}
	
	$target.on(sEvent, { "user" : oUser	}, oUser.modifyByName);
}