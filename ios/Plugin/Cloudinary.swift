import Foundation
import Cloudinary

@objc public class Cloudinary: NSObject {
    private let plugin: CloudinaryPlugin
    private var cloudinary: CLDCloudinary?
    
    init(plugin: CloudinaryPlugin) {
        self.plugin = plugin
    }
    
    @objc public func initialize(_ cloudName: String) {
        let config = CLDConfiguration(cloudName: cloudName, secure: true)
        self.cloudinary = CLDCloudinary(configuration: config)
    }
}
