package io.capawesome.capacitorjs.plugins.cloudinary;

import com.getcapacitor.JSObject;
import java.util.Map;

public class CloudinaryHelper {

    public static JSObject createUploadResourceResult(Map resultData) {
        JSObject result = new JSObject();
        result.put("assetId", resultData.get("asset_id"));
        result.put("bytes", resultData.get("bytes"));
        result.put("createdAt", resultData.get("created_at"));
        result.put("format", resultData.get("format"));
        result.put("originalFilename", resultData.get("original_filename"));
        result.put("resourceType", resultData.get("resource_type"));
        result.put("publicId", resultData.get("public_id"));
        result.put("url", resultData.get("url"));
        return result;
    }
}
