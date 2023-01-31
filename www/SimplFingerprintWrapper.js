var exec = require('cordova/exec');

var simpl = {};

simpl.generateFingerprint = function(merchantId, phoneNumber, email, successCallback, errorCallback) {
    cordova.exec(successCallback, errorCallback, "SimplFingerprintWrapper", "generateFingerprint", [merchantId, phoneNumber, email]);
};

simpl.OnCheckPermission = function(merchantId="0", phoneNumber="0", email="0", successCallback, errorCallback) {
    cordova.exec(successCallback, errorCallback, "SimplFingerprintWrapper", "generateFingerprint", [merchantId, phoneNumber, email]);
};

simpl.openScanner = function(merchantId="0", phoneNumber="0", email="0", successCallback, errorCallback) {
    cordova.exec(successCallback, errorCallback, "SimplFingerprintWrapper", "generateFingerprint", [merchantId, phoneNumber, email]);
};

module.exports = simpl;
