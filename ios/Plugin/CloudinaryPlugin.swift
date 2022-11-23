import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(CloudinaryPlugin)
public class CloudinaryPlugin: CAPPlugin {
    public let errorCloudNameMissing = "cloudName must be provided."

    private var implementation: Cloudinary?

    override public func load() {
        implementation = Cloudinary(plugin: self)
    }

    @objc func initialize(_ call: CAPPluginCall) {
        guard let cloudName = call.getString("cloudName") else {
            call.reject(errorCloudNameMissing)
            return
        }
        implementation?.initialize(cloudName)
        call.resolve()
    }
}
