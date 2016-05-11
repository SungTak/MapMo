// namespace
var MapMo = MapMo || {};

/**
 * 유저 정보 조회, 수정 등을 담당하는 객체
 */
MapMo.User = function() {
	if (!(this instanceof arguments.callee)) {
		return new MapMo.User();
	}
	
	// 폼 객체, 수정 요청시 해당 폼으로 submit
	this.oForm = null;	
	// 유저 이름
	this.sName = "";
}
/**
 * 전달된 form을 사용하여 유저 정보 수정 페이지로 submit합니다.
 * 이름으로 데이터를 찾아 수정하기 때문에 모델 객체의 name 프로퍼티에 값이 있어야합니다.
 *  
 * @param event 객체
 */
MapMo.User.prototype.modifyByName = function(event) {
	if (this.sName.length == 0) {
		return {
			"message" : "유저 이름이 존재하지 않습니다!",
			"isValid" : false
		};
	}
	
	event.defaultPrevent();
	
	var userName = jQuery("<input>").attr("type", "hidden").attr("name", "user.name").val(this.sName);
	
	this.form.action = "/modify/user";
	this.form.method = "post";
	this.form.sumbit();
}
MapMo.User.prototype.setName = function(sName) {
	this.sName = sName;
}
MapMo.User.prototype.setForm = function(oForm) {
	this.oForm = oForm;
}