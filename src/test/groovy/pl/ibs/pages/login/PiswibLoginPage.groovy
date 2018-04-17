package pl.ibs.pages.login

import geb.Page

class PiswibLoginPage extends Page {
    static at = { title == "PI SWIB" }

    static content = {
        input_login { $("#loginform\\:login") }
        input_password { $("#loginform\\:password") }
        button_submit { $("#loginform\\:submita") }
        message_error { $("div#loginMessage span.ui-messages-error-summary") }
    }
}
