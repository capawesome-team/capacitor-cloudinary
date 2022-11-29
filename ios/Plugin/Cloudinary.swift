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

    @objc public func uploadResource(resourceType: String, path: String, uploadPreset: String, publicId: String, completion: @escaping (String?) -> Void) {
        guard let url = self.getFileUrlByPath(path) else {
            completion(plugin.errorFileNotFound)
            return
        }
        let params: CLDUploadRequestParams = CLDUploadRequestParams().setPublicId(publicId)
        self.cloudinary?.createUploader().upload(url: url, uploadPreset: uploadPreset, params: params, completionHandler: { _, error in
            if let error = error {
                completion(error.description)
                return
            }
            completion(nil)
        })
    }

    @objc private func getFileUrlByPath(_ path: String) -> URL? {
        guard let url = URL.init(string: path) else {
            return nil
        }
        if FileManager.default.fileExists(atPath: url.path) {
            return url
        } else {
            return nil
        }
    }
}
