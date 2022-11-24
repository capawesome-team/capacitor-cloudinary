package io.capawesome.capacitorjs.plugins.cloudinary;

import com.cloudinary.android.MediaManager;
import com.cloudinary.android.callback.ErrorInfo;
import com.cloudinary.android.callback.UploadCallback;
import java.util.HashMap;
import java.util.Map;

public class Cloudinary {

    private CloudinaryPlugin plugin;

    public Cloudinary(CloudinaryPlugin plugin) {
        this.plugin = plugin;
    }

    public void initialize(String cloudName) {
        HashMap config = new HashMap();
        config.put("cloud_name", cloudName);
        config.put("secure", true);
        MediaManager.init(plugin.getContext(), config);
    }

    public void uploadResource(
        String resourceType,
        String path,
        String uploadPreset,
        String publicId,
        UploadResourceResultCallback callback
    ) {
        HashMap options = new HashMap();
        options.put("public_id", publicId);
        options.put("resource_type", resourceType);
        MediaManager
            .get()
            .upload(path)
            .unsigned(uploadPreset)
            .options(options)
            .callback(
                new UploadCallback() {
                    @Override
                    public void onStart(String requestId) {}

                    @Override
                    public void onProgress(String requestId, long bytes, long totalBytes) {}

                    @Override
                    public void onSuccess(String requestId, Map resultData) {
                        callback.success();
                    }

                    @Override
                    public void onError(String requestId, ErrorInfo error) {
                        callback.error(error.getDescription());
                    }

                    @Override
                    public void onReschedule(String requestId, ErrorInfo error) {}
                }
            )
            .dispatch();
    }
}
