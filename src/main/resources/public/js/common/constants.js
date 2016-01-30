/**
 * 상수화 리터럴 객체 관리
 */
constants = window.constants || {};

constants.user = {
	ID_EMPTY : "ID_EMPTY",
	ID_INVALID : "ID_INVALID",
	ID_VALID : "ID_VALID"
};

// 객체 내 데이터 보호
(function() {
	Object.freeze(constants.user);
})();