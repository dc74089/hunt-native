//
//  StatusBarUtils.swift
//  iosApp
//
//  Created by Dominic Canora on 5/27/25.
//

// In iosApp/iosApp/StatusBarUtils.swift

import Foundation
import UIKit

// Make the class and function accessible to Objective-C and thus Kotlin/Native
// by marking them with @objc.
// You can also give them specific names for the Objective-C runtime.
@objcMembers // Makes all members @objc, or use @objc for specific methods
public class StatusBarHelper: NSObject { // Must inherit from NSObject

    @objc public func setStatusBarColor(hexColor: String, alpha: Double) {
        guard let color = UIColor(hex: hexColor, alpha: CGFloat(alpha)) else {
            print("Invalid hex color string")
            return
        }

        DispatchQueue.main.async { // Ensure UI updates are on the main thread
            if #available(iOS 13.0, *) {
                let scenes = UIApplication.shared.connectedScenes
                let windowScene = scenes.first as? UIWindowScene
                guard let window = windowScene?.windows.first(where: { $0.isKeyWindow }) else {
                    print("Could not get key window")
                    return
                }

                // Remove existing custom status bar view if any
                window.viewWithTag(12345)?.removeFromSuperview()

                let statusBarManager = window.windowScene?.statusBarManager
                if let statusBarFrame = statusBarManager?.statusBarFrame, statusBarFrame.height > 0 {
                    let statusBarView = UIView(frame: statusBarFrame)
                    statusBarView.backgroundColor = color
                    statusBarView.tag = 12345 // Tag to find and remove later if needed
                    window.addSubview(statusBarView)
                } else {
                    print("Could not get status bar frame or height is zero")
                }

            } else {
                // Fallback for older iOS versions
                if let statusBar = UIApplication.shared.value(forKeyPath: "statusBarWindow.statusBar") as? UIView {
                    statusBar.backgroundColor = color
                }
            }
        }
    }
}

// Helper extension for UIColor to initialize from hex (optional, but useful)
// Ensure this is also accessible or reimplement logic on the Swift side.
public extension UIColor {
    convenience init?(hex: String, alpha: CGFloat = 1.0) {
        var hexSanitized = hex.trimmingCharacters(in: .whitespacesAndNewlines)
        hexSanitized = hexSanitized.replacingOccurrences(of: "#", with: "")

        var rgb: UInt64 = 0

        guard Scanner(string: hexSanitized).scanHexInt64(&rgb) else {
            return nil
        }

        let red = CGFloat((rgb & 0xFF0000) >> 16) / 255.0
        let green = CGFloat((rgb & 0x00FF00) >> 8) / 255.0
        let blue = CGFloat(rgb & 0x0000FF) / 255.0

        self.init(red: red, green: green, blue: blue, alpha: alpha)
    }
}
