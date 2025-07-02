package com.techieblossom.kfcm.data

import android.util.Log
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.Dispatchers

val supabaseConstants = SupabaseConstants()

class SupabaseConstants {
    companion object {
        const val supabaseURL = "<ADD_YOURS>"
        const val supabaseKey =
            "<ADD_YOURS>"
    }

    fun getClient() = createSupabaseClient(
        supabaseKey = supabaseKey,
        supabaseUrl = supabaseURL
    ) {
        install(Postgrest)
    }
}

suspend fun getData() {
    val client = supabaseConstants.getClient()
    val response = client.postgrest["table_league"].select()
    val leagues = response.decodeList<League>()
    Log.i("Leagues", leagues.toString())
}

@kotlinx.serialization.Serializable
data class League(
    val id: Int?,
    val nation: String?,
    val name: String?,
)
