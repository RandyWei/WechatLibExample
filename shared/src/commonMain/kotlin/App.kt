import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import icu.bughub.kit.multiplatform.wechat.BaseReq
import icu.bughub.kit.multiplatform.wechat.BaseResp
import icu.bughub.kit.multiplatform.wechat.EventHandler
import icu.bughub.kit.multiplatform.wechat.MediaMessage
import icu.bughub.kit.multiplatform.wechat.MiniProgramType
import icu.bughub.kit.multiplatform.wechat.TextObject
import icu.bughub.kit.multiplatform.wechat.WXScene
import icu.bughub.kit.multiplatform.wechat.Wechat
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class, ExperimentalMaterial3Api::class)
@Composable
fun App() {

    Wechat.addEventHandler(object : EventHandler {
        override fun onReq(req: BaseReq) {
            println(req)
        }

        override fun onResp(resp: BaseResp) {
            println(resp)
        }
    })

    MaterialTheme {
        Scaffold(topBar = { LargeTopAppBar(title = { Text("微信开放SDK Example") }) }) {
            LazyColumn(
                Modifier.fillMaxWidth().padding(it),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                item {
                    Button({
                        val message = MediaMessage()
                        message.mediaObject = TextObject("示例文本")
                        message.title = "分享文本"
                        Wechat.share(message, WXScene.Session)
                    },Modifier.fillMaxWidth()) {
                        Text("分享文本")
                    }
                }

                item {
                    Button({
                        Wechat.pay("", "", "", "", "", 0u, "")
                    },Modifier.fillMaxWidth()) {
                        Text("支付")
                    }
                }

                item {
                    Button({
                        Wechat.auth()
                    },Modifier.fillMaxWidth()) {
                        Text("微信登录")
                    }
                }

                item {
                    Button({
                        Wechat.launchMiniProgram("", MiniProgramType.Release)
                    },Modifier.fillMaxWidth()) {
                        Text("拉起小程序")
                    }
                }

                item {
                    Button({
                        Wechat.launchCustomerService("", "")
                    },Modifier.fillMaxWidth()) {
                        Text("拉起微信客服")
                    }
                }

                item {
                    Button({
                        Wechat.launch()
                    },Modifier.fillMaxWidth()) {
                        Text("拉起微信")
                    }
                }

            }
        }
    }
}

expect fun getPlatformName(): String