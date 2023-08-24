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
        
        return true
    }
    
}
