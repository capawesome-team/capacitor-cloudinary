import Foundation

@objc public class Cloudinary: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
