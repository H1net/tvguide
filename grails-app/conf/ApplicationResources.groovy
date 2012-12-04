modules = {
    application {
        dependsOn 'jquery'
        resource url:'js/application.js'
        resource url:'css/main.css' 
        resource url:'css/errors.css'
        resource url:'css/mobile.css'
    }
    login {
        resource url:'css/login.css'
    }
    tvShowManage {
        resource url:'js/tvShowManage.js'
    }
}