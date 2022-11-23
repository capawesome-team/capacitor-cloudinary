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

    public static final String ERROR_CLOUD_NAME_MISSING = "cloudName must be provided.";
    public static final String ERROR_NOT_INITIALIZED = "Plugin is not initialized.";

    private Cloudinary implementation;
    private boolean initialized = false;

    public void load() {
        implementation = new Cloudinary(this);
    }

    @PluginMethod
    public void initialize(PluginCall call) {
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
        String filePath = call.getString("path");
        String publicId = call.getString("publicId");

        HashMap options = new HashMap();
        options.put("public_id", publicId);
        options.put("resource_type", resourceType);

        implementation.uploadResource(
            filePath,
            uploadPreset,
            options,
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
