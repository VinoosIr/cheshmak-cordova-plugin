var exec = require('cordova/exec');
module.exports = {
    initialize: function(appKey) {
        cordova.exec(
			function (result) {
				console.log('Cheshmak initialize success.');
			},
			null,
            'CheshmakCordova',
            'initialize',
            [appKey]
        ); 
    },
    getCheshmakID: function(success, error) {
        cordova.exec(
			success,
			error,
            'CheshmakCordova',
            'getCheshmakID',
            []
        ); 
    },
    addTag: function(tagName) {
        cordova.exec(
			function (result) {
				console.log('AddTag Success.');
			},
			null,
            'CheshmakCordova',
            'addTag',
            [tagName]
        ); 
    },
    deleteTag: function(tagName) {
        cordova.exec(
			function (result) {
				console.log('DeleteTag Success.');
			},
			null,
            'CheshmakCordova',
            'deleteTag',
            [tagName]
        ); 
    },
    deleteAllTags: function() {
        cordova.exec(
			function (result) {
				console.log('DeleteAllTags Success.');
			},
			null,
            'CheshmakCordova',
            'deleteAllTags',
            []
        ); 
    },
    startView: function() {
        cordova.exec(
			function (result) {
				console.log('StartView Success.');
			},
			null,
            'CheshmakCordova',
            'startView',
            []
        ); 
    },
    stopView: function() {
        cordova.exec(
			function (result) {
				console.log('StopView Success.');
			},
			null,
            'CheshmakCordova',
            'stopView',
            []
        ); 
    },
    trackEvent: function(eventName) {
        cordova.exec(
			function (result) {
				console.log('TrackEvent Success.');
			},
			null,
            'CheshmakCordova',
            'trackEvent',
            [eventName]
        ); 
    },
    getData: function(success) {
        cordova.exec(
			success,
			null,
            'CheshmakCordova',
            'getData',
            []
        ); 
    }
};