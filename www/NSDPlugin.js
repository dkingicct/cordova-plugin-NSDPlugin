var exec = require('cordova/exec');

module.exports = {
    initializedNsd: function(arg0, success, error) {
        console.log("initializedNsd Called!");
        exec(success, error, "NSDPlugin", "initializeNsd", [arg0]);
    }
};

// NetworkServiceDiscovery.registerService = function(arg0, success, error) {
//     exec(success, error, "NSDPlugin", "registerService", [arg0]);
// };
//
// NetworkServiceDiscovery.discoverServices = function(arg0, success, error) {
//     exec(success, error, "NSDPlugin", "discoverServices", [arg0]);
// };
//
// NetworkServiceDiscovery.getChosenServiceInfo = function(arg0, success, error) {
//     exec(success, error, "NSDPlugin", "getChosenServiceInfo", [arg0]);
// };
//
// NetworkServiceDiscovery.stopDiscovery = function(arg0, success, error) {
//     exec(success, error, "NSDPlugin", "stopDiscovery", [arg0]);
// };
//
// NetworkServiceDiscovery.tearDown = function(arg0, success, error) {
//     exec(success, error, "NSDPlugin", "tearDown", [arg0]);
// };
//
// NetworkServiceDiscovery.initializeNsd = function(arg0, success, error) {
//     console.log("initializedNsd Called!");
//     exec(success, error, "NSDPlugin", "initializeNsd", [arg0]);
// }

//module.exports = NetworkServiceDiscovery;
