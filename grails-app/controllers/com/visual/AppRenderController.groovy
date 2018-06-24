package com.visual

import grails.io.IOUtils

class AppRenderController {

    final String htmlContent = IOUtils.toString(this.getClass().getClassLoader().getResourceAsStream("public/index.html"))

    def index() {
        render text: htmlContent, contentType: "text/html", encoding: "UTF-8"
    }
}
