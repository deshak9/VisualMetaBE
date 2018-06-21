// Place your Spring DSL code here
beans = {
    testService(TestService) {
        grailsApplication = ref('grailsApplication')
    }
}
