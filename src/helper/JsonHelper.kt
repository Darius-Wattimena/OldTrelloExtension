package com.example.helper

import com.google.gson.Gson
import io.ktor.client.HttpClient
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature

class JsonHelper {
    companion object {
        suspend fun <T> fromJson(gson: Gson, call: TrelloCall, client: HttpClient, clazz: Class<T>): T {
            return gson.fromJson(call.execute(client), clazz)
        }

        fun client(): HttpClient = HttpClient {
            install(JsonFeature) {
                serializer = GsonSerializer()
            }
        }
    }
}