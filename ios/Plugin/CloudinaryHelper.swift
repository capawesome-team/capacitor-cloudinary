import Foundation
import Cloudinary
import Capacitor

public class CloudinaryHelper {

    public static func createUploadResourceResult(_ resultData: CLDUploadResult) -> JSObject {
        var result = JSObject()
        result["createdAt"] = resultData.createdAt
        result["format"] = resultData.format
        result["width"] = resultData.width
        result["height"] = resultData.height
        result["originalFilename"] = resultData.originalFilename
        result["resourceType"] = resultData.resourceType
        result["publicId"] = resultData.publicId
        result["url"] = resultData.url
        return result
    }
}
