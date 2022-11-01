package br.com.goulart.csgo.data.match.remote

import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor : Interceptor {

    private val pandaScoreKey = "UkNYzKLC18fCBeCdgLmp2JO-LXMoK_YdQ3WGoRF5WCDOf2OOdoI"

    @Synchronized
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        val requestBuilder = request.newBuilder().apply {
            header("accept", "application/json")
            header("authorization", "Bearer $pandaScoreKey")
        }

        request = requestBuilder.build()
        return chain.proceed(request)
    }
}