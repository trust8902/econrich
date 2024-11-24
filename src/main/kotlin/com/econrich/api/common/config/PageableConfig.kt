package com.econrich.api.common.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class PageableConfig : WebMvcConfigurer {

    @Bean
    fun pageableCustomizer(): PageableHandlerMethodArgumentResolverCustomizer {
        return PageableHandlerMethodArgumentResolverCustomizer { resolver ->
            resolver.setOneIndexedParameters(true)
        }
    }

}