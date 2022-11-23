package io.capawesome.capacitorjs.plugins.cloudinary;

public interface UploadResourceResultCallback {
    void success();
    void error(String message);
}
