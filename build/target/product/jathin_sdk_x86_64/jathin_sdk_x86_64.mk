# Inherit from sdk_phone_x86_64, we are not creating anything from scratch, we copy all the config files from sdk_phone_x86_64, override and add customized features, like adding Myapp.
$(call inherit-product, $(SRC_TARGET_DIR)/product/sdk_phone_x86_64.mk)

# Identity
PRODUCT_NAME := jathin_sdk_x86_64
PRODUCT_DEVICE := emulator_x86_64		#my target.
PRODUCT_BRAND := android
PRODUCT_MODEL := "Jathin Custom SDK x86_64"
PRODUCT_MANUFACTURER := AOSP

# Include your app
PRODUCT_PACKAGES += MyApp
