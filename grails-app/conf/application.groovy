grails.plugin.emailAlert.onlySixWeeks = true
//grails.plugin.springsecurity.useBasicAuth = false
grails.plugin.springsecurity.filterChain.chainMap = [
        [pattern: '/api/users/**', filters: 'JOINED_FILTERS'],
        [pattern: '/**', filters: 'none']
]
