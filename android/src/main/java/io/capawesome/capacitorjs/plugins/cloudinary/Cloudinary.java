package io.capawesome.capacitorjs.plugins.cloudinary;

import com.cloudinary.android.MediaManager;

import java.util.HashMap;

public class Cloudinary {

    private CloudinaryPlugin plugin;

    public Cloudinary(CloudinaryPlugin plugin) {
        this.plugin = plugin;
        MediaManager.init(plugin.getContext());
    }

    public void upload(HashMap options) {
        String requestId = MediaManager.get().upload("imageFile.jpg")
                .unsigned(uploadPreset)
                .options(options)
                .dispatch();
    }
}
