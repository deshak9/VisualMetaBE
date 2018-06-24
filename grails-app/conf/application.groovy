grails.plugin.emailAlert.onlySixWeeks = true
grails.plugin.springsecurity.useBasicAuth = true
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
        [pattern: '/**', access: "permitAll"]
]
grails.plugin.springsecurity.filterChain.chainMap = [
        [pattern: '/**/assets/**', filters: 'none'],
        [pattern: '/**/js/**', filters: 'none'],
        [pattern: '/**/css/**', filters: 'none'],
        [pattern: '/**/images/**', filters: 'none'],
        [pattern: '/**/favicon.ico', filters: 'none'],
]

