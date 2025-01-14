package io.openhoyolab.lab.entity.miyoushe.auth

/**
 * 用户验证结果
 * User authorization result
 */
sealed interface Authorization {

    /**
     * 未验证，单例，无数据
     * Unauthorized, an object, no information
     */
    object Unauthorized : Authorization

    /**
     * 已验证，基本用户信息如 uid，用户名等
     * Authorized, basic user data like uid, username, etc.
     */
    class Authorized : Authorization {

    }

}