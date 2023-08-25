//
//  AppDelegate.swift
//  iosApp
//
//  Created by RandyWei on 2023/8/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import UIKit
import shared

@main
class AppDelegate: UIResponder,UIApplicationDelegate {
    
    var window: UIWindow?
    
    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey : Any]? = nil) -> Bool {
        
        window = UIWindow()
        window?.rootViewController = Main_iosKt.MainViewController()
        window?.makeKeyAndVisible()
        //("wxdab815a00288fddd", "https://applinks.shituzaixian.com/app/")
        
        return true
    }
    
    func application(_ application: UIApplication, handleOpen url: URL) -> Bool {
        return WechatLib.shared.handleOpenUrl(url:url)
    }

    func application(_ application: UIApplication, open url: URL, sourceApplication: String?, annotation: Any) -> Bool {
        return WechatLib.shared.handleOpenUrl(url:url)
    }

    func application(_ application: UIApplication, continue userActivity: NSUserActivity, restorationHandler: @escaping ([UIUserActivityRestoring]?) -> Void) -> Bool {
        return WechatLib.shared.handleOpenUniversalLink(userActivity:userActivity)
    }
    
}
