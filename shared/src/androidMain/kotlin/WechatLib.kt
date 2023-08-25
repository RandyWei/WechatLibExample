import android.content.Context
import icu.bughub.kit.multiplatform.wechat.Wechat

object WechatLib {
    /**
     * 注册app到微信
     *
     * @param context
     * @param appID
     */
    fun register(context: Context, appID: String) {
        Wechat.register(context, appID)
    }
}