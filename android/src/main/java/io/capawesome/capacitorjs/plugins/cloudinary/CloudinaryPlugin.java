package io.capawesome.capacitorjs.plugins.cloudinary;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import java.util.HashMap;
import java.util.Map;

@CapacitorPlugin(name = "Cloudinary")
public class CloudinaryPlugin extends Plugin {

    public static final String ERROR_NOT_INITIALIZED = "Plugin is not initialized.";
    public static final String ERROR_CLOUD_NAME_MISSING = "cloudName must be provided.";
    public static final String ERROR_PATH_MISSING = "path must be provided.";
    public static final String ERROR_RESOURCE_TYPE_MISSING = "resourceType must be provided.";
    public static final String ERROR_UPLOAD_PRESET_MISSING = "uploadPreset must be provided.";

    private Cloudinary implementation;
    private boolean initialized = false;

    public void load() {
        implementation = new Cloudinary(this);
    }

    @PluginMethod
    public void initialize(PluginCall call) {
        if (initialized) {
            return;
        }
        String cloudName = call.getString("cloudName");
        if (cloudName == null) {
            call.reject(ERROR_CLOUD_NAME_MISSING);
            return;
        }

        implementation.initialize(cloudName);
        initialized = true;
        call.resolve();
    }

    @PluginMethod
    public void uploadResource(PluginCall call) {
        if (!initialized) {
            call.reject(ERROR_NOT_INITIALIZED);
            return;
        }
        String resourceType = call.getString("resourceType");
        if (resourceType == null) {
            call.reject(ERROR_RESOURCE_TYPE_MISSING);
            return;
        }
        String uploadPreset = call.getString("uploadPreset");
        if (uploadPreset == null) {
            call.reject(ERROR_UPLOAD_PRESET_MISSING);
            return;
        }
        String path = call.getString("path");
        if (path == null) {
            call.reject(ERROR_PATH_MISSING);
            return;
        }
        String publicId = call.getString("publicId");

        implementation.uploadResource(
            resourceType,
            path,
            uploadPreset,
            publicId,
            new UploadResourceResultCallback() {
                @Override
                public void success(Map resultData) {
                    JSObject result = CloudinaryHelper.createUploadResourceResult(resultData);
                    call.resolve(result);
                }

                @Override
                public void error(String message) {
                    call.reject(message);
                }
            }
        );
    }
}
