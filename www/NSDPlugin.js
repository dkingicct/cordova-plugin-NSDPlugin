var exec = require('cordova/exec');

exports.NsdPlugin = {
    registerService: function(arg0, success, error) {
        exec(success, error, "NSDPlugin", "registerService", [arg0]);
    },

    discoverServices: function(arg0, success, error) {
            exec(success, error, "NSDPlugin", "discoverServices", [arg0]);
    },

    getChosenServiceInfo: function(arg0, success, error) {
        exec(success, error, "NSDPlugin", "getChosenServiceInfo", [arg0]);
    },

    stopDiscovery: function(arg0, success, error) {
        exec(success, error, "NSDPlugin", "stopDiscovery", [arg0]);
    },

    tearDown: function(arg0, success, error) {
        exec(success, error, "NSDPlugin", "tearDown", [arg0]);
    }
}
