package io.openhoyolab.lab.network

import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.converter.Converter
import de.jensklingenberg.ktorfit.converter.KtorfitResult
import de.jensklingenberg.ktorfit.converter.TypeData
import io.ktor.client.statement.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject

/**
 * 用于 Ktorfit 将响应内容转换为 JsonObject 的转换器
 * Converter to convert response from Ktorfit to JsonObject
 */
class JsonObjectResponseConverter : Converter.Factory {

    override fun suspendResponseConverter(
        typeData: TypeData,
        ktorfit: Ktorfit
    ): Converter.SuspendResponseConverter<HttpResponse, *>? {
        /**
         * 检查所需的结果为 JsonObject
         * Check if the required type is JsonObject
         */
        if (typeData.typeInfo.type == JsonObject::class) {
            return object : Converter.SuspendResponseConverter<HttpResponse, Any> {
                override suspend fun convert(result: KtorfitResult): Any {
                    /**
                     * 如果响应结果为成功，则返回解析的 JsonObject，否则为一个空的 JsonObject
                     * If response result is success, return decoded JsonObject, else empty JsonObject
                     */
                    return if (result is KtorfitResult.Success) {
                        Json.decodeFromString<JsonObject>(result.response.bodyAsText())
                    } else {
                        JsonObject(emptyMap())
                    }
                }
            }
        }
        return null
    }

}