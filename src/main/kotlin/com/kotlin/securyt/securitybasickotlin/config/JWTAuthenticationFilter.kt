//package com.kotlin.securyt.securitybasickotlin.config
//
//import org.springframework.security.core.Authentication
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
//import javax.servlet.FilterChain
//import javax.servlet.http.HttpServletRequest
//import javax.servlet.http.HttpServletResponse
//
//class JWTAuthenticationFilter : UsernamePasswordAuthenticationFilter() {
//
//    @Throws(Exception::class)
//    override fun attemptAuthentication(request: HttpServletRequest, response: HttpServletResponse): Authentication {
//
//        return super.attemptAuthentication(request, response)
//    }
//
//     override fun successfulAuthentication(request: HttpServletRequest, response: HttpServletResponse,
//                                           chain: FilterChain, authResult: Authentication) {
//        super.successfulAuthentication(request, response, chain, authResult)
//    }
//}