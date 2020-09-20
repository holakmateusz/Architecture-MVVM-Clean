package com.example.mvvmcleanarchitecture.core.exception

interface ErrorWrapper {
    fun wrap(throwable: Throwable): Throwable
}