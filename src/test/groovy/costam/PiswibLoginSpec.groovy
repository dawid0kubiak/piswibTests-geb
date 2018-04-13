package costam

import geb.spock.GebSpec

class PiswibLoginSpec extends GebSpec {



    def "login negative"() {

        when:
        to PiswibLoginPage

        and:
        input_login << "admin"
        input_password << "bad"
        button_submit.click()

        then:
        assert $("div#loginMessage span.ui-messages-error-summary").text() == "Zły login lub hasło."
    }

    def "login positive"() {

        when:
        to PiswibLoginPage

        and:
        input_login << "admin"
        input_password << "admin"
        button_submit.click()

        then:
        assert $("#loginLabel").text() == "admin"
    }
}
