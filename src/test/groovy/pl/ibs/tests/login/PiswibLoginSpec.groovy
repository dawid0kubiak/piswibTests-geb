package pl.ibs.tests.login


import geb.spock.GebSpec
import pl.ibs.pages.login.PiswibLoginPage

import static pl.ibs.resource.DataLogin.*


class PiswibLoginSpec extends GebSpec {

    def setupSpec() {
        to PiswibLoginPage
        login()
    }

    def "login negative"() {

        when:
        to PiswibLoginPage

        and:
        input_login << good_login
        input_password << bad_password
        button_submit.click()

        then:
        println "login negative"
        assert message_error.text() == "Zły login lub hasło."
    }

    def "login positive"() {

        when:
        to PiswibLoginPage

        and:
        input_login << good_login
        input_password << good_password
        button_submit.click()

        then:
        println "login positive"
        assert $("#loginLabel").text() == good_login
        $("#authTopForm\\:logoutButton").click()
        assert $("#loginMessage")
    }

    def "login positive 1"() {

        when:
        to PiswibLoginPage
      println  page.title
        and:
        input_login << good_login
        input_password << good_password
        button_submit.click()

        then:
        println "login positive"
        assert $("#loginLabel").text() == good_login
        $("#authTopForm\\:logoutButton").click()
        assert $("#loginMessage")
    }


    def cleanupSpec() {
        println "logout"
    }
}
