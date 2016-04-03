var exec = require('cordova/exec');

var NetworkServiceDiscovery = function() {

};

NetworkServiceDiscovery.registerService = function(arg0, success, error) {
    exec(success, error, "NSDPlugin", "registerService", [arg0]);
};

NetworkServiceDiscovery.discoverServices = function(arg0, success, error) {
    exec(success, error, "NSDPlugin", "discoverServices", [arg0]);
};

NetworkServiceDiscovery.getChosenServiceInfo = function(arg0, success, error) {
    exec(success, error, "NSDPlugin", "getChosenServiceInfo", [arg0]);
};

NetworkServiceDiscovery.stopDiscovery = function(arg0, success, error) {
    exec(success, error, "NSDPlugin", "stopDiscovery", [arg0]);
};

NetworkServiceDiscovery.tearDown = function(arg0, success, error) {
    exec(success, error, "NSDPlugin", "tearDown", [arg0]);
};

module.exports = NetworkServiceDiscovery;
