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
        String uploadPreset = call.getString("uploadPreset");
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
                public void success() {
                    call.resolve();
                }

                @Override
                public void error(String message) {
                    call.reject(message);
                }
            }
        );
    }
}
