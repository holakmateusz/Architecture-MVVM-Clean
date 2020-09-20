package com.example.mvvmcleanarchitecture.core.exception

interface ErrorMapper {
    fun map(throwable: Throwable): String
}