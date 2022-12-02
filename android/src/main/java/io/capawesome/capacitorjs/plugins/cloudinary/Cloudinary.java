package io.capawesome.capacitorjs.plugins.cloudinary;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.cloudinary.android.MediaManager;
import com.cloudinary.android.UploadRequest;
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
        @Nullable String publicId,
        UploadResourceResultCallback callback
    ) {
        UploadRequest request = MediaManager.get().upload(Uri.parse(path)).unsigned(uploadPreset).option("resource_type", resourceType);
        if (publicId != null) {
            request.option("public_id", publicId);
        }
        request
            .callback(
                new UploadCallback() {
                    @Override
                    public void onStart(String requestId) {}

                    @Override
                    public void onProgress(String requestId, long bytes, long totalBytes) {}

                    @Override
                    public void onSuccess(String requestId, Map resultData) {
                        callback.success(resultData);
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
