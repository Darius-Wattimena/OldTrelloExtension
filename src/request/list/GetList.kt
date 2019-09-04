package com.example.request.list

import com.example.TrelloCall
import com.example.helper.JsonHelper
import com.example.helper.Request
import com.example.request.BaseTrelloRequest
import com.example.trello.model.List

class GetList(private val request: Request): BaseTrelloRequest<List>() {
    val call = TrelloCall(request.GetKey(), request.GetToken())

    override fun prepare() {
        call.request = "lists/${request.id}"
    }

    override suspend fun execute(): List {
        return JsonHelper.fromJson(gson, call, client, List::class.java)
    }
}