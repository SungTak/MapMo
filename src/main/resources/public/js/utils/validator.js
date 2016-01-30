/**
 * 데이터 검증을 담당
 * 필수 : 반드시 constants.js를 함께 include 해야합니다.
 */
function Validator() {
	if (!(this instanceof arguments.callee)) {
		return new Validator();
	}
}
Validator.prototype.checkId = function(id) {
	if (id.length == 0) {
		return constants.user.ID_EMPTY;
	}
	
	// id는 영문, 숫자로만 구성이 가능하다.
	var sCheckId = /[^A-Za-z0-9]/;
	if (sCheckId.test(id)) {
		return constants.user.ID_INVALID;
	}
	return constants.user.ID_VALID;
}
Validator.prototype.checkPassword = function(password) {
	if (password.length == 0) {
		alert("비밀번호를 입력하세요");
		return false;
	}
	
	var sCheckPassword = /[^A-Za-z0-9!@#$%^&*()]/;
	if (sCheckPassword.test(password)) {
		alert("영문, 숫자, 특수문자만 비밀번호가 가능합니다.");
		return false;
	}
	
	var sCheckSpecial = /[!@#$%^&*()]/;
	if (sCheckSpecial.test(password) == false) {
		alert("비밀번호에 특수문자가 포함되어야 합니다.");
		return false;
	}
	
	var sCheckAlphabet = /[A-Za-z]/;
	if (sCheckAlphabet.test(password) == false) {
		alert("비밀번호에 영문자가 포함되어야합니다.");
		return false;
	}
	
	var sCheckNumber = /[0-9]/;
	if (sCheckNumber.test(password) == false) {
		alert("비밀번호에 숫자가 포함되어합니다.");
		return false;
	}
	return true;
}