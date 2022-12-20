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

    @objc public func uploadResource(resourceType: String, path: String, uploadPreset: String, publicId: String?, completion: @escaping (CLDUploadResult?, String?) -> Void) {
        guard let url = self.getFileUrlByPath(path) else {
            completion(nil, plugin.errorFileNotFound)
            return
        }
        let params: CLDUploadRequestParams = CLDUploadRequestParams()
        if let publicId = publicId {
            params.setPublicId(publicId)
        }
        self.cloudinary?.createUploader().uploadLarge(url: url, uploadPreset: uploadPreset, params: params, preprocessChain: CLDImagePreprocessChain()) { (progress) in
            print(progress.fractionCompleted)
        } completionHandler: { (resultData, error) in
            if let error = error {
                completion(nil, error.description)
                return
            }
            completion(resultData, nil)
        }
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
