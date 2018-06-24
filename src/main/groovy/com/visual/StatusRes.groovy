package com.visual

import com.fasterxml.jackson.annotation.JsonInclude

class StatusRes {
    def statusCode

    @JsonInclude(JsonInclude.Include.NON_NULL)
    def success

    @JsonInclude(JsonInclude.Include.NON_NULL)
    def error

    def description
    def response
}
