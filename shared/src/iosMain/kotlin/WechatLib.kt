import icu.bughub.kit.multiplatform.wechat.Wechat
import platform.Foundation.NSURL
import platform.Foundation.NSUserActivity

object WechatLib {
    fun register(appID: String, universalLink: String) {
        Wechat.register(appID, universalLink)
    }

    fun handleOpenUrl(url: NSURL): Boolean = Wechat.handleOpenUrl(url)

    fun handleOpenUniversalLink(userActivity: NSUserActivity): Boolean =
        Wechat.handleOpenUniversalLink(userActivity)
}