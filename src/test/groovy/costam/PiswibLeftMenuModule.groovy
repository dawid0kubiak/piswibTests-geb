package costam

import geb.Module

class PiswibLeftMenuModule extends Module {
    static content = {
        ognivo { $("#menu-group-applicationmenuognivo") }

    }

    void open() {
        ognivo.click()
        waitFor { !linksContainer.hasClass("animating") }
    }
}
