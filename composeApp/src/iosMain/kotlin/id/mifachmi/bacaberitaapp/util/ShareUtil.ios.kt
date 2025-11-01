package id.mifachmi.bacaberitaapp.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import platform.UIKit.UIActivityViewController
import platform.UIKit.UIApplication
import platform.UIKit.UIViewController
import platform.UIKit.UIWindow
import platform.UIKit.popoverPresentationController

/**
 * A cleaner way to get the top-most UIViewController.
 * It iterates through the view controller hierarchy to find the one currently visible.
 */
private fun getTopViewController(): UIViewController? {
    // Get the key window, which is the one receiving events.
    val keyWindow = UIApplication.sharedApplication.windows.firstOrNull { (it as? UIWindow)?.isKeyWindow() == true } as? UIWindow
        ?: return null // Return null if no key window is found

    var topController = keyWindow.rootViewController
    // Traverse up the hierarchy of presented view controllers
    while (topController?.presentedViewController != null) {
        topController = topController.presentedViewController
    }
    return topController
}

@Composable
actual fun rememberShareHandler(): ShareHandler {
    return remember {
        object : ShareHandler {
            override fun shareText(text: String, chooserTitle: String?) {
                // Create the UIActivityViewController with the text to share.
                val activityViewController = UIActivityViewController(
                    activityItems = listOf(text), // The items to share (e.g., text, URLs, images).
                    applicationActivities = null // No custom app activities.
                )

                // Get the top-most view controller to present the share sheet on.
                val topViewController = getTopViewController()

                // Anchor the popover to the view for iPad to prevent crashes.
                activityViewController.popoverPresentationController?.sourceView = topViewController?.view

                // Present the share sheet.
                topViewController?.presentViewController(
                    viewControllerToPresent = activityViewController,
                    animated = true,
                    completion = null
                )
            }
        }
    }
}
