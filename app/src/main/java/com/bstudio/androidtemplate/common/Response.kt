package com.bstudio.androidtemplate.common


data class Response<out T>(val status: Status, val data: T?, val error: Throwable?) {

    companion object {
        fun <T> success(data: T?) : Response<T> {
            return Response(Status.SUCCESS, data, null)
        }

        fun <T> error(error: Throwable) : Response<T> {
            return Response(Status.ERROR, null, error)
        }

        fun <T> loading() : Response<T> {
            return Response(Status.LOADING, null, null)
        }
    }

}

enum class Status {
    LOADING,
    SUCCESS,
    ERROR
}