package com.techieblossom.kfcm.data

import android.util.Log
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.Dispatchers

val constants = Constants()

class Constants {
    companion object {
        const val SUPABASE_URL = "https://muvntiyztalheltppvrn.supabase.co"
        const val SUPABASE_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Im11dm50aXl6dGFsaGVsdHBwdnJuIiwicm9sZSI6ImFub24iLCJpYXQiOjE2ODEzODE3ODAsImV4cCI6MTk5Njk1Nzc4MH0.jiJ4cdz1dnvMFO-HWPXxlcJstkAQeeJsztu8xbFfgLg"
    }

    fun getClient() = createSupabaseClient(
        supabaseKey = SUPABASE_KEY,
        supabaseUrl = SUPABASE_URL
    ) {
        install(Postgrest)
    }
}

suspend fun getData() {
    with(Dispatchers.IO) {
        val client = constants.getClient()
        val response = client.postgrest["table_league"].select()
        val leagues = response.decodeList<League>()
        Log.i("Leagues", leagues.toString())
    }
}

@kotlinx.serialization.Serializable
data class League(
    val id: Int?,
    val nation: String?,
    val name: String?
)