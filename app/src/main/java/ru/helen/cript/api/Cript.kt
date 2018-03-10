package ru.helen.cript.api

import com.google.gson.annotations.SerializedName

/**
 * model for response
 */
data class Cript(
        @SerializedName("id")
        var id: String,
        @SerializedName("name")
        var name: String,
        @SerializedName("symbol")
        var symbol: String,
        @SerializedName("rank")
        var rank: String,
        @SerializedName("price_usd")
        var priceUsd: String,
        @SerializedName("price_btc")
        var priceBtc: String,
        @SerializedName("24h_volume_usd")
        var volumeUsd24h: String,
        @SerializedName("market_cap_usd")
        var marketCapUsd: String,
        @SerializedName("available_supply")
        var availableSupply: String,
        @SerializedName("total_supply")
        var totalSupply: String,
        @SerializedName("max_supply")
        var maxSupply: String,
        @SerializedName("percent_change_1h")
        var percentChange1h: String,
        @SerializedName("percent_change_24h")
        var percentChange24h: String,
        @SerializedName("percent_change_7d")
        var percentChange7d: String,
        @SerializedName("last_updated")
        var lastUpdated: String,
        @SerializedName("price_rub")
        var priceRub: String,
        var color1h: Int,
        var color24h: Int,
        var color7d: Int

)

