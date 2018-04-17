package pl.ibs.tests.login


import geb.spock.GebSpec
import pl.ibs.pages.login.PiswibLoginPage

import static pl.ibs.resource.DataLogin.*


class PiswibLoginSpec extends GebSpec {


    def "login negative"() {

        when:
        to PiswibLoginPage

        and:
        input_login << good_login
        input_password << bad_password
        button_submit.click()

        then:
        assert $("div#loginMessage span.ui-messages-error-summary").text() == "Zły login lub hasło."
    }

    def "login positive"() {

        when:
        to PiswibLoginPage

        and:
        input_login << good_login
        input_password << good_password
        button_submit.click()

        then:
        assert $("#loginLabel").text() == "admin"
        $("#authTopForm\\:logoutButton").click()
        assert $("#loginMessage")
    }
}
