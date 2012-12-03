package ajaxtools

import grails.converters.JSON

class AJAXResponseContainer {
    Boolean success = false
    List data = []
    List messages = []
        
    def addData(item) {
        if(data.add(item)) {
            return true
        } else {
            return false
        }
    }
    
    def addMessage(String message) {
        if(messages.add(message)) {
            return true
        } else {
            return false
        }
    }
    
    def success() {
        success = true
        return true;
    }
    
    def failure() {
        success = false
        return true;
    }
    
}

